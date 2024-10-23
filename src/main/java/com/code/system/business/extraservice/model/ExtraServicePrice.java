package com.code.system.business.extraservice.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ExtraServicePrice(Integer id,
                                BigDecimal price,
                                boolean is_actual) {
}
