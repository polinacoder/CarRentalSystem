package com.code.system.business.transport.dto;

import jakarta.annotation.Nullable;
import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    @NonNull
    Timestamp startRentDate;
    @NonNull
    Timestamp endRentDate;
    @NonNull
    String type;
    @Nullable
    String subtype;
    @Nullable
    String model;
}
