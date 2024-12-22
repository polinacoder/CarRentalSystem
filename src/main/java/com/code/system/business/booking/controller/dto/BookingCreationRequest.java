package com.code.system.business.booking.controller.dto;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class BookingCreationRequest {

    @NonNull
    String pickUpAddress;

    @NonNull
    Timestamp startRentDate;

    @NonNull
    Timestamp endRentDate;

    @NonNull
    Integer userId;

    @NonNull
    Integer transportId;

    @Nullable
    List<Integer> extraServices;
}