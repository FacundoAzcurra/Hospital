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

SELECT Patients.idPatient, Prescription.patientId
FROM Patients
LEFT JOIN Prescription ON Patients.idPatient = Prescription.patientId
ORDER BY Patients.firstName;

SELECT Medics.idMedics, Prescription.medicId
FROM Medics
LEFT JOIN Prescription ON Medics.idMedics = Prescription.medicId
ORDER BY Medics.firstName;

SELECT Patients.idPatient, HealthCareInsurance.idPatient
FROM Patients
LEFT JOIN HealthCareInsurance ON Patients.idPatient = HealthCareInsurance.idPatient
ORDER BY Patients.firstName;

SELECT Managers.idHospital, Hospital.idHospital
FROM Managers
LEFT JOIN Hospital ON Managers.idHospital = Hospital.idHospital
ORDER BY Managers.idHospital;

SELECT Managers.idManager, Hospital.administrativesId
FROM Managers
LEFT JOIN Hospital ON Managers.idManager = Hospital.administrativesId
ORDER BY Managers.idManager;

SELECT DeliveryRooms.deliveryRoomsMedicId, Medics.idMedics
FROM DeliveryRooms
RIGHT JOIN Medics ON DeliveryRooms.deliveryRoomsMedicId = Medics.idMedics
ORDER BY DeliveryRooms.deliveryRoomsMedicId;

SELECT Medics.RoomId, Rooms.idRooms
FROM Medics
RIGHT JOIN Rooms ON Medics.RoomId = Rooms.idRooms
ORDER BY Medics.RoomId;

SELECT DoctorOffice.idDoctorOffice, Rooms.DoctorOfficeId
FROM DoctorOffice
RIGHT JOIN Rooms ON DoctorOffice.idDoctorOffice = Rooms.DoctorOfficeId
ORDER BY DoctorOffice.idDoctorOffice;

SELECT DoctorOffice.idMedics, Medics.idMedics
FROM DoctorOffice
RIGHT JOIN Medics ON DoctorOffice.idMedics = Medics.idMedics
ORDER BY DoctorOffice.idMedics;

SELECT Ambulances.ambulanceDriverId, AmbulanceDriver.ambulanceDriverid
FROM Ambulances
RIGHT JOIN AmbulanceDriver ON Ambulances.ambulanceDriverId = AmbulanceDriver.ambulanceDriverid
ORDER BY Ambulances.ambulanceDriverId;
