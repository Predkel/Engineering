package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

/**
 * Created by Admin on 02.07.2016.
 */
public interface IBuildingService extends IService<Building> {
    Building getBuildingByFkAndName(Building building) throws DaoException;

    List<Building> getAllByFk(Long userId) throws DaoException;

    boolean addBuilding(Building building) throws DaoException;
}
