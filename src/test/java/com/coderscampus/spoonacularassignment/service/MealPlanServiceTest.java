package com.coderscampus.spoonacularassignment.service;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

class MealPlanServiceTest {

    @Test
    public String getJsonFromSpoonacular(String baseUrl, String appendedUrl){
        URI uri = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path(appendedUrl)
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> mealPlan = restTemplate.getForEntity(uri, String.class);

        return mealPlan.getBody();
    }
}