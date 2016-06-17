package by.pvt.predkel.dao;

import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

public interface DaoI<TYPE> {
    //READ чтение отдельной сущности
    TYPE getById(long id) throws DaoException;

    //CREATE,UPDATE,DELETE обновление сущности
    void create(TYPE entity) throws DaoException;

    void update(TYPE entity) throws DaoException;

    void delete(TYPE entity) throws DaoException;

    //READ - чтение всех элементов по условию
    List<TYPE> getAll() throws DaoException;

    Long getCountOfRows() throws DaoException;

    List<TYPE> pagination(int firstResult, int maxResult) throws DaoException;

    Class getPersistentClass();

}
