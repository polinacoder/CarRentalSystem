package com.code.system.business.booking.controller.dto;

import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    @Id
    private Integer id;

    @Nullable
    private Timestamp creationDate;

    @Nullable
    private Timestamp editDate;

    @Nullable
    private String lastEditAdmin;

    @NonNull
    private String pickUpAddress;

    @Nullable
    private String dropOfAddress;//заполняется после

    @NonNull
    private Timestamp startRentDate;

    @NonNull
    private Timestamp scheduledReturnDate;

    @Nullable
    private Timestamp actualReturnDate;//заполняется после

    @Nullable
    private String status;//может изменятся, как перевести в BookingStatus в маппере

    @NonNull
    private Integer userId;

    @NonNull
    private String userLastName;

    @NonNull
    private String userNumber;

    @NonNull
    private Integer transportId;

    @NonNull
    private String numberTransport;

    @NonNull
    private String modelTransport;

    @Nullable
    private List<Integer> extraServices;
}
