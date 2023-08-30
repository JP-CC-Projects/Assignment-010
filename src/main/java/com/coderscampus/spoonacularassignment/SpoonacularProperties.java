package com.coderscampus.spoonacularassignment;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spoonacular.urls")
public class SpoonacularProperties {

    private String base;
    private String mealplan;

    public String getBase() {
        return base;
    }

    public String getMealplan() {
        return mealplan;
    }
}