package com.code.system.business.booking.controller;

import com.code.system.business.booking.controller.dao.BookingRepository;
import com.code.system.business.booking.controller.dto.BookingResponse;
import com.code.system.business.booking.controller.model.Booking;
import com.code.system.business.transport.dao.TransportRepository;
import com.code.system.business.transport.model.Transport;
import com.code.system.business.transport.model.TransportPrice;
import com.code.system.dao.UserRepository;
import com.code.system.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class BookingControllerTest {

    static PostgreSQLContainer<?> postgresContainer;

    @BeforeAll
    public static void setUp() {
        postgresContainer = new PostgreSQLContainer<>("postgres:latest")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");

        postgresContainer.start();
        System.setProperty("DB_URL", postgresContainer.getJdbcUrl());
        System.setProperty("DB_USERNAME", postgresContainer.getUsername());
        System.setProperty("DB_PASSWORD", postgresContainer.getPassword());
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Test
    void getBookingList_success() {
    // given
    BookingResponse response = new BookingResponse(1, new Timestamp(123), new Timestamp(123), "Админ",
                "Адрес посадки", null, new Timestamp(123), new Timestamp(123),
                null, "NOT_PAYED", 1, "Last", "890",
                1, "8342", "model", null);
    User user = User.builder().id(1).address("adress").firstName("Pol").lastName("Potolok").phoneNumber("234").build();
    Transport transport = Transport.builder().id(1).transportPrice(new TransportPrice(1, new BigDecimal(12), true)).model("model").number("number").type("type").subtype("бизнес").build();
    userRepository.insertUser(user);
    transportRepository.insertTransport(transport);
    Booking booking = Booking.builder()
                .editDate(new Timestamp(11))
                .lastEditAdmin("Admin")
                .pickUpAddress("Адрес посадки")
                .dropOfAddress(null)
                .startRentDate(new Timestamp(123))
                .scheduledReturnDate(new Timestamp(123))
                .actualReturnDate(null)
                .userId(1)
                .transportId(1)
                .status("NOT_PAYED")
                .build();
    bookingRepository.insertBooking(booking);

    // when
    List<BookingResponse> responses = bookingRepository.selectBookings(PageRequest.of(0, 10));

    //then
    assertEquals(1, responses.size());
    }
}