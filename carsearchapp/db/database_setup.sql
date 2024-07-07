-- Step 1: Create the database
CREATE DATABASE car_db;
GO

-- Step 2: Use the database
USE car_db;
GO

-- Step 3: Create the Car table
CREATE TABLE Car (
    id INT PRIMARY KEY,
    color VARCHAR(50),
    length FLOAT,
    velocity FLOAT,
    weight FLOAT
);
GO

-- Step 4: Insert data into the Car table
INSERT INTO Car (id, color, length, velocity, weight)
VALUES 
    (1, 'Red', 4.5, 220.5, 1200.75),
    (2, 'Blue', 4.2, 210.25, 1150.50),
    (3, 'Green', 4.8, 230.75, 1300.25),
    (4, 'Yellow', 4.1, 215.0, 1180.0),
    (5, 'Black', 4.9, 225.5, 1220.5),
    (6, 'White', 4.3, 205.75, 1125.25),
    (7, 'Silver', 4.6, 222.25, 1250.0),
    (8, 'Gray', 4.4, 212.0, 1175.5),
    (9, 'Purple', 4.7, 228.0, 1285.75),
    (10, 'Orange', 4.0, 200.0, 1100.0);
GO