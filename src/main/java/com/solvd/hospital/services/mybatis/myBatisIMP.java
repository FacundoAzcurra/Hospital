package com.solvd.hospital.services.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class myBatisIMP implements myBatisDAO {
    private static final Logger LOGGER = LogManager.getLogger(myBatisIMP.class);
    private final MySessionFactory instance =  MySessionFactory.getInstance();

    @Override
    public String getVersionMysql() {
        String version = "";

        SqlSession session = null;

        try{
            session = instance.getFactory().openSession();
            version = session.selectOne("mysqlVersion");

        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } finally {
            if (session != null){
                session.close();
            }
        }

        return version;
    }
}