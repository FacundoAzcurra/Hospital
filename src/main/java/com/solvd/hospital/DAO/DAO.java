package com.solvd.hospital.DAO;

import java.util.List;

public interface DAO<T,K> {
    void insert(T a) throws DAOException;

    void update(T a) throws DAOException;

    void delete(int a) throws DAOException;

    List<T> getList() throws DAOException;

    T getObject(K id) throws DAOException;
}
