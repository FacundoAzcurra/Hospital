CREATE TABLE Medics (
    idMedics int,
    sex varchar(255),
    firstName varchar(255),
    lastName varchar(255),
    DoctorOfficeId int,
    RoomId int
);

CREATE TABLE Administratives(
idAdministratives int,
HospitalId int
);

CREATE TABLE Managers(
idManagers int,
economicsManager tinyint,
directorManager tinyint,
HospitalId int
);

create table Ambulances(
idAmbulances int PRIMARY KEY, 
ambulanceDriverId int, 
ambulance int,
hospitalId int
);

create table AmbulanceDriver(
ambulanceDriverid int, 
hasPcrKnowledge tinyint,
firstName varchar(255),
lastName varchar(255)
);

create table MedicTrainees(
idMedicTrainees int,
firstName varchar(255),
lastName varchar(255),
MedicRoomId int
);

CREATE TABLE Hospital(
idHospital int PRIMARY KEY NOT NULL,
medicId int,
administrativesId int
);

CREATE TABLE DeliveryRooms(
idDeliveryRooms int,
childbirthDoctorId int,
roomsId int,
isAvailable tinyint,
deliveryRoomsMedicId int
);

CREATE TABLE ChirophaneTrainees(
idChirophaneTrainees int PRIMARY KEY NOT NULL,
firstName varchar(255),
lastName varchar(255),
ChirophaneID int
);

CREATE TABLE Chirophane(
idChirophane int,
isAvailable tinyint,
floor int,
chirophaneRoom int
);

CREATE TABLE Nurses(
idNurses int,
firstName varchar(255),
lastName varchar(255),
intensiveCareIdRoom int,
chirophaneRoomId int
);

CREATE TABLE IntensiveCare(
idIntensiveCare int,
intensiveCareRoomId int,
intensiveCareAppointedMedic int
);

CREATE TABLE Appointments(
idAppointments int,
medicId INT,
AppointmentRoomId int,
patientId int
);

CREATE TABLE Prescription(
idPrescription int,
prescriptionPrice double,
medicId int,
patientId int
);

CREATE TABLE HealthCareInsurance(
idHealthCare int NOT NULL PRIMARY KEY,
price double,
category varchar(255)
);

CREATE TABLE Patients(
idPatient int,
isAttended tinyint,
firstName varchar(255),
lastName varchar(255),
idHealthCare int,
idAppointments int
);

CREATE TABLE DoctorOffice(
idDoctorOffice int,
idMedics int
);


CREATE TABLE Managers (
    idManager int NOT NULL,
    directorManager tinyint,
    economicsManager tinyint,
    idHospital int,
    PRIMARY KEY (idManager),
    FOREIGN KEY (idHospital) REFERENCES Hospital(idHospital)
);


ALTER TABLE IntensiveCare
add RoomId int,
ADD FOREIGN KEY (RoomId) REFERENCES Rooms(idRooms);

ALTER TABLE Medics
ADD FOREIGN KEY (RoomId) references Rooms(idRooms);

ALTER TABLE Rooms
ADD FOREIGN KEY (MedicId) REFERENCES Medics(idMedics);

ALTER TABLE Administratives
ADD PRIMARY KEY (idAdministratives);

ALTER TABLE AmbulanceDriver
ADD FOREIGN KEY (idAmbulance) references Ambulances(idAmbulances);

ALTER TABLE Ambulances
ADD FOREIGN KEY (hospitalId) REFERENCES Hospital(idHospital);

ALTER TABLE Chirophane
add primary key (idChirophane),
add foreign key (chirophaneRoom) REFERENCES Rooms(idRooms);

ALTER TABLE ChirophaneTrainees
add foreign key (chirophaneID) REFERENCES Chirophane(idChirophane);

ALTER TABLE DeliveryRooms
add primary key (idDeliveryRooms),
add foreign key (roomsId) REFERENCES Rooms(idRooms);

ALTER TABLE DoctorOffice
add primary key (idDoctorOffice),
add foreign key (idMedics) REFERENCES Medics(idMedics);

ALTER TABLE HealthCareInsurance
ADD FOREIGN KEY (idPatient) REFERENCES Patients(idPatient);

ALTER TABLE Hospital
add foreign key (medicId) REFERENCES Medics(idMedics);

ALTER TABLE MedicTrainees
add primary key (idMedicTrainees),
add foreign key (MedicRoomId) REFERENCES Medics(RoomId);

ALTER TABLE Nurses
add primary key (idNurses),
add foreign key (intensiveCareIdRoom) REFERENCES IntensiveCareIntensiveCare(RoomId),
add foreign key (chirophaneRoomId) REFERENCES Chirophane(chirophaneRoom);

ALTER TABLE Patients
add foreign key (idHealthCare) REFERENCES HealthCareInsurance(idPatient),
ADD FOREIGN KEY (idAppointments) REFERENCES Appointments(idAppointments);

ALTER TABLE Prescription
add primary key (idPrescription),
add foreign key (medicId) REFERENCES Medics(idMedics),
add foreign key (patientId) REFERENCES Patients(idPatient);