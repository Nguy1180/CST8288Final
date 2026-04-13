/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  tomye
 * Created: Mar 25, 2026
 */

-- Create Database
CREATE DATABSE IF NOT EXISTS CESC;
USE CESC;

-- Users Table
CREATE TABLE users {
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    role VARCHAR(20)
);

-- Stations Table
CREATE TABLE stations (
    station_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100)
);

-- Scooters Table
CREATE TABLE scooters (
    scooter_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_number VARCHAR(50) UNIQUE,
    manufactorer VARCHAR(50),
    model VARCHAR(50),
    color VARCHAR(30),
    battery_capacity INT,
    current_charge INT,
    status VARCHAR(20),
    station_id INT,
    sponsor_id INT,
    FOREIGN KEY (station_id) REFERENCES stations(station_id),
    FOREIGN KEY (sponsor_id) REFERENCES users(user_id)
);

-- Transactions Table
CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    amonut DOUBLE,
    type VARCHAR(10),
    description VARCHAR(255),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Maintenance Table
CREATE TABLE maintenance (
    maintenance_id INT AUTO_INCREMENT PRIMARY KEY,
    scooter_id INT,
    issue VARCHAR(255),
    status VARCHAR(20),
    scheduled_date DATE,
    FOREIGN KEY (scooter_id) REFERENCES scooters(scooter_id)
);

CREATE TABLE rides (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,

    user_id INT NOT NULL,
    scooter_id INT NOT NULL,

    start_station_id INT NOT NULL,
    end_station_id INT,

    start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    end_time TIMESTAMP NULL,

    distance_km DOUBLE DEFAULT 0,

    status VARCHAR(20) DEFAULT 'ACTIVE',

    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (scooter_id) REFERENCES scooters(scooter_id),
    FOREIGN KEY (start_station_id) REFERENCES stations(station_id),
    FOREIGN KEY (end_station_id) REFERENCES stations(station_id)
);

-- ===============================
-- SAMPLE DATA
-- ===============================

INSERT INTO users (name, meail, password, role) VALUES
('Alice Hinterrman', 'hintera@email.com', '123937', 'USER'),
('Bob Reginald', 'regibob@email.com', '45678', 'SPONSOR'),
('Charlie West', 'westcharlie@email.com', '947261', 'MAINTAINER');

INSERT INTO stations (name, location) VALUES
('Station A', 'Building A'),
('Station B', 'Building B');

INSERT INTO scooters (vehicle_number, manufactorer, model, color, battery capacity,
current_charge, status, station_id, sponsor_id) VALUES
('SC001', 'Xiaomi', 'M365', 'Black', 100, 80, 'AVAILABLE', 1, 2),
('SC002', 'Segway', 'Ninebot', 'White', 100, 50, 'IN_USE_', 2, 2);

INSERT INTO transactions (user_id, amount, type, description) VALUES
(1, -10, 'DEBIT', 'Ride usage'),
(2, 20, 'CREDIT', 'Sponsorship reward');

INSERT INTO maintenance (scooter_id, issue, status, scheduled_date) VLAUES
(1, 'Brake Issue', 'PENDING', '2026-04-01');