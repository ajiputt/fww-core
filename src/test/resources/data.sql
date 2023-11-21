DELETE
FROM `airports`;
INSERT INTO `airports` (`code`, `name`, `city`)
VALUES ('001', 'Bandar Udara 1', ' Bandung'),
       ('002', 'Bandar Udara 2', ' Jakarta'),
       ('003', 'Bandar Udara 3', ' Surabaya');
DELETE
FROM planes;
INSERT INTO planes
    (code, name, noOfSeats)
VALUES ('PLANE-001', 'BOEING 777 MAX', 40);
DELETE
FROM schedules;
INSERT INTO schedules (`code`, `date`, `planes_code`, `timeDeparture`,
                       `duration`, `baggageWeight`,
                       `price`, `airport_departure`, `airport_arrival`)
VALUES ('TEST-0001', '2023-12-25', 'PLANE-001', '07:00:00', 40, 12, 739000,
        '001',
        '003'),
       ('TEST-0002', '2023-12-25', 'PLANE-001', '10:00:00', 45, 12, 750000,
        '002',
        '001');
DELETE
FROM passengers;
INSERT INTO passengers
    (nik, fullName, title, createdAt)
VALUES ('123444432121', 'TEST FULL NAME', 'TUAN',
        CURRENT_TIMESTAMP);
DELETE
FROM reservations;
INSERT INTO reservations
(bookingCode, schedule_code, seatNo, nik, status, createdBy, createdAt)
VALUES ('BOOKING-001', 'TEST-0002', 2, '123444432121', 'B', 'user-test',
        CURRENT_TIMESTAMP);



