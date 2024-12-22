package com.code.system.business.transport.dao;

import com.code.system.business.transport.model.Transport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransportRepository implements TransportDao {

    private final JdbcTemplate jdbcTemplate;

    public TransportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transport> selectTransports() {
        var sql = """
                SELECT t.id, t.type, t.subtype, t.model, t.number, t.is_available, p.transport_price_id, p.price
                FROM transport t LEFT JOIN transport_price p
                ON t.id = p.transport_id AND p.is_actual = true
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new TransportMapper());
    }

    @Override
    public Optional<Transport> selectTransportById(int id) {
        var sql = """
            SELECT t.id, t.type, t.subtype, t.model, t.number, t.is_available, p.transport_price_id, p.price
            FROM transport t LEFT JOIN transport_price p
            ON t.id = p.transport_id AND p.is_actual = true
            WHERE t.id = ?
            """;
        return jdbcTemplate.query(sql, new TransportMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int insertTransport(Transport transport) {
        if (transport.id() != null) {
            var sql = """
                    UPDATE transport
                    SET type = ?, subtype = ?, model = ?, number = ?, is_available = ?
                    WHERE id = ?;
                     """;
            return jdbcTemplate.update(
                    sql,
                    transport.type(), transport.subtype(), transport.model(), transport.number(), transport.isAvailable(), transport.id()
            );
        }
        var sql = """
                INSERT INTO transport(type, subtype, model, number, is_available)
                VALUES (?, ?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                transport.type(), transport.subtype(), transport.model(), transport.number(), transport.isAvailable()
        );
    }

    @Override
    public int deleteTransport(int id) {
        var sql = """
                UPDATE transport
                SET is_available = ?
                WHERE id = ?;
                 """;
        return jdbcTemplate.update(
                sql, false, id
        );
    }
}
