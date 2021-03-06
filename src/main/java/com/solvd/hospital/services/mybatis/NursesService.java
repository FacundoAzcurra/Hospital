package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Nurses;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.INursesDAO;
import com.solvd.hospital.util.Constants;
import com.solvd.hospital.util.DBPropertiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NursesService extends AbstractService implements INursesService {
    private final static Logger LOGGER = LogManager.getLogger(NursesService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);

    @Override
    public List<Nurses> getNurses() {
        INursesDAO nursesDAO;
        List<Nurses> nursesList;
        try(SqlSession session = sqlSession()){
            nursesDAO = session.getMapper(INursesDAO.class);
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
        try(SqlSession session = sqlSession()){
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
        try (SqlSession session = sqlSession()){
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
        try(SqlSession session = sqlSession()){
            nursesDAO = session.getMapper(INursesDAO.class);
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
        try(SqlSession session = sqlSession()){
            nursesDAO = session.getMapper(INursesDAO.class);
            nursesDAO.delete(nursesId);
            session.commit();

        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'delete' statement with myBatis" + e);
            throw new RuntimeException();
        }
    }
    }


