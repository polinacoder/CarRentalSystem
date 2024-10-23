package com.code.system.business.extraservice.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ExtraService (Integer id,
                            String extraServiceName,
                            BigDecimal extraServicePrice
                            ) {
}
