package com.code.system.business.booking.service;

import com.code.system.business.booking.dao.BookingDao;
import com.code.system.business.booking.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingDao bookingDao;

    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public List<Booking> getBookings() {
        return bookingDao.selectBookings();
    }

    public Booking getBooking(int id) {
        return bookingDao.selectBookingById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void addBooking(Booking booking) {
        int result = bookingDao.insertBooking(booking);
        if (result != 1) {
            throw new IllegalStateException();
        }
    }

    public void deleteBooking(Integer id) {
        Optional<Booking> bookings = bookingDao.selectBookingById(id);
        bookings.ifPresentOrElse(booking -> {
            int result = bookingDao.deleteBooking(id);
            if (result != 1) {
                throw new IllegalStateException();
            }
        }, () -> {
            throw new NoSuchElementException();
        });
    }
}
