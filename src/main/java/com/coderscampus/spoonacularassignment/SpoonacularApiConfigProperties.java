package com.coderscampus.spoonacularassignment;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spoonacular.urls")
public class SpoonacularApiConfigProperties {

    /**
     * This is the Spoonacular API Base URL
     **/
    private String base;

    /**
     * This is the Spoonacular API Meal Plan URL
     **/
    private String mealplan;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getMealplan() {
        return mealplan;
    }

    public void setMealplan(String mealplan) {
        this.mealplan = mealplan;
    }
}
