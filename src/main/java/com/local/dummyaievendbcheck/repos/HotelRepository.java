package com.local.dummyaievendbcheck.repos;

import com.local.dummyaievendbcheck.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
