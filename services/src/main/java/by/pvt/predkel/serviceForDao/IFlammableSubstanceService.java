package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

/**
 * Created by Admin on 02.07.2016.
 */
public interface IFlammableSubstanceService extends IService<FlammableSubstance> {
    Long getCountOfSubstances() throws DaoException;

    List<FlammableSubstance> getSubstancesForPage(int page, int maxResult) throws DaoException;
}