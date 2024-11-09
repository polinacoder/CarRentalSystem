package com.code.system.business.booking.dao;

import com.code.system.business.booking.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingDao {
    List<Booking> selectBookings();
    Optional<Booking> selectBookingById(int id);
    int insertBooking(Booking booking);
    int deleteBooking(int id);
}
