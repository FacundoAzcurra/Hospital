package com.solvd.hospital.util;


import com.solvd.hospital.bin.Medics;
import com.solvd.hospital.bin.Rooms;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;

public class Parser {
    public static void main(String[] args) throws JAXBException {


       JAXBContext context = JAXBContext.newInstance(Rooms.class);
       Marshaller mar = context.createMarshaller();
       mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
       mar.marshal(new Rooms(1,true,1,1,1),new File("src/main/resources/Rooms.xml"));




     /* try {
            JAXBContext context = JAXBContext.newInstance(Rooms.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
          mar.marshal(new Rooms(1,true,1,1,1),new File("src/main/resources/Rooms.xml"));
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }*/
    }
}
