package com.coderscampus.spoonacularassignment.service;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Service
public class UriBuilderService {
    private static final String SPOONACULAR_API_BASE_URL = "https://api.spoonacular.com/";
    private static final String SPOONACULAR_API_GENERATE_MEALPLAN_URL = "mealplanner/generate";

    public URI buildUri() {
        return UriComponentsBuilder
                .fromHttpUrl(SPOONACULAR_API_BASE_URL)
                .path(SPOONACULAR_API_GENERATE_MEALPLAN_URL)
                .queryParam("apiKey", "asdf")
                .queryParam("timeFrame", "day")
                .build()
                .toUri();
    }
}
