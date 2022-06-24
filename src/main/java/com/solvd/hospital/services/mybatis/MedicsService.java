package com.solvd.hospital.services.mybatis;


import com.solvd.hospital.bin.Medics;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IMedicsDAO;
import com.solvd.hospital.util.Constants;
import com.solvd.hospital.util.DBPropertiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MedicsService extends AbstractService implements IMedicsService {
    private final static Logger LOGGER = LogManager.getLogger(MedicsService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);


    @Override
    public List<Medics> getMedics() {
        IMedicsDAO medicsDAO;
        List<Medics> medicsList;
        try(SqlSession session = sqlSession()){
            medicsDAO = session.getMapper(IMedicsDAO.class);
            medicsList = new ArrayList<>();
            medicsList = medicsDAO.getList();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select all' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return medicsList;
    }

    @Override
    public void saveMedic(Medics medics) {
        IMedicsDAO medicsDAO;
        try(SqlSession session = sqlSession()){
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
        try(SqlSession session = sqlSession()) {
            medicsDAO = session.getMapper(IMedicsDAO.class);
            newMedic.setidMedics(idMedics);
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
        Medics m;
        try(SqlSession session = sqlSession()){
            medicsDAO = session.getMapper(IMedicsDAO.class);
            m = medicsDAO.getObject(idMedics);

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return m;
    }

    @Override
    public void deleteMedic(int idMedics) {
        IMedicsDAO medicsDAO;
        try(SqlSession session = sqlSession()){
            medicsDAO = session.getMapper(IMedicsDAO.class);
            medicsDAO.delete(idMedics);
            session.commit();

        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'delete' statement with myBatis" + e);
            throw new RuntimeException();
        }
    }
}
