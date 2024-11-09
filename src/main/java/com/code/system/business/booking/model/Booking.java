package com.code.system.business.booking.model;

import com.code.system.business.extraservice.model.ExtraService;
import com.code.system.business.transport.model.Transport;
import com.code.system.user.model.User;
import lombok.Builder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Booking(Integer id, Timestamp creationDate, Timestamp editDate,
                      User lastEditAdmin,
                      String pickUpAddress,
                      String dropOfAddress,
                      Timestamp startRentDate,
                      Timestamp scheduledReturnDate,
                      Timestamp actualReturnDate,
                      BookingStatus status,
                      Integer userId,
                      Integer transportId,
                      List<Integer> extraServices) {
}
