package com.code.system.business.booking.controller;

import com.code.system.business.booking.model.Booking;
import com.code.system.business.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> listBookingServices() {
        return bookingService.getBookings();
    }

    @GetMapping("{id}")
    public Booking getBookingById(@PathVariable("id") Integer id) {
        return bookingService.getBooking(id);
    }

    @PostMapping
    public void addBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
    }

    @DeleteMapping("{id}")
    public void deleteBooking(@PathVariable("id") Integer id) {
        bookingService.deleteBooking(id);
    }

}
