package com.code.system.business.booking.controller.controller;

import com.code.system.business.booking.controller.dto.BookingResponse;
import com.code.system.business.booking.controller.model.Booking;
import com.code.system.business.booking.controller.dto.BookingCreationRequest;
import com.code.system.business.booking.controller.service.BookingService;
import org.springframework.data.domain.PageRequest;
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
    public List<BookingResponse> listBookings(@RequestParam(required = false, defaultValue = "0") int page,
                                              @RequestParam(required = false, defaultValue = "10") int size) {
        return bookingService.getBookings(PageRequest.of(page, size));
    }

    @GetMapping("{id}")
    public Booking getBookingById(@PathVariable("id") Integer id) {
        return bookingService.getBooking(id);
    }

    @PostMapping
    public void addBooking(@RequestBody BookingCreationRequest bookingCreationRequest) {
        bookingService.addBooking(bookingCreationRequest);
    }

    @DeleteMapping("{id}")
    public void cancelBooking(@PathVariable("id") Integer id) {
        bookingService.cancelBooking(id);
    }

}
