-- fww.airports definition

-- Drop table

-- DROP TABLE fww.airports;

CREATE TABLE fww.airports
(
    code   varchar NOT NULL,
    "name" varchar NULL,
    city   varchar NULL,
    CONSTRAINT airports_pk PRIMARY KEY (code)
);


-- fww.baggages definition

-- Drop table

-- DROP TABLE fww.baggages;

CREATE TABLE fww.baggages
(
    code         varchar NOT NULL,
    booking_code varchar NOT NULL,
    weight       float8  NOT NULL,
    description  text    NULL,
    CONSTRAINT baggage_pk PRIMARY KEY (code)
);


-- fww.members definition

-- Drop table

-- DROP TABLE fww.members;

CREATE TABLE fww.members
(
    username   varchar   NOT NULL,
    "password" varchar   NOT NULL,
    first_name varchar   NULL,
    last_name  varchar   NULL,
    email      varchar   NULL,
    phone      varchar   NULL,
    address    text      NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NULL,
    CONSTRAINT members_pk PRIMARY KEY (username)
);
CREATE UNIQUE INDEX members_email_idx ON fww.members USING btree (email);


-- fww.passengers definition

-- Drop table

-- DROP TABLE fww.passengers;

CREATE TABLE fww.passengers
(
    nik        varchar(255) NOT NULL,
    full_name  varchar(255) NULL     DEFAULT NULL:: character varying,
    title      varchar(10)  NULL     DEFAULT NULL:: character varying,
    created_at timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
);


-- fww.planes definition

-- Drop table

-- DROP TABLE fww.planes;

CREATE TABLE fww.planes
(
    code        varchar NOT NULL,
    "name"      varchar NULL,
    no_of_seats int4    NULL,
    CONSTRAINT planes_pk PRIMARY KEY (code)
);


-- fww.member_token definition

-- Drop table

-- DROP TABLE fww.member_token;

CREATE TABLE fww.member_token
(
    username varchar NOT NULL,
    "token"  varchar NULL,
    CONSTRAINT member_token_pk PRIMARY KEY (username),
    CONSTRAINT member_token_fk FOREIGN KEY (username) REFERENCES fww.members (username)
);


-- fww.schedules definition

-- Drop table

-- DROP TABLE fww.schedules;

CREATE TABLE fww.schedules
(
    code              varchar NOT NULL,
    "date"            date    NOT NULL,
    planes_code       varchar NOT NULL,
    time_departure    time    NOT NULL,
    duration          int4    NOT NULL,
    baggage_weight    int4    NOT NULL,
    price             float8  NOT NULL,
    airport_departure varchar NOT NULL,
    airport_arrival   varchar NOT NULL,
    CONSTRAINT schedules_pk PRIMARY KEY (code),
    CONSTRAINT schedules_fk FOREIGN KEY (airport_departure) REFERENCES fww.airports (code),
    CONSTRAINT schedules_fk_1 FOREIGN KEY (airport_arrival) REFERENCES fww.airports (code),
    CONSTRAINT schedules_fk_2 FOREIGN KEY (planes_code) REFERENCES fww.planes (code)
);


-- fww.reservations definition

-- Drop table

-- DROP TABLE fww.reservations;

CREATE TABLE fww.reservations
(
    id            serial4      NOT NULL,
    booking_code  varchar(255) NOT NULL,
    schedule_code varchar(255) NOT NULL,
    seat_no       int4         NULL,
    nik           varchar(255) NULL,
    status        varchar      NOT NULL,
    created_by    varchar(255) NULL,
    created_at    timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT reservations_pk PRIMARY KEY (id),
    CONSTRAINT reservations_fk FOREIGN KEY (schedule_code) REFERENCES fww.schedules (code)
);
CREATE UNIQUE INDEX reservations_booking_code_idx ON fww.reservations USING btree (booking_code);


-- fww.schedule_seats definition

-- Drop table

-- DROP TABLE fww.schedule_seats;

CREATE TABLE fww.schedule_seats
(
    id            int4        NOT NULL DEFAULT nextval(
            'fww.schedule_seats1_id_seq' ::regclass),
    schedule_code varchar(25) NOT NULL,
    seat_no       int4        NOT NULL,
    status        varchar     NOT NULL,
    CONSTRAINT schedule_seats_pk PRIMARY KEY (id),
    CONSTRAINT schedule_seats_fk FOREIGN KEY (schedule_code) REFERENCES fww.schedules (code)
);