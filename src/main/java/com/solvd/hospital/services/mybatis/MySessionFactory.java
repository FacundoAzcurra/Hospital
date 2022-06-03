package com.solvd.hospital.services.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MySessionFactory {
    private static final Logger LOGGER = LogManager.getLogger(MySessionFactory.class);
    private static MySessionFactory instance;
    private static SqlSessionFactory factory;

    private MySessionFactory(){
        String resource = "mybatisConfig.xml";
        Reader reader = null;

        try{
            reader = Resources.getResourceAsReader(resource);
            factory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();

        }catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static MySessionFactory getInstance(){
        if(instance == null){
            instance = new MySessionFactory();
        }
        return instance;
    }

    public static SqlSessionFactory getFactory() {
        return factory;
    }
}