package com.coderscampus.spoonacularassignment.service;

import com.coderscampus.spoonacularassignment.SpoonacularApiConfigProperties;
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
    private final RestTemplate restTemplate;
    private final SpoonacularApiConfigProperties spoonacularApiConfigProperties;

    @Autowired
    public MealPlanService(RestTemplate restTemplate, SpoonacularApiConfigProperties spoonacularApiConfigProperties) {
        this.restTemplate = restTemplate;
        this.spoonacularApiConfigProperties = spoonacularApiConfigProperties;
    }


    public WeekPlan createWeekPlan(String numCalories, String diet, String exclusions) throws Exception {
        String weekPlanJsonString = getJsonFromSpoonacular("week", numCalories, diet, exclusions);
        WeekPlan newWeekPlan = convertJsonStringToWeekPlanObject(weekPlanJsonString);
        return newWeekPlan;
    }

    public DayPlan createDayPlan(String numCalories, String diet, String exclusions) throws Exception {
        String dayPlanJsonString = getJsonFromSpoonacular("day", numCalories, diet, exclusions);
        DayPlan newDayPlan = convertJsonStringToDayPlanObject(dayPlanJsonString);
        return newDayPlan;
    }

    public String getJsonFromSpoonacular(String timeFrame, String numCalories, String diet, String exclusions) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(spoonacularApiConfigProperties.getBase())
                .path(spoonacularApiConfigProperties.getMealplan())
                .queryParam("apiKey", apiKey)
                .queryParam("timeFrame", timeFrame);
        if (numCalories != null && !numCalories.isEmpty()) {
            builder.queryParam("targetCalories", numCalories);
        }

        if (diet != null && !diet.isEmpty()) {
            builder.queryParam("diet", diet);
        }

        if (exclusions != null && !exclusions.isEmpty()) {
            builder.queryParam("exclude", exclusions);
        }
        URI uri = builder.build().toUri();
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