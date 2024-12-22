package com.code.system.business.booking.controller.model;

import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    //jpa и spring security для creationDate, editDate, lastEditAdmin?
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
    private String status;//может изменятся, перевести в BookingStatus в маппере

    @NonNull
    private Integer userId;

    @NonNull
    private Integer transportId;

    @Nullable
    private List<Integer> extraServices;

}
