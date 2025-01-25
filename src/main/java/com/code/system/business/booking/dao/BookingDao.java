package com.code.system.business.booking.dao;

import com.code.system.business.booking.dto.BookingResponse;
import com.code.system.business.booking.model.Booking;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface BookingDao {
    List<BookingResponse> selectBookings(PageRequest pageRequest);
    Optional<Booking> selectBookingById(int id);
    int insertBooking(Booking booking);
    int cancelBooking(int id);
}
