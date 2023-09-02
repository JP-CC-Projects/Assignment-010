package com.coderscampus.spoonacularassignment.model.dto;

public class Nutrients {

    //Total nutrients in the combined list of meals. Spoonacular gives one set of Nutrients for the combined meals.
    private Double calories;
    private Double protein;
    private Double fat;
    private Double carbohydrates;

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
