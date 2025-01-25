package com.code.system.business.booking.dto;

import com.code.system.business.booking.model.Booking;

import java.sql.Timestamp;

public class BookingCreationRequestMapper {

    public static Booking mapToBooking(BookingCreationRequest request) {
        return Booking.builder()
                .editDate(new Timestamp(11))
                .lastEditAdmin("Admin")
                .pickUpAddress(request.getPickUpAddress())
                .dropOfAddress(null)
                .startRentDate(request.getStartRentDate())
                .scheduledReturnDate(request.getEndRentDate())
                .actualReturnDate(null)
                .userId(request.getUserId())
                .transportId(request.getTransportId())
                .extraServices(request.getExtraServices())
                .status("NOT_PAYED")
                .build();
    }
}
