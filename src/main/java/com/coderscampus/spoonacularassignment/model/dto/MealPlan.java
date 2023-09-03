package com.coderscampus.spoonacularassignment.model.dto;


import com.coderscampus.spoonacularassignment.model.domain.Meal;
import com.coderscampus.spoonacularassignment.model.domain.Nutrients;

import java.util.List;

public class MealPlan {
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
