create Database HotelManagement;
use HotelManagement;

CREATE TABLE Customer (
    customerId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(15) NOT NULL,
    email VARCHAR(50),
    address VARCHAR(255)
);

-- Bảng Room
CREATE TABLE Room (
    roomId INT PRIMARY KEY,
    description VARCHAR(255),
	floor INT,
    type INT,
    status INT
);

-- Bảng Price
CREATE TABLE Price (
    priceId INT PRIMARY KEY,
    roomType INT,
    price FLOAT
);

-- Bảng Staff
CREATE TABLE Staff (
    staffId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    phoneNumber VARCHAR(15) NOT NULL,
    email VARCHAR(50),
    gender VARCHAR(10),
    address VARCHAR(255),
    role INT
);

-- Bảng Booking
CREATE TABLE Booking (
    bookingId INT PRIMARY KEY,
    customerId INT NOT NULL,
    roomId INT NOT NULL,
    priceId INT NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE,
    FOREIGN KEY (customerId) REFERENCES Customer (customerId),
    FOREIGN KEY (roomId) REFERENCES Room (roomId),
    FOREIGN KEY (priceId) REFERENCES Price (priceId)
);

-- Bảng Payment
CREATE TABLE Payment (
    paymentId INT PRIMARY KEY,
    bookingId INT NOT NULL,
    staffId INT NOT NULL,
    total_amount INT NOT NULL,
    paymentDate DATE NOT NULL,
    FOREIGN KEY (bookingId) REFERENCES Booking (bookingId),
    FOREIGN KEY (staffId) REFERENCES Staff (staffId)
);

INSERT INTO Staff (staffId, name, username, password, phoneNumber, email, gender, address, role)
VALUES (1, 'Tuan Anh', 'tuananh', '123456', '0375871003', 'tuananh301603@gmail.com', 'male', 'ND', 0);