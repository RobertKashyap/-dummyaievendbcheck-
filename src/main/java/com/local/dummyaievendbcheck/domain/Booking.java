package com.local.dummyaievendbcheck.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Booking {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long hotelId;

    @Column
    private Long numberOfRooms;

    @Column
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
