package com.coderscampus.spoonacularassignment.model.dto;
import com.coderscampus.spoonacularassignment.model.domain.Day;
import java.util.Map;

public class WeekPlan {
    private Map<String, Day> week;
    public Map<String, Day> getWeek() {
        return week;
    }
    public void setWeek(Map<String, Day> week) {
        this.week = week;
    }
}