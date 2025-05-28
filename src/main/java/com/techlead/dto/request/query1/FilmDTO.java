package com.techlead.dto.request.query1;

import java.math.BigDecimal;

public class FilmDTO {

    private String title;
    private BigDecimal rentalRate;
    private BigDecimal replacementCost;

    public FilmDTO(String title, BigDecimal rentalRate, BigDecimal replacementCost) {
        this.title = title;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
    }

    public FilmDTO(){}

    public String getTitle() { return title; }
    public BigDecimal getRentalRate() { return rentalRate; }
    public BigDecimal getReplacementCost() { return replacementCost; }
}
