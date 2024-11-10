package com.code.system.business.transport.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    @NonNull
    String type;
    @NonNull
    String subtype;
    @NonNull
    String model;
}
