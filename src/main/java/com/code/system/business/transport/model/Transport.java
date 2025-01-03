package com.code.system.business.transport.model;

import lombok.Builder;

@Builder
public record Transport(Integer id,
                        String type,
                        String subtype,
                        String model,
                        String number,
                        boolean isAvailable,
                        TransportPrice transportPrice
                        ) {
}
