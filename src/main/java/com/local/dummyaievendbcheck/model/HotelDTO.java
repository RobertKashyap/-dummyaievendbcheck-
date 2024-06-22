package com.local.dummyaievendbcheck.model;

import jakarta.validation.constraints.Size;


public class HotelDTO {

    private Long id;

    private Long numberOfAvailableRooms;

    @Size(max = 255)
    private String description;

    @Size(max = 255)
    private String hotelName;

    @Size(max = 255)
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getNumberOfAvailableRooms() {
        return numberOfAvailableRooms;
    }

    public void setNumberOfAvailableRooms(final Long numberOfAvailableRooms) {
        this.numberOfAvailableRooms = numberOfAvailableRooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(final String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

}
