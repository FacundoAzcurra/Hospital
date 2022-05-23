insert into Hospital (idHospital,medicId,administrativesId) values (1,1,1);

INSERT INTO Administratives(idAdministratives, HospitalId) values (1,1);

INSERT INTO AmbulanceDriver (ambulanceDriverid, hasPcrKnowledge, firstName, lastName, idAmbulance) VALUES (1,1,"Sergio","Papafrita",1);

INSERT INTO Ambulances (idAmbulances, ambulanceDriverId, ambulance, hospitalId) VALUES (1,1,1,1);

INSERT INTO Appointments (idAppointments, medicId, AppointmentRoomId, patientId) VALUES (1,1,1,1);

INSERT INTO Medics(idMedics, sex, firstName, lastName, DoctorOfficeId, RoomId) values (2,"female","Lilita","Carrio",2,2);

INSERT INTO Rooms (idRooms,isAvailable,floor,MedicId,DoctorOfficeId) VALUES (2,1,1,2,2);

INSERT INTO Chirophane (idChirophane, isAvailable,floor,chirophaneRoom) VALUES (1,1,1,2);

INSERT INTO ChirophaneTrainees (idChirophaneTrainees, firstName, lastName, ChirophaneID) VALUES (1,"Facundo","Azcurra",1);

INSERT INTO Medics(idMedics, sex, firstName, lastName, DoctorOfficeId, RoomId) values (3,"female","Cristina","Kischner",3,3);

INSERT INTO Rooms (idRooms,isAvailable,floor,MedicId,DoctorOfficeId) VALUES (3,1,1,3,3);

INSERT INTO DeliveryRooms (idDeliveryRooms,childbirthDoctorId,roomsId,isAvailable,deliveryRoomsMedicId) VALUES (1,3,3,1,1);

INSERT INTO HealthCareInsurance (idHealthCare,price,category,idPatient) VALUES (1,100,"Gold",1);

INSERT INTO Patients (idPatient,isAttended,firstName,lastName,idHealthCare,idAppointments) VALUES (1,0,"Tomas","Lezama",123456,1);

ALTER TABLE `Facundo_Azcurra`.`HealthCareInsurance` 
ADD CONSTRAINT `idPatient`
FOREIGN KEY (`idPatient`)
REFERENCES `Facundo_Azcurra`.`Patients` (`idPatient`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

INSERT INTO DoctorOffice (idDoctorOffice, idMedics) VALUES (1,1);

INSERT INTO DoctorOffice (idDoctorOffice, idMedics) VALUES (2,2);

INSERT INTO DoctorOffice (idDoctorOffice, idMedics) VALUES (3,3);

INSERT INTO Medics(idMedics, sex, firstName, lastName, DoctorOfficeId, RoomId) values (4,"male","Tobias","Fate",4,4);

INSERT INTO Rooms (idRooms,isAvailable,floor,MedicId,DoctorOfficeId) VALUES (4,1,1,4,4);

INSERT INTO IntensiveCare (idIntensiveCare, intensiveCareRoomId,intensiveCareAppointedMedic,RoomId) VALUES (1,4,4,4);

INSERT INTO Managers (idManager,directorManager,economicsManager,idHospital) VALUES (1,0,1,1);

INSERT INTO MedicTrainees (idMedicTrainees, firstName, lastName, MedicRoomId) VALUES (1,"Santiago","Tennox",1);

ALTER TABLE `Facundo_Azcurra`.`Nurses` 
ADD CONSTRAINT `ChirophaneNurse`
FOREIGN KEY (`chirophaneRoomId`)
REFERENCES `Facundo_Azcurra`.`Chirophane` (`chirophaneRoom`),
ADD CONSTRAINT `IntensiveCareNurse`
FOREIGN KEY (`intensiveCareIdRoom`)
REFERENCES `Facundo_Azcurra`.`IntensiveCare` (`idIntensiveCare`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

INSERT INTO Nurses (idNurses, firstName, lastName, intensiveCareIdRoom,chirophaneRoomId) values (1,"Nachito","Lopez",4,2);

INSERT INTO Prescription (idPrescription, prescriptionPrice, medicId, patientId) VALUE (1,100,1,1);


