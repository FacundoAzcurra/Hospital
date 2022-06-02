package com.solvd.hospital.services.mybatis.servicesimpl;

import com.solvd.hospital.domain.Appointments;
import com.solvd.hospital.domain.Rooms;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IAppointmentsDAO;
import com.solvd.hospital.services.mybatis.AppointmentsService;
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

public class IAppointmentsService implements AppointmentsService {
    private final static Logger LOGGER = LogManager.getLogger(IAppointmentsService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);

    @Override
    public Appointments getAppointments(int appointmentID) {
        IAppointmentsDAO appointmentsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            appointmentsDAO = sqlSessionFactory.openSession().getMapper(IAppointmentsDAO.class);
            appointmentsDAO.getList();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select all' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void saveAppointments(Appointments appointments) {
        IAppointmentsDAO appointmentsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            appointmentsDAO = session.getMapper(IAppointmentsDAO.class);
            appointmentsDAO.insert(appointments);
            session.commit();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'insert' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAppointmentById(int appointmentID, Appointments newAppointment) {
        IAppointmentsDAO appointmentsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            appointmentsDAO = session.getMapper(IAppointmentsDAO.class);
            appointmentsDAO.update(newAppointment);
            session.commit();
        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'update' statement with myBatis" + e);
            throw new RuntimeException();
        }

    }

    @Override
    public Rooms getAppointmentById(int appointmentID) {
        IAppointmentsDAO appointmentsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            appointmentsDAO = sqlSessionFactory.openSession().getMapper(IAppointmentsDAO.class);
            appointmentsDAO.getObject(appointmentID);

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteAppointment(Appointments appointmentID) {
        IAppointmentsDAO appointmentsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            appointmentsDAO = session.getMapper(IAppointmentsDAO.class);
            appointmentsDAO.delete(appointmentID);
            session.commit();
        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'delete' statement with myBatis" + e);
            throw new RuntimeException();

    }
}
}
