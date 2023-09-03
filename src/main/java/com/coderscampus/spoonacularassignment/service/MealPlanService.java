package com.coderscampus.spoonacularassignment.service;

import com.coderscampus.spoonacularassignment.model.dto.DayPlan;
import com.coderscampus.spoonacularassignment.model.dto.MealPlan;
import com.coderscampus.spoonacularassignment.model.dto.WeekPlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MealPlanService {
    private final String SPOONACULAR_API_BASE_URL = "https://api.spoonacular.com/";
    private final String SPOONACULAR_API_GENERATE_MEALPLAN_URL = "mealplanner/generate";
    private final RestTemplate restTemplate;

    @Autowired
    public MealPlanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public WeekPlan createWeekPlan(String numCalories, String diet, String exclusions) throws Exception{
        String jsonString = getJsonFromSpoonacular("week", numCalories, diet, exclusions);
        convertJsonStringToMealPlan(jsonString);
        return null;
    }
    public DayPlan createDayPlan(String numCalories, String diet, String exclusions) throws Exception{
        String jsonString = getJsonFromSpoonacular("day", numCalories, diet, exclusions);
        convertJsonStringToMealPlan(jsonString);
        return null;
    }


    public String getJsonFromSpoonacular(String timeFrame, String numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(SPOONACULAR_API_BASE_URL)
                .path(SPOONACULAR_API_GENERATE_MEALPLAN_URL)
                .queryParam("timeFrame", timeFrame)
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> mealPlan = restTemplate.getForEntity(uri, String.class);

        return mealPlan.getBody();
    }
    public MealPlan convertJsonStringToMealPlan(String jsonString) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(jsonString, MealPlan.class);
        String jsonStringViaObjectMapper = objectMapper.writeValueAsString(jsonString);
    }
}