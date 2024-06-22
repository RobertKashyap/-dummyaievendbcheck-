package com.local.dummyaievendbcheck.model;

import jakarta.validation.constraints.Size;


public class BookingDTO {

    private Long id;

    private Long hotelId;

    private Long numberOfRooms;

    @Size(max = 255)
    private String guestEmail;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(final Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(final Long numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(final String guestEmail) {
        this.guestEmail = guestEmail;
    }

}
