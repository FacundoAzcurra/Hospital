package com.solvd.hospital.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBPropertiesUtil {
    private final static Logger LOG = LogManager.getLogger(DBPropertiesUtil.class);
    private static Properties properties = new Properties();
    private static DBPropertiesUtil dbPropertiesUtil = new DBPropertiesUtil();

    private DBPropertiesUtil() {
        try {
            properties.load(new FileReader(new File("src/main/resources/db.properties")));
        } catch (IOException e) {
            LOG.error("IO Exception while reading properties", e);
        }
    }

        public static String getString(String key){
            return properties.getProperty(key);
        }

        public static int getInt(String key){
            return Integer.parseInt(properties.getProperty(key));
        }

}
