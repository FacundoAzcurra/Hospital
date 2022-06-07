package com.solvd.hospital.services.jaxb;


import com.solvd.hospital.bin.Prescription;
import com.solvd.hospital.bin.Rooms;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Jaxb {
    private static final Logger LOG = LogManager.getLogger(Jaxb.class);

    public Prescription unmarshall(String path) {
        File file = new File(path);
        JAXBContext jaxb;
        try {
            jaxb = JAXBContext.newInstance(Prescription.class);
            Unmarshaller unmarshaller = jaxb.createUnmarshaller();
            return (Prescription) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            LOG.error(e);
        }
        return null;
    }


    public void marshall(Prescription prescription, String path){
        JAXBContext jaxb;
            try {
                jaxb = JAXBContext.newInstance(Prescription.class);
                Marshaller marshaller = jaxb.createMarshaller();
                marshaller.marshal(prescription, new File(path));
            } catch (JAXBException e) {
                LOG.error(e);
            }
        }
    }



  //  JAXBContext context = JAXBContext.newInstance(Rooms.class);
  //  Marshaller mar = context.createMarshaller();
  //      mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
  //              File file = new File("src/main/resources/Rooms.xml");
  //              if (!file.exists()) {
  //              file.createNewFile();
  //              }
  //              mar.marshal(new Rooms(1, true, 1, 1, 1), file);