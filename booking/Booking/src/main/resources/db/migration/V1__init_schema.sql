-- Users table (tutors and clients)
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    role VARCHAR(50) NOT NULL  -- e.g., 'TUTOR', 'CLIENT'
);

-- Availability table
CREATE TABLE IF NOT EXISTS availability (
    id SERIAL PRIMARY KEY,
    tutor_id INTEGER REFERENCES users (id) ON DELETE CASCADE,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    booked BOOLEAN DEFAULT FALSE
);

-- Bookings table
CREATE TABLE IF NOT EXISTS booking (
    id SERIAL PRIMARY KEY,
    availability_id INTEGER REFERENCES availability(id) ON DELETE CASCADE,
    client_name VARCHAR(255),
    client_email VARCHAR(255),
    notes TEXT,
    payment_status VARCHAR(50) DEFAULT 'PENDING'  -- e.g., 'PENDING', 'PAID'
);

-- Indexes for performance
CREATE INDEX idx_availability_tutor ON availability(tutor_id);
CREATE INDEX idx_booking_availability ON booking(availability_id);
