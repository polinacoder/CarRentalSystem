package com.code.system.model;


public record User(Integer id,
                   String firstName,
                   String lastName,
                   String phoneNumber,
                   String address) {
}
