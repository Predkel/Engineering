package by.pvt.predkel.dao;

import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.settings.HibernateUtil;
import by.pvt.predkel.utils.PaymentSystemLogger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 29.05.2016.
 */
public class DaoGeneral<T> implements DaoI<T> {
    private static DaoGeneral instance;
    private String message;
    private T entity;

    @Override
    public T getById(long id) throws DaoException {
        Session session = null;
        T t = null;
        try {
            session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            t = (T) session.load(getPersistentClass(), id);
            tx.commit();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            message = "Unable to get entity by id";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
        return t;
    }

    @Override
    public void create(T t) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            session.save(t);
            tx.commit();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            message = "Unable to save entity";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
    }

    @Override
    public void update(T t) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            message = "Unable to update entity";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
    }

    @Override
    public void delete(T t) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            message = "Unable to delete entity";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
    }

    @Override
    public List<T> getAll() throws DaoException {
        Session session = null;
        List t = new ArrayList<>();
        try {
            session = HibernateUtil.currentSession();
            t = (List<T>) session.createCriteria(getPersistentClass()).list();
        } catch (NullPointerException e1) {
            return new ArrayList<>();
        } catch (Exception e) {
            message = "Unable to get all entities";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
        return t;
    }

    @Override
    public Class getPersistentClass() {
        return entity.getClass();
    }
}
