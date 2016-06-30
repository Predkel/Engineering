package by.pvt.predkel.dao;

import by.pvt.predkel.entities.Entity;
import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

public interface DaoI<T extends Entity> {
    //READ чтение отдельной сущности
    T getById(long id) throws DaoException;

    //CREATE,UPDATE,DELETE обновление сущности
    void create(T entity) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(T entity) throws DaoException;

    //READ - чтение всех элементов по условию
    List<T> getAll() throws DaoException;

    Long getCountOfRows() throws DaoException;

    List<T> pagination(int firstResult, int maxResult) throws DaoException;

    Class getPersistentClass();

}
