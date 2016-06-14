package by.pvt.predkel.newDao;

import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

public interface InterfaceDao<TYPE> {
    //READ чтение отдельной сущности
    TYPE read(int id) throws DaoException;

    //CREATE,UPDATE,DELETE обновление сущности
    void create(TYPE entity) throws DaoException;

    void update(TYPE entity) throws DaoException;

    void delete(TYPE entity) throws DaoException;

    //READ - чтение всех элементов по условию
    List<TYPE> getAll() throws DaoException;

}
