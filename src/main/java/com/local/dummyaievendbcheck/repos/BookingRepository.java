package com.local.dummyaievendbcheck.repos;

import com.local.dummyaievendbcheck.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Long> {
}
