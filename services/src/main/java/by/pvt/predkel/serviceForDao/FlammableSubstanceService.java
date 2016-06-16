package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.dao.FlammableSubstanceDaoImpl;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

/**
 * Created by Admin on 14.05.2016.
 */
public class FlammableSubstanceService {
    private static FlammableSubstanceService instance;

    private FlammableSubstanceService() {
    }

    public static synchronized FlammableSubstanceService getInstance() {
        if (instance == null) {
            instance = new FlammableSubstanceService();
        }
        return instance;
    }

    public void createSubstance(FlammableSubstance substance) throws DaoException {
        //FlammableSubstanceDao.getInstance().create(substance);
        new FlammableSubstanceDaoImpl().create(substance);
    }

    public void deleteSubstance(FlammableSubstance substance) throws DaoException {
        //FlammableSubstanceDao.getInstance().delete(substance);
        new FlammableSubstanceDaoImpl().delete(substance);
    }

    public void updateSubstance(FlammableSubstance substance) throws DaoException {
        //FlammableSubstanceDao.getInstance().update(substance);
        new FlammableSubstanceDaoImpl().update(substance);
    }

    public List<FlammableSubstance> getAllSubstances() throws DaoException {
        //return FlammableSubstanceDao.getInstance().getAll();
        return new FlammableSubstanceDaoImpl().getAll();
    }

    public FlammableSubstance readSubstance(Long id) throws DaoException {
        //return FlammableSubstanceDao.getInstance().read(id);
        return new FlammableSubstanceDaoImpl().getById(id);
    }

    public Long getCountOfSubstances() throws DaoException {
        return new FlammableSubstanceDaoImpl().getCount();
    }

    public List<FlammableSubstance> getSubstancesForPage(int page, int maxResult) throws DaoException {
        int firstResult = (page - 1) * maxResult;
        return new FlammableSubstanceDaoImpl().pagination(firstResult, maxResult);
    }


}
