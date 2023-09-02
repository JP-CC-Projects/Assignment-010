package com.coderscampus.spoonacularassignment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class Main {
    private static final String SPOONACULAR_API_BASE_URL = "https://api.spoonacular.com/";
    private static final String SPOONACULAR_API_GENERATE_MEALPLAN_URL = "mealplanner/generate";
    private final RestTemplate restTemplate;
    public Main(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void main (String[] args){
        getJsonFromSpoonacular(SPOONACULAR_API_BASE_URL, SPOONACULAR_API_GENERATE_MEALPLAN_URL);
    }
    public static String getJsonFromSpoonacular(String baseUrl, String appendedUrl){
        URI uri = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path(appendedUrl)
                .queryParam("apiKey", "4h5whstr")
                .queryParam("timeFrame", "day")
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> mealPlan = restTemplate.getForEntity(uri, String.class);

        System.out.println(mealPlan.getBody());
        return mealPlan.getBody();
    }
}
