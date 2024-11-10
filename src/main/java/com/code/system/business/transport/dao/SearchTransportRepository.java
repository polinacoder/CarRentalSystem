package com.code.system.business.transport.dao;

import com.code.system.business.transport.dto.SearchRequestDto;
import com.code.system.business.transport.model.Transport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchTransportRepository implements SearchTransportDao {
    public SearchTransportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Transport> searchTransports(SearchRequestDto searchRequestDto) {
        var sql = """
                SELECT t.id, t.type, t.subtype, t.model, t.number, t.is_available, p.transport_price_id, p.price
                FROM transport t LEFT JOIN transport_price p
                ON t.id = p.transport_id AND p.is_actual = true
                WHERE t.type = ? AND t.subtype = ? AND model = ?
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new TransportMapper(), searchRequestDto.getType(), searchRequestDto.getSubtype(), searchRequestDto.getModel());
    }
}
