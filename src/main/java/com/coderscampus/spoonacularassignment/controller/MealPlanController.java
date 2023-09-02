package com.coderscampus.spoonacularassignment.controller;
import com.coderscampus.spoonacularassignment.model.dto.DayPlan;
import com.coderscampus.spoonacularassignment.model.dto.SpoonacularMealPlanResponse;
import com.coderscampus.spoonacularassignment.model.dto.WeekPlan;
import com.coderscampus.spoonacularassignment.service.MealPlanService;
import com.coderscampus.spoonacularassignment.service.UriBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@ComponentScan
@RestController
@RequestMapping("/mealplanner") // Optional: Define a base URL for the controller
public class MealPlanController {
    private final RestTemplate restTemplate;
    private final UriBuilderService uriBuilderService;
    private final MealPlanService mealPlanService;

    @Autowired
    public MealPlanController(RestTemplate restTemplate,
                              UriBuilderService uriBuilderService,
                              MealPlanService mealPlanService) {
        this.restTemplate = restTemplate;
        this.uriBuilderService = uriBuilderService;
        this.mealPlanService = mealPlanService;
    }

    @GetMapping("/week")
    public ResponseEntity<WeekPlan> getWeekMeals(String numCalories, String diet, String exclusions){
        return null;
    }

    @GetMapping("/day")
    public ResponseEntity<DayPlan> getDayMeals(String numCalories, String diet, String exclusions){
        return null;
    }
}
