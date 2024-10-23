package com.code.system.business.transport.dao;

import com.code.system.business.transport.model.Transport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportMapper implements RowMapper<Transport> {
    @Override
    public Transport mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println(rs.getBigDecimal("price"));
        return Transport.builder().id(rs.getInt("id"))
                .type(rs.getString("type"))
                .subtype(rs.getString("subtype"))
                .model(rs.getString("model"))
                .number(rs.getString("number"))
                .isAvailable(rs.getBoolean("is_available"))
                .transportPrice(rs.getBigDecimal("price"))
                .build();
    }
}