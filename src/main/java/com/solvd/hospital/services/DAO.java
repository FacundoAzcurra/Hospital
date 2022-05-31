package com.solvd.hospital.services;

import java.util.List;

public interface DAO<T,K> {
    void insert(T a) throws DAOException;

    void update(T a) throws DAOException;

    void delete(T a) throws DAOException;

    List<T> getList() throws DAOException;

    T getObject(K id) throws DAOException;

}
