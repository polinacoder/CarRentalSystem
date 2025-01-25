package com.code.system.business.booking.dao;

import com.code.system.business.booking.model.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookingMapper implements RowMapper<Booking> {
    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Booking.builder().id(rs.getInt("id"))
                .creationDate(rs.getTimestamp("creation_date"))
                .editDate(rs.getTimestamp("edit_date"))
                .lastEditAdmin(rs.getString("last_edit_admin"))
                .pickUpAddress(rs.getString("pick_up_address"))
                .dropOfAddress(rs.getString("drop_of_address"))
                .startRentDate(rs.getTimestamp("start_rent_date"))
                .scheduledReturnDate(rs.getTimestamp("scheduled_return_date"))
                .actualReturnDate(rs.getTimestamp("actual_return_date"))
                .status(rs.getString("status"))
                .userId(rs.getInt("user_id"))
                .transportId(rs.getInt("transport_id"))
                .extraServices(List.of(rs.getInt("extra_service_id")))
                .build();
    }
}
