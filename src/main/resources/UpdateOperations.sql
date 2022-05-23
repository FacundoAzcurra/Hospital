UPDATE AmbulanceDriver
SET hasPCRKnowledge = 1
WHERE ambulanceDriverid=1;

UPDATE Medics
set firstName = "Satrapa"
where idMedics = 1;

UPDATE Medics
set lastName = "Sacarepopa"
where idMedics = 1;

UPDATE DeliveryRooms	
set isAvailable = 0
where idDeliveryRooms = 1;

Update Chirophane
set floor = 3
where idChirophane = 1;

UPDATE Patients
set lastName = "Chacacampeon"
where idPatient = 1;

Update Ambulances
set ambulance = 20
where idAmbulances = 1;

Update MedicTrainees
set idMedicTrainees = 777
where idMedicTrainees = 1;

Update ChirophaneTrainees
set firstName = "Saul"
where idChirophaneTrainees = 1;

Update ChirophaneTrainees
set lastName = "Goodman"
where idChirophaneTrainees = 1;