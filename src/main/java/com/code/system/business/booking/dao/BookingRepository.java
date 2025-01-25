package com.code.system.business.booking.dao;

import com.code.system.business.booking.dto.BookingResponse;
import com.code.system.business.booking.dto.BookingResponseMapper;
import com.code.system.business.booking.model.Booking;
import com.code.system.business.booking.model.BookingStatus;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.PageRequest;
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
    public List<BookingResponse> selectBookings(@Nullable PageRequest pageRequest) {
        var sql = """
                SELECT b.id, b.creation_date, b.edit_date, b.last_edit_admin, b.pick_up_address, b.drop_of_address,   
                       b.start_rent_date, b.scheduled_return_date, b.actual_return_date, b.status, 
                       b.user_id, b.transport_id, u.last_name, u.phone_number, t.model, t.number, bes.extra_service_id
                FROM booking b LEFT JOIN booking_extra_service bes
                ON b.id = bes.booking_id 
                LEFT JOIN users u
                ON b.user_id = u.id
                LEFT JOIN transport t
                ON b.transport_id = t.id
                ORDER BY b.creation_date DESC
                LIMIT ? OFFSET ? ;
                 """;
        return jdbcTemplate.query(sql, new Object[] {pageRequest.getPageSize(), pageRequest.getOffset()}, new BookingResponseMapper());
    }

    @Override
    public Optional<Booking> selectBookingById(int id) {
        var sql = """
                SELECT b.id, b.creation_date, b.edit_date, b.last_edit_admin, b.pick_up_address, b.drop_of_address,   
                       b.start_rent_date, b.scheduled_return_date, b.actual_return_date, b.status, 
                       b.user_id,  b.transport_id, bes.extra_service_id
                FROM booking b LEFT JOIN booking_extra_service bes 
                ON b.id = bes.booking_id 
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new BookingMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int insertBooking(Booking booking) {
        if (booking.getId() != null) {
            var sql = """
                    UPDATE booking
                    SET pick_up_address = ?, drop_of_address = ?, start_rent_date = ?, 
                    scheduled_return_date = ?, transport_id =?
                    WHERE id = ?;
                     """;
            return jdbcTemplate.update(
                    sql, booking.getPickUpAddress(), booking.getDropOfAddress(), booking.getStartRentDate(), booking.getScheduledReturnDate(), booking.getTransportId(), booking.getId()
            );
        }
        var sql = """
                INSERT INTO booking(edit_date, last_edit_admin, pick_up_address, drop_of_address, start_rent_date, scheduled_return_date, actual_return_date, status, user_id, transport_id)
                VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                 """;
        return jdbcTemplate.update(sql,
                booking.getEditDate(), booking.getLastEditAdmin(), booking.getPickUpAddress(), booking.getDropOfAddress(),
                booking.getStartRentDate(), booking.getScheduledReturnDate(), null, booking.getStatus(),
                booking.getUserId(), booking.getTransportId());
    }

    @Override
    public int cancelBooking(int id) {
        var sql = """
                UPDATE booking
                SET status = ?
                WHERE id = ?;
                 """;
        return jdbcTemplate.update(
                sql, BookingStatus.CANCELLED, id
        );
    }

}

