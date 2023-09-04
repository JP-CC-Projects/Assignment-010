package com.coderscampus.spoonacularassignment.service;
import com.coderscampus.spoonacularassignment.model.dto.DayPlan;
import com.coderscampus.spoonacularassignment.model.dto.WeekPlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Service
public class MealPlanService {
    @Value("${apiKey}")
    private String apiKey;
    private final String SPOONACULAR_API_BASE_URL = "https://api.spoonacular.com/";
    private final String SPOONACULAR_API_GENERATE_MEALPLAN_URL = "mealplanner/generate";
    private final RestTemplate restTemplate;

    @Autowired
    public MealPlanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeekPlan createWeekPlan(String numCalories, String diet, String exclusions) throws Exception{
        String weekPlanJsonString = getJsonFromSpoonacular("week", numCalories, diet, exclusions);
        WeekPlan newWeekPlan = convertJsonStringToWeekPlanObject(weekPlanJsonString);
        return newWeekPlan;
    }
    public DayPlan createDayPlan(String numCalories, String diet, String exclusions) throws Exception{
        String dayPlanJsonString = getJsonFromSpoonacular("day", numCalories, diet, exclusions);
        DayPlan newDayPlan = convertJsonStringToDayPlanObject(dayPlanJsonString);
        return newDayPlan;
    }

    public String getJsonFromSpoonacular(String timeFrame, String numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(SPOONACULAR_API_BASE_URL)
                .path(SPOONACULAR_API_GENERATE_MEALPLAN_URL)
                .queryParam("apiKey", apiKey)
                .queryParam("timeFrame", timeFrame)
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build()
                .toUri();
        ResponseEntity<String> mealPlanJsonResponse = restTemplate.getForEntity(uri, String.class);
        return mealPlanJsonResponse.getBody();
    }
    public WeekPlan convertJsonStringToWeekPlanObject(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        WeekPlan weekPlan = objectMapper.readValue(jsonString, WeekPlan.class);
        return weekPlan;
    }
    public DayPlan convertJsonStringToDayPlanObject(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        DayPlan dayPlan = objectMapper.readValue(jsonString, DayPlan.class);
        return dayPlan;
    }
}