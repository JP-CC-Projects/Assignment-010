package com.coderscampus.spoonacularassignment.service;
import com.coderscampus.spoonacularassignment.model.dto.SpoonacularMealPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@Service
public class MealPlanService {
    private final String SPOONACULAR_API_BASE_URL = "https://api.spoonacular.com/";
    private final String SPOONACULAR_API_GENERATE_MEALPLAN_URL = "mealplanner/generate";
    private final RestTemplate restTemplate;

    @Autowired
    public MealPlanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateMealPlan(String timeFrame){
        getJsonFromSpoonacular(SPOONACULAR_API_BASE_URL, SPOONACULAR_API_GENERATE_MEALPLAN_URL, timeFrame);

        return getJsonFromSpoonacular(SPOONACULAR_API_BASE_URL, SPOONACULAR_API_GENERATE_MEALPLAN_URL, timeFrame);
    }

    public List<SpoonacularMealPlanResponse> getMealPlans(){
        ResponseEntity<List<SpoonacularMealPlanResponse>> exchange = restTemplate.exchange(SPOONACULAR_API_BASE_URL,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<SpoonacularMealPlanResponse>>(){});
        return exchange.getBody();
    }
    public String getJsonFromSpoonacular(String baseUrl, String appendedUrl, String timeFrame){
        URI uri = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path(appendedUrl)
                .queryParam("timeFrame", timeFrame)
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> mealPlan = restTemplate.getForEntity(uri, String.class);

        return mealPlan.getBody();
    }
}