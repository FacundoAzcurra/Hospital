SELECT Medics.idMedics, Rooms.MedicId, Medics.RoomId
FROM Medics
INNER JOIN Rooms ON Medics.idMedics=Rooms.MedicId;

SELECT MedicTrainees.idMedicTrainees, Medics.idMedics
FROM MedicTrainees
INNER JOIN Medics
ON  MedicTrainees.idMedicTrainees = Medics.idMedics;

SELECT AmbulanceDriver.idAmbulance, Ambulances.idAmbulances
FROM Ambulances
INNER JOIN AmbulanceDriver
ON Ambulances.idAmbulances = AmbulanceDriver.idAmbulance;

SELECT HealthCareInsurance.idHealthCare,Patients.idPatient
FROM Patients
INNER JOIN HealthCareInsurance
ON Patients.idPatient = HealthCareInsurance.idHealthCare;

SELECT Patients.idPatient,Prescription.idPrescription
FROM Prescription
INNER JOIN Patients
ON Prescription.idPrescription = Patients.idPatient;

SELECT idMedics
FROM Medics
GROUP BY idMedics

SELECT idRooms
FROM Rooms
GROUP BY idRooms

SELECT appointmentId
FROM Appointments
GROUP BY appointmentId

SELECT idChirophaneTrainees
FROM ChirophaneTrainees
GROUP BY idChirophaneTrainees

SELECT idNurses
FROM Nurses
GROUP BY idNurses

SELECT COUNT(idMedics), Medics
FROM Medics
GROUP BY idMedics
HAVING COUNT(idMedics) > 5;

SELECT COUNT(idRooms), Rooms
FROM Rooms
GROUP BY idRooms
HAVING COUNT(idRooms) > 5;

SELECT COUNT(appointmentId), Appointments
FROM Appointments
GROUP BY appointmentId
HAVING COUNT(appointmentId) > 5;

SELECT COUNT(idNurses), Nurses
FROM Nurses
GROUP BY idNurses
HAVING COUNT(idNurses) > 5;

SELECT COUNT(idChirophaneTrainees), ChirophaneTrainees
FROM ChirophaneTrainees
GROUP BY idChirophaneTrainees
HAVING COUNT(idChirophaneTrainees) > 5;