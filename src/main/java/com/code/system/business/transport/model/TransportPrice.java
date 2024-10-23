package com.code.system.business.transport.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TransportPrice(Integer id,
                             BigDecimal price,
                             boolean is_actual) {
}
