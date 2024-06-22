package com.local.dummyaievendbcheck.service;

import com.local.dummyaievendbcheck.domain.Hotel;
import com.local.dummyaievendbcheck.model.HotelDTO;
import com.local.dummyaievendbcheck.repos.HotelRepository;
import com.local.dummyaievendbcheck.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(final HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDTO> findAll() {
        final List<Hotel> hotels = hotelRepository.findAll(Sort.by("id"));
        return hotels.stream()
                .map(hotel -> mapToDTO(hotel, new HotelDTO()))
                .toList();
    }

    public HotelDTO get(final Long id) {
        return hotelRepository.findById(id)
                .map(hotel -> mapToDTO(hotel, new HotelDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final HotelDTO hotelDTO) {
        final Hotel hotel = new Hotel();
        mapToEntity(hotelDTO, hotel);
        return hotelRepository.save(hotel).getId();
    }

    public void update(final Long id, final HotelDTO hotelDTO) {
        final Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(hotelDTO, hotel);
        hotelRepository.save(hotel);
    }

    public void delete(final Long id) {
        hotelRepository.deleteById(id);
    }

    private HotelDTO mapToDTO(final Hotel hotel, final HotelDTO hotelDTO) {
        hotelDTO.setId(hotel.getId());
        hotelDTO.setNumberOfAvailableRooms(hotel.getNumberOfAvailableRooms());
        hotelDTO.setDescription(hotel.getDescription());
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setLocation(hotel.getLocation());
        return hotelDTO;
    }

    private Hotel mapToEntity(final HotelDTO hotelDTO, final Hotel hotel) {
        hotel.setNumberOfAvailableRooms(hotelDTO.getNumberOfAvailableRooms());
        hotel.setDescription(hotelDTO.getDescription());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setLocation(hotelDTO.getLocation());
        return hotel;
    }

}
