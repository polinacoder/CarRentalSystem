package com.code.system.business.booking.dao;

import com.code.system.business.booking.model.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepository implements BookingDao {
    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Booking> selectBookings() {
        var sql = """
                SELECT b.id, b.creation_date, b.edit_date, b.last_edit_admin, b.pick_up_address, b.drop_of_address,       
                       b.start_rent_date, b.scheduled_return_date, b.actual_return_date, b.status, b.user_id, b.transport_id, bes.extra_service_id
                FROM booking b LEFT JOIN booking_extra_service bes 
                ON b.id = bes.booking_id
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new BookingMapper());
    }

    @Override
    public Optional<Booking> selectBookingById(int id) {
        var sql = """
                SELECT creation_date, edit_date, last_edit_admin, pick_up_address, drop_of_address,       
                       start_rent_date, scheduled_return_date,actual_return_date, status, user_id, transport_id
                FROM booking
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new BookingMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int insertBooking(Booking booking) {
        if (booking.id() != null) {
            var sql = """
                    UPDATE booking
                    SET creation_date = ?, edit_date = ?, last_edit_admin = ?, pick_up_address = ?, drop_of_address = ?,       
                       start_rent_date = ?, scheduled_return_date = ?,actual_return_date = ?, status = ?, user_id =? , transport_id =?
                    WHERE id = ?;
                     """;
            return jdbcTemplate.update(
                    sql,
                    booking.creationDate(), booking.editDate(), booking.lastEditAdmin(), booking.pickUpAddress(), booking.dropOfAddress(), booking.startRentDate(), booking.scheduledReturnDate(), booking.actualReturnDate(), booking.status(), booking.userId(), booking.transportId(), booking.id()
            );
        }
        var sql = """
                INSERT INTO booking(creation_date, edit_date, last_edit_admin, pick_up_address, drop_of_address,       
                       start_rent_date, scheduled_return_date,actual_return_date, status, user_id, transport_id)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                booking.creationDate(), booking.editDate(), booking.lastEditAdmin(), booking.pickUpAddress(), booking.dropOfAddress(), booking.startRentDate(), booking.scheduledReturnDate(), booking.actualReturnDate(), booking.status(), booking.userId(), booking.transportId()
        );
    }

    @Override
    public int deleteBooking(int id) {
        var sql = """
                DELETE FROM booking WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

}

