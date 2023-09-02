package com.coderscampus.spoonacularassignment.model.dto;


import java.util.List;

public class SpoonacularMealPlanResponse {
    private List<Meal> meals;
    private Nutrients nutrients;

//    Getters and Setters:
    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }
}
