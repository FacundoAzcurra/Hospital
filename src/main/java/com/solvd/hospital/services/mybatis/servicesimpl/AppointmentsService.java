package com.solvd.hospital.services.mybatis.servicesimpl;

import com.solvd.hospital.bin.Appointments;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IAppointmentsDAO;
import com.solvd.hospital.services.mybatis.IAppointmentsService;
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

public class AppointmentsService implements IAppointmentsService {
    private final static Logger LOGGER = LogManager.getLogger(AppointmentsService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);

    @Override
    public List<Appointments> getAppointments() {
        IAppointmentsDAO appointmentsDAO;
        List<Appointments> appointmentsList;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            appointmentsDAO = sqlSessionFactory.openSession().getMapper(IAppointmentsDAO.class);
            appointmentsList = new ArrayList<>();
            appointmentsList = appointmentsDAO.getList();

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select all' statement with myBatis" + e);
            throw new RuntimeException(e);
        };
        return appointmentsList;
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
            newAppointment.setAppointmentID(appointmentID);
            appointmentsDAO.update(newAppointment);
            session.commit();
        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'update' statement with myBatis" + e);
            throw new RuntimeException();
        }

    }

    @Override
    public Appointments getAppointmentById(int appointmentID) {
        IAppointmentsDAO appointmentsDAO;
        Appointments a;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            appointmentsDAO = sqlSessionFactory.openSession().getMapper(IAppointmentsDAO.class);
            a = appointmentsDAO.getObject(appointmentID);


        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return a;
    }

    @Override
    public void deleteAppointment(int appointmentID) {
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
