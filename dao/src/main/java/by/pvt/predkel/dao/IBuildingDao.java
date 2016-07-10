package by.pvt.predkel.dao;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 02.07.2016.
 */
public interface IBuildingDao extends DaoI<Building> {
    @Override
    void delete(Building building) throws DaoException;

    @Override
    void update(Building building) throws DaoException;

    @Override
    Serializable create(Building building) throws DaoException;

    Building isCreated(Building entity) throws DaoException;

    List<Building> geAllByFk(Long userId) throws DaoException;
}
