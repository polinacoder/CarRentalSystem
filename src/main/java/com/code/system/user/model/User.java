package com.code.system.user.model;

import lombok.Builder;

@Builder
public record User(Integer id,
                   String firstName,
                   String lastName,
                   String phoneNumber,
                   String address) {
}
