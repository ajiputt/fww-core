# Flying Without Wings - Core Service

## Requirements

1. Java - 17

2. Maven - 3.x.x

3. PostgresSQL - 16.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/ajiputt/fww-core.git
```

**2. Create PostgresSQL database**

```bash
create database fww;
```

**3. Create user with username and password and grant all privilege this
user to created database**

```bash
create user <username> with encrypted password password;
grant all privileges on database fww to <username>;
```

**4. Change PostgresSQL username and password as per your MySQL installation**

open `src/main/resources/application.yml`, and change `spring.datasource.
username` and `spring.datasource.password` properties

**5. Create Tables**

Create tables by executing the `fww.sql` script located
inside `src/main/resources` directory.

**6. Spring Security with Basic Auth**

The app will handle security with Basic Auth, you can change username and
password to access resource of this app on `src/main/resources/application.
yml` with field `app.username` and `app.password`

**7. Build and run the app using maven**

Finally, You can run the app by typing the following command from the root
directory of the project -

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

## Database Schema

![ALT](https://i.ibb.co/QrNqRmW/db-schema.jpg)

## API Reference

### Get Scheduler

```http
  GET /schedules/search/findByAirportDepartureCodeAndAirportArrivalCodeAndDate
```

```Authorization
  Basic Base64(username:password)
```

**Request Parameter**

| Parameter    | Type     | Description                               |
|:-------------|:---------|:------------------------------------------|
| `projection` | `string` | **Required**. schedule-view               |
| `departure`  | `string` | **Required**. Departure airport code      |
| `arrival`    | `string` | **Required**. Arrival airport code        |
| `date`       | `string` | **Required**. Departure date (YYYY-MM-DD) |

### Post Reservation

```http
  GET /schedules/search/findByAirportDepartureCodeAndAirportArrivalCodeAndDate
```

```Header
  Authorization : Basic Base64(username:password)
  Content-Type : application/json
```

**Request Body**

| Parameter       | Type      | Description                                                      |
|:----------------|:----------|:-----------------------------------------------------------------|
| `booking_code`  | `string`  | **Required**. Booking code                                       |
| `seat_no`       | `integer` | **Required**. Number of seat                                     |
| `status`        | `string`  | **Required**. Status booking (B = booked, D = checkin, P = paid) |
| `created_by`    | `string`  | **Required**. Current user login                                 |
| `schedule_code` | `string`  | **Required**. Schedule code                                      |
| `nik`           | `string`  | **Required**. Passenger's ID                                     |