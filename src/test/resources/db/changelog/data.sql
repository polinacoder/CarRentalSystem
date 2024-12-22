INSERT INTO users(first_name, last_name, phone_number, address)
VALUES ("Sam", "Fantastish", "1234567", "Адрес");

INSERT INTO transport(type, subtype, model, number, is_available)
VALUES ("авто", "бизнес", "бмв", "123", true);

INSERT INTO transport_price(price, is_actual, transport_id)
VALUES (100, true, 1);

INSERT INTO booking (edit_date, last_edit_admin, pick_up_address, drop_of_address,
                     start_rent_date, scheduled_return_date, status, user_id, transport_id)
VALUES ("2024-12-12T12:45:09.061+00:00", "Admin", "Адрес посадки", null, "2023-10-01T07:00:00.000+00:00",  "2023-10-02T07:00:00.000+00:00", "NOT_PAYED",  1, 1);
