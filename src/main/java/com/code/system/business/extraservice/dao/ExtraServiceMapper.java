package com.code.system.business.extraservice.dao;

import com.code.system.business.extraservice.model.ExtraService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtraServiceMapper implements RowMapper<ExtraService> {
    @Override
    public ExtraService mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ExtraService.builder().id(rs.getInt("extra_service_id"))
                .extraServiceName(rs.getString("extra_service_name"))
                .extraServicePrice(rs.getBigDecimal("price"))
                .build();
    }
}