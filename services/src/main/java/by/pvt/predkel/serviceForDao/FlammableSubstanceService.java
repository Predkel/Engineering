package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.dao.FlammableSubstanceDaoImpl;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.settings.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        new FlammableSubstanceDaoImpl().create(substance);
        tx.commit();
    }

    public void deleteSubstance(FlammableSubstance substance) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        new FlammableSubstanceDaoImpl().delete(substance);
        tx.commit();
    }

    public void updateSubstance(FlammableSubstance substance) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        new FlammableSubstanceDaoImpl().update(substance);
        tx.commit();
    }

    public List<FlammableSubstance> getAllSubstances() throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List<FlammableSubstance> list = new FlammableSubstanceDaoImpl().getAll();
        tx.commit();
        return list;
    }

    public FlammableSubstance readSubstance(Long id) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        FlammableSubstance substance = new FlammableSubstanceDaoImpl().getById(id);
        tx.commit();
        return substance;
    }

    public Long getCountOfSubstances() throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        Long count = new FlammableSubstanceDaoImpl().getCountOfRows();
        tx.commit();
        return count;
    }

    public List<FlammableSubstance> getSubstancesForPage(int page, int maxResult) throws DaoException {
        int firstResult = (page - 1) * maxResult;
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List<FlammableSubstance> list = new FlammableSubstanceDaoImpl().pagination(firstResult, maxResult);
        tx.commit();
        return list;
    }


}
