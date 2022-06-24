package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Prescription;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IPrescriptionDAO;
import com.solvd.hospital.util.Constants;
import com.solvd.hospital.util.DBPropertiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionService extends AbstractService implements IPrescriptionServices {
    private final static Logger LOGGER = LogManager.getLogger(PrescriptionService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);

    @Override
    public List<Prescription> getPrescription() {
        IPrescriptionDAO prescriptionDAO;
        List<Prescription> prescriptionList;
        try(SqlSession session = sqlSession()){
            prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            prescriptionList = new ArrayList<>();
            prescriptionList = prescriptionDAO.getList();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select all' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return prescriptionList;
    }

    @Override
    public void savePrescription(Prescription prescription) {
        IPrescriptionDAO prescriptionDAO;
        try(SqlSession session = sqlSession()){
            prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.insert(prescription);
            session.commit();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'insert' statement with myBatis" + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updatePrescriptionById(int idPrescriptions, Prescription newPrescription) {
        IPrescriptionDAO prescriptionDAO;
        try(SqlSession session = sqlSession()){
            prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            newPrescription.setPrescriptionID(idPrescriptions);
            prescriptionDAO.update(newPrescription);
            session.commit();
        } catch (IOException | DAOException e) {
            LOGGER.info("Can't solve 'update' statement with myBatis " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Prescription getPrescriptionById(int prescriptionID) {
        IPrescriptionDAO prescriptionDAO;
        Prescription p;
        try(SqlSession session = sqlSession()){
            prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            p = prescriptionDAO.getObject(prescriptionID);

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public void deletePrescription(int prescriptionID) {
        IPrescriptionDAO prescriptionDAO;
        try(SqlSession session = sqlSession()){
            prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.delete(prescriptionID);
            session.commit();

        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'delete' statement with myBatis" + e);
            throw new RuntimeException();
        }
    }
}
