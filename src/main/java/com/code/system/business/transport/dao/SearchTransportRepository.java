package com.code.system.business.transport.dao;

import com.code.system.business.transport.model.Transport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class SearchTransportRepository implements SearchTransportDao {
    public SearchTransportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;
//нужен репозиторий для добавления transport price, extra service и extra service price?
    @Override
    public List<Transport> searchTransportsByType(Timestamp start,Timestamp end, String type) {
        var sql = """
                SELECT t.id, t.type, t.subtype, t.model, t.number, t.is_available, p.transport_price_id, p.price
                FROM transport t LEFT JOIN transport_price p
                ON t.id = p.transport_id AND p.is_actual = true
                WHERE t.type = ?
                AND (t.is_available = true OR (t.is_available = false AND t.end_rent_date <= ?))
                LIMIT 100
                 """;
        return jdbcTemplate.query(sql, new TransportMapper(), type, start);
    }

    @Override
    public List<Transport> searchTransportsByTypeSubtype(Timestamp start, Timestamp end, String type, String subtype) {
        var sql = """
                SELECT t.id, t.type, t.subtype, t.model, t.number, t.is_available, p.transport_price_id, p.price
                FROM transport t LEFT JOIN transport_price p
                ON t.id = p.transport_id AND t.is_available = true AND p.is_actual = true
                WHERE t.type = ? AND t.subtype = ?
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new TransportMapper(), type, subtype);
    }

    @Override
    public List<Transport> searchTransportsByTypeSubtypeModel(Timestamp start, Timestamp end, String type, String subtype, String model) {
        var sql = """
                SELECT t.id, t.type, t.subtype, t.model, t.number, t.is_available, p.transport_price_id, p.price
                FROM transport t LEFT JOIN transport_price p
                ON t.id = p.transport_id AND t.is_available = true AND p.is_actual = true
                WHERE t.type = ? AND t.subtype = ? AND model = ?
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new TransportMapper(), type, subtype, model);
    }
}
