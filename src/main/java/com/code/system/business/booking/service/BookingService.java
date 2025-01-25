package com.code.system.business.booking.service;

import com.code.system.business.booking.dto.BookingCreationRequestMapper;
import com.code.system.business.booking.dao.BookingDao;
import com.code.system.business.booking.dto.BookingResponse;
import com.code.system.business.booking.model.Booking;
import com.code.system.business.booking.dto.BookingCreationRequest;
import com.code.system.business.exception.BusinessException;
import com.code.system.business.exception.NotFoundException;
import com.code.system.business.transport.dao.TransportDao;
import com.code.system.dao.UserDao;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingDao bookingDao;
    private final UserDao userDao;
    private final TransportDao transportDao;

    public BookingService(BookingDao bookingDao, UserDao userDao, TransportDao transportDao) {
        this.bookingDao = bookingDao;
        this.userDao = userDao;
        this.transportDao = transportDao;
    }

    public List<BookingResponse> getBookings(PageRequest pageRequest) {
        return bookingDao.selectBookings(pageRequest);
    }

    public Booking getBooking(int id) {
        return bookingDao.selectBookingById(id)
                .orElseThrow(NotFoundException::new);
    }

    public void addBooking(BookingCreationRequest bookingCreationRequest) {
       Booking booking = BookingCreationRequestMapper.mapToBooking(bookingCreationRequest);
        int result = bookingDao.insertBooking(booking);
        if (result != 1) {
            throw new BusinessException();
        }
    }

    public void cancelBooking(Integer id) {
        Optional<Booking> bookings = bookingDao.selectBookingById(id);
        bookings.ifPresentOrElse(booking -> {
            int result = bookingDao.cancelBooking(id);
            if (result != 1) {
                throw new BusinessException();
            }
        }, () -> {
            throw new NotFoundException();
        });
    }
}
