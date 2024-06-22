package com.local.dummyaievendbcheck.service;

import com.local.dummyaievendbcheck.domain.Booking;
import com.local.dummyaievendbcheck.model.BookingDTO;
import com.local.dummyaievendbcheck.repos.BookingRepository;
import com.local.dummyaievendbcheck.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(final BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDTO> findAll() {
        final List<Booking> bookings = bookingRepository.findAll(Sort.by("id"));
        return bookings.stream()
                .map(booking -> mapToDTO(booking, new BookingDTO()))
                .toList();
    }

    public BookingDTO get(final Long id) {
        return bookingRepository.findById(id)
                .map(booking -> mapToDTO(booking, new BookingDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final BookingDTO bookingDTO) {
        final Booking booking = new Booking();
        mapToEntity(bookingDTO, booking);
        return bookingRepository.save(booking).getId();
    }

    public void update(final Long id, final BookingDTO bookingDTO) {
        final Booking booking = bookingRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(bookingDTO, booking);
        bookingRepository.save(booking);
    }

    public void delete(final Long id) {
        bookingRepository.deleteById(id);
    }

    private BookingDTO mapToDTO(final Booking booking, final BookingDTO bookingDTO) {
        bookingDTO.setId(booking.getId());
        bookingDTO.setHotelId(booking.getHotelId());
        bookingDTO.setNumberOfRooms(booking.getNumberOfRooms());
        bookingDTO.setGuestEmail(booking.getGuestEmail());
        return bookingDTO;
    }

    private Booking mapToEntity(final BookingDTO bookingDTO, final Booking booking) {
        booking.setHotelId(bookingDTO.getHotelId());
        booking.setNumberOfRooms(bookingDTO.getNumberOfRooms());
        booking.setGuestEmail(bookingDTO.getGuestEmail());
        return booking;
    }

}
