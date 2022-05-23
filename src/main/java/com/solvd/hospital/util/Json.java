package com.solvd.hospital.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.solvd.hospital.bin.Medics;
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

        try {
            String json = mapper.writeValueAsString(patient);
            System.out.println("ResultingJSONstring = " + json);

            FileWriter fileWriter = new FileWriter(new File("src/main/resources/patient.json",json));

            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}