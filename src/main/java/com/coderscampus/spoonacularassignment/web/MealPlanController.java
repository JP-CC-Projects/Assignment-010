package com.coderscampus.spoonacularassignment.web;

import com.coderscampus.spoonacularassignment.model.dto.DayResponse;
import com.coderscampus.spoonacularassignment.model.dto.WeekResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@ComponentScan

@Controller
public class MealPlanController {


    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){
        return null;
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions){
        return null;
    }
}
