package com.solvd.hospital.services.mybatis.servicesimpl;

import com.solvd.hospital.domain.Rooms;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IRoomsDAO;
import com.solvd.hospital.services.mybatis.IRoomsService;
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

public class RoomsService implements IRoomsService {
    private final static Logger LOGGER = LogManager.getLogger(RoomsService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);
    @Override
    public List<Rooms> getRooms() {
        IRoomsDAO roomsDAO;
        List<Rooms> roomsList;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            roomsDAO = sqlSessionFactory.openSession().getMapper(IRoomsDAO.class);
            roomsList = new ArrayList<>();
            roomsList = roomsDAO.getList();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select all' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return roomsList;
    }

    @Override
    public void saveRooms(Rooms rooms) {
        IRoomsDAO roomsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            roomsDAO = session.getMapper(IRoomsDAO.class);
            roomsDAO.insert(rooms);
            session.commit();
        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'insert' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
    }

    public void deleteRoom(int idRooms) {
        IRoomsDAO roomsDAO;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            roomsDAO = session.getMapper(IRoomsDAO.class);
            roomsDAO.delete(idRooms);
            session.commit();

        } catch (IOException  | DAOException e) {
            LOGGER.info("Can´t solve 'delete' statement with myBatis" + e);
            throw new RuntimeException();
    }
    }

    @Override
    public void updateRoomById(int idRooms, Rooms newRoom) {
            IRoomsDAO roomsDAO;
            try {
                Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                SqlSession session = sqlSessionFactory.openSession();
                roomsDAO = session.getMapper(IRoomsDAO.class);
                newRoom.setidRooms(idRooms);
                roomsDAO.update(newRoom);
                session.commit();
            } catch (IOException | DAOException e) {
                LOGGER.info("Can't solve 'update' statement with myBatis " + e);
                throw new RuntimeException(e);
            }
    }

    @Override
    public Rooms getRoomsById(int idRooms) {
        IRoomsDAO roomsDAO;
        Rooms r;
        try{
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            roomsDAO = sqlSessionFactory.openSession().getMapper(IRoomsDAO.class);
            r = roomsDAO.getObject(idRooms);

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return r;
    }
}
