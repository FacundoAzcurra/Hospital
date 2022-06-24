package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Rooms;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IRoomsDAO;
import com.solvd.hospital.util.Constants;
import com.solvd.hospital.util.DBPropertiesUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomsService extends AbstractService implements IRoomsService {
    private final static Logger LOGGER = LogManager.getLogger(RoomsService.class);
    private final static String MYBATIS_CONFIG = DBPropertiesUtil.getString(Constants.MYBATIS_CONFIG);
    @Override
    public List<Rooms> getRooms() {
        IRoomsDAO roomsDAO;
        List<Rooms> roomsList;
        try(SqlSession session = sqlSession()){
            roomsDAO = session.getMapper(IRoomsDAO.class);
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
        try(SqlSession session = sqlSession()){
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
        try(SqlSession session = sqlSession()){
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
            try (SqlSession session = sqlSession()){
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
        try(SqlSession session = sqlSession()){
            roomsDAO = session.getMapper(IRoomsDAO.class);
            r = roomsDAO.getObject(idRooms);

        } catch (IOException | DAOException e ) {
            LOGGER.info("Can´t solve 'select' statement with myBatis" + e);
            throw new RuntimeException(e);
        }
        return r;
    }
}
