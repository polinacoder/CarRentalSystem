package com.code.system.business.extraservice.dao;

import com.code.system.business.extraservice.model.ExtraService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExtraServiceRepository implements ExtraServiceDao {

    private final JdbcTemplate jdbcTemplate;

    public ExtraServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ExtraService> selectExtraServices() {
        var sql = """
                SELECT s.extra_service_id, s.extra_service_name, p.price
                FROM extra_service s LEFT JOIN extra_service_price p
                ON s.extra_service_id = p.extra_service_id AND p.is_actual = true
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new ExtraServiceMapper());
    }

    @Override
    public Optional<ExtraService> selectExtraServiceById(int id) {
        var sql = """
                SELECT extra_service_name
                FROM extra_service
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new ExtraServiceMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int insertExtraService(ExtraService extraService) {
        if (extraService.id() != null) {
            var sql = """
                    UPDATE extra_service
                    SET extra_service_name = ?
                    WHERE id = ?;
                     """;
            return jdbcTemplate.update(
                    sql,
                    extraService.extraServiceName(), extraService.id()
            );
        }
        var sql = """
                INSERT INTO extra_service(extra_service_name)
                VALUES (?);
                 """;
        return jdbcTemplate.update(
                sql,
                extraService.extraServiceName()
        );
    }

    @Override
    public int deleteExtraService(int id) {
        var sql = """
                DELETE FROM extra_service
                WHERE id = ?;
                 """;
        return jdbcTemplate.update(
                sql, id
        );
    }
}