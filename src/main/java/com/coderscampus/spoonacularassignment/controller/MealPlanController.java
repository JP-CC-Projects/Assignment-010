package com.coderscampus.spoonacularassignment.controller;
import com.coderscampus.spoonacularassignment.model.dto.DayPlan;
import com.coderscampus.spoonacularassignment.model.dto.WeekPlan;
import com.coderscampus.spoonacularassignment.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;


@ComponentScan
@RestController
public class MealPlanController {
    private final MealPlanService mealPlanService;
    @Autowired
    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekPlan> getWeekMeals(String numCalories, String diet, String exclusions) throws Exception {
        WeekPlan weekplan = mealPlanService.createWeekPlan(numCalories, diet, exclusions);
        return ResponseEntity.ok(weekplan);
    }
    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayPlan> getDayMeals(String numCalories, String diet, String exclusions) throws Exception {
        DayPlan dayPlan = mealPlanService.createDayPlan(numCalories, diet, exclusions);
        return ResponseEntity.ok(dayPlan);
    }
}






