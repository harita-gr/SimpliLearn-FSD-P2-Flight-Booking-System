CREATE USER 'flyaway'@'localhost' IDENTIFIED BY 'flyaway';

GRANT ALL PRIVILEGES ON * . * TO 'flyaway'@'localhost';

CREATE database flight_booking;
USE flight_booking;

CREATE TABLE customers(
    id INT auto_increment PRIMARY KEY NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(30) unique,
    phno VARCHAR(13),
    user_password VARCHAR(30)
);

    CREATE TABLE flight_details (
    flightNo VARCHAR(10) PRIMARY KEY NOT NULL,
    airline VARCHAR(30),
    source_place VARCHAR(30),
    destination_place VARCHAR(30),
    departure VARCHAR(30),
    arrival VARCHAR(30),
    duration VARCHAR(30),
    duration_in_min INT,
    airportName VARCHAR(30),
    totalStops INT,
    availableSeats INT,
    fare INT
    );
    
    CREATE TABLE order_details (
    book_date varchar(20),
    fullname VARCHAR(40),
    age VARCHAR(30),
    o_email VARCHAR(30) NOT NULL,
    address VARCHAR(150),
    flightNo VARCHAR(10),
    airline VARCHAR(30),
    source_place VARCHAR(30),
    destination_place VARCHAR(30),
    fare FLOAT,
    no_of_ppl INT
    ); 
    
CREATE table admin(
   a_username varchar(20),
   a_password varchar(20)
);
