
-- Create tables
CREATE TABLE Dentist (
    dentist_Id VARCHAR(10) PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    contactNumber VARCHAR(20),
    email VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE Patient (
    patient_Id VARCHAR(10) PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    contactNumber VARCHAR(20),
    email VARCHAR(100),
    mailingAddress VARCHAR(200),
    dateOfBirth DATE
);

CREATE TABLE Surgery_Location (
    surgeryLocation_Id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(200),
    telephoneNumber VARCHAR(20)
);

CREATE TABLE Appointment (
    appointment_Id VARCHAR(10) PRIMARY KEY,
    dentist_Id VARCHAR(10),
    patient_Id VARCHAR(10),
    date DATE,
    time TIME,
    surgeryLocation_Id VARCHAR(10),
    FOREIGN KEY (dentist_Id) REFERENCES Dentist(dentist_Id),
    FOREIGN KEY (patient_Id) REFERENCES Patient(patient_Id),
    FOREIGN KEY (surgeryLocation_Id) REFERENCES Surgery_Location(surgeryLocation_Id)
);

-- Insert dummy data
-- Dentists
INSERT INTO Dentist VALUES ('D001', 'John', 'Doe', '1234567890', 'johndoe@example.com', 'Orthodontics');
INSERT INTO Dentist VALUES ('D002', 'Jane', 'Smith', '0987654321', 'janesmith@example.com', 'Pedodontics');

-- Patients
INSERT INTO Patient VALUES ('P001', 'Alice', 'Johnson', '1112223333', 'alice@example.com', '123 Main St', '1985-04-12');
INSERT INTO Patient VALUES ('P002', 'Bob', 'Brown', '4445556666', 'bob@example.com', '456 Elm St', '1990-07-23');

-- Surgery Locations
INSERT INTO Surgery_Location VALUES ('S001', 'ADS Dental Clinic', '789 Pine St', '3334445555');

-- Appointments
INSERT INTO Appointment VALUES ('A001', 'D001', 'P001', '2023-10-10', '09:00:00', 'S001');
INSERT INTO Appointment VALUES ('A002', 'D002', 'P002', '2023-10-11', '11:00:00', 'S001');
