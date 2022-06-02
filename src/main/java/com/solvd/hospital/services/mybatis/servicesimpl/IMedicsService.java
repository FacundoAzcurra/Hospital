package com.solvd.hospital.services.mybatis.servicesimpl;


import com.solvd.hospital.domain.Medics;
import com.solvd.hospital.services.DAOException;
import com.solvd.hospital.services.IMedicsDAO;
import com.solvd.hospital.services.IMedicsDAO;
import com.solvd.hospital.services.mybatis.MedicsService;
import com.solvd.hospital.util.Constants;
import com.solvd.hospital.util.DBPropertiesUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;


public class IMedicsService implements MedicsService {
    private final static Logger LOGGER = LogManager.getLogger(IMedicsService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);


    @Override
    public Medics getMedics(int idMedics) {
        IMedicsDAO medicsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            medicsDAO = sqlSessionFactory.openSession().getMapper(IMedicsDAO.class);
            medicsDAO.getList();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select all' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void saveMedic(Medics medics) {
        IMedicsDAO medicsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            medicsDAO = session.getMapper(IMedicsDAO.class);
            medicsDAO.insert(medics);
            session.commit();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'insert' statement with myBatis" + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateMedicById(int idMedics, Medics newMedic) {
        IMedicsDAO medicsDAO;
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            medicsDAO = session.getMapper(IMedicsDAO.class);
            medicsDAO.update(newMedic);
            session.commit();
        } catch (IOException | DAOException e) {
            LOGGER.info("Can't solve 'update' statement with myBatis " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Medics getMedicById(int idMedics) {
        IMedicsDAO medicsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            medicsDAO = sqlSessionFactory.openSession().getMapper(IMedicsDAO.class);
            medicsDAO.getObject(idMedics);

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteMedic(Medics idMedics) {
        IMedicsDAO medicsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            medicsDAO = session.getMapper(IMedicsDAO.class);
            medicsDAO.delete(idMedics);
            session.commit();

        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'delete' statement with myBatis" + e);
            throw new RuntimeException();
        }
    }
}
