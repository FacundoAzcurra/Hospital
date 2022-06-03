package com.solvd.hospital.services.mybatis.servicesimpl;

import com.solvd.hospital.bin.Nurses;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.INursesDAO;
import com.solvd.hospital.services.mybatis.INursesService;
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
import java.util.ArrayList;
import java.util.List;

public class NursesService implements INursesService {
    private final static Logger LOGGER = LogManager.getLogger(NursesService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);

    @Override
    public List<Nurses> getNurses() {
        INursesDAO nursesDAO;
        List<Nurses> nursesList;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            nursesDAO = sqlSessionFactory.openSession().getMapper(INursesDAO.class);
            nursesList = new ArrayList<>();
            nursesList = nursesDAO.getList();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select all' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return nursesList;
    }

    @Override
    public void saveNurse(Nurses nurses) {
        INursesDAO nursesDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            nursesDAO = session.getMapper(INursesDAO.class);
            nursesDAO.insert(nurses);
            session.commit();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'insert' statement with myBatis" + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateNurseById(int idNurses, Nurses newNurse) {
        INursesDAO nursesDAO;
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            nursesDAO = session.getMapper(INursesDAO.class);
            newNurse.setNursesId(idNurses);
            nursesDAO.update(newNurse);
            session.commit();
        } catch (IOException | DAOException e) {
            LOGGER.info("Can't solve 'update' statement with myBatis " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Nurses getNurseById(int nursesId) {
        INursesDAO nursesDAO;
        Nurses n;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            nursesDAO = sqlSessionFactory.openSession().getMapper(INursesDAO.class);
            n = nursesDAO.getObject(nursesId);

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return n;
    }

    @Override
    public void deleteNurse(int nursesId) {
        INursesDAO nursesDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            nursesDAO = session.getMapper(INursesDAO.class);
            nursesDAO.delete(nursesId);
            session.commit();

        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'delete' statement with myBatis" + e);
            throw new RuntimeException();
        }
    }
    }


