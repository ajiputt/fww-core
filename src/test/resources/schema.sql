CREATE TABLE IF NOT EXISTS `baggages`
(
    `code` varchar
(
    25
) NOT NULL,
    `booking_code` varchar
(
    255
) DEFAULT NULL,
    `weight` int
(
    11
) DEFAULT NULL
    );
CREATE TABLE IF NOT EXISTS `airports`
(
    `code` varchar
(
    255
) NOT NULL,
    `name` varchar
(
    255
) DEFAULT NULL,
    `city` varchar
(
    255
)
    );
CREATE TABLE IF NOT EXISTS `members`
(
    `username` varchar
(
    255
) NOT NULL,
    `password` varchar
(
    255
) NOT NULL,
    `first_name` varchar
(
    255
) DEFAULT NULL,
    `last_name` varchar
(
    255
) DEFAULT NULL,
    `email` varchar
(
    255
) DEFAULT NULL,
    `phone` varchar
(
    255
) DEFAULT NULL,
    `address` text DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp
(
),
    `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp
(
)
    );

CREATE TABLE IF NOT EXISTS `partners`
(
    `code` varchar
(
    255
) NOT NULL,
    `name` varchar
(
    255
) DEFAULT NULL,
    `method` varchar
(
    20
) DEFAULT NULL,
    `status` int
(
    11
) DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp
(
)
    );

CREATE TABLE IF NOT EXISTS `passengers`
(
    `nik` varchar
(
    255
) NOT NULL,
    `full_name` varchar
(
    255
) DEFAULT NULL,
    `title` varchar
(
    10
) DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp
(
) ON UPDATE current_timestamp
(
)
    );

CREATE TABLE IF NOT EXISTS `payments`
(
    `id` int
(
    11
) NOT NULL,
    `transaction_id` varchar
(
    255
) DEFAULT NULL,
    `partner_code` varchar
(
    255
) DEFAULT NULL,
    `reservation_id` int
(
    11
) DEFAULT NULL,
    `status` int
(
    11
) DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp
(
),
    `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp
(
)
    );

CREATE TABLE IF NOT EXISTS `planes`
(
    `code` varchar
(
    255
) NOT NULL,
    `name` varchar
(
    255
) DEFAULT NULL,
    `number_of_seats` int
(
    11
) DEFAULT NULL
    );

CREATE TABLE IF NOT EXISTS `reservations`
(
    `id` int
(
    11
) NOT NULL,
    `booking_code` varchar
(
    255
) DEFAULT NULL,
    `schedule_code` varchar
(
    255
) DEFAULT NULL,
    `seat_no` int
(
    11
) DEFAULT NULL,
    `nik` varchar
(
    255
) DEFAULT NULL,
    `status` int
(
    11
) NOT NULL,
    `created_by` varchar
(
    255
) DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp
(
)
    );

CREATE TABLE IF NOT EXISTS `schedules`
(
    `code` varchar
(
    255
) NOT NULL,
    `date` date NOT NULL,
    `planes_code` varchar
(
    255
) DEFAULT NULL,
    `time_departure` time
(
    6
) DEFAULT NULL,
    `duration` integer NOT NULL,
    `baggage_weight` integer NOT NULL,
    `price` double NOT NULL,
    `airport_departure` varchar
(
    255
) DEFAULT NULL,
    `airport_arrival` varchar
(
    255
) DEFAULT NULL
    );

CREATE TABLE IF NOT EXISTS `schedule_seats`
(
    `id` int
(
    11
) NOT NULL,
    `schedule_code` varchar
(
    25
) NOT NULL,
    `seat_no` int
(
    11
) NOT NULL,
    `status` varchar
(
    1
) NOT NULL
    );



