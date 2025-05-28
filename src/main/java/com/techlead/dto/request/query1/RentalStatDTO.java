package com.techlead.dto.request.query1;

public class RentalStatDTO {

    private String title;
    private Long rentalCount;

    public RentalStatDTO(String title, Long rentalCount) {
        this.title = title;
        this.rentalCount = rentalCount;
    }

    public RentalStatDTO(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRentalCount() {
        return rentalCount;
    }

    public void setRentalCount(Long rentalCount) {
        this.rentalCount = rentalCount;
    }
}
