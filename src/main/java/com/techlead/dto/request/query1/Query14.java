package com.techlead.dto.request.query1;

public class Query14 {
    private String categoryName;
    private Double averageDuration;

    public Query14(String categoryName, Double averageDuration) {
        this.categoryName = categoryName;
        this.averageDuration = averageDuration;
    }
    public Query14() {}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(Double averageDuration) {
        this.averageDuration = averageDuration;
    }
}
