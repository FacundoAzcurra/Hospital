package com.solvd.hospital.services.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.solvd.hospital.bin.Medics;
import com.solvd.hospital.bin.Nurses;
import com.solvd.hospital.bin.Patients;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Json {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Patients patient = new Patients(1,true,"Tomas","Vino",1);
        Patients patient2 = new Patients(2,false,"Clapa","Estruco",2);
        Patients patient3 = new Patients(3,true,"Saul","Badman",3);
        Patients patient4 = new Patients(4,false,"Ramon","Sanchopanza",4);

        List<Patients> patients = new ArrayList<>();
        patients.add(patient);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);

        try{
            File file = new File("src/main/resources/patients.json");
            mapper.writeValue(file, patients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       /* try {
                JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Patients.class);
                List<Patients> patientsList = mapper.readValue(new File("parsedJSON.json"), type);

            } catch (IOException e) {
                e.printStackTrace();
            }
*/

            /* file = new File("src/main/resources/parsedJSON.json");
                if(!file.exists()){
                    file.createNewFile();
                }
                mapper.writeValue(file,patients);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
    }
}