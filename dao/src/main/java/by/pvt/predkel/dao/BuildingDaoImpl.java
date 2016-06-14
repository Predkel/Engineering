package by.pvt.predkel.dao;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.factory.MyEntityObjectFactory;
import by.pvt.predkel.settings.HibernateUtil;
import by.pvt.predkel.utils.PaymentSystemLogger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Admin on 29.05.2016.
 */
public class BuildingDaoImpl extends DaoGeneral<Building> {
    private String message;
    private Building building = new MyEntityObjectFactory().createBuilding();

    @Override
    public void delete(Building building) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            User user = (User) session.load(User.class, building.getUserId());
            building.setUser(user);
            session.delete(building);
            tx.commit();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            message = "Unable to update building";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
    }

    @Override
    public void update(Building building) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            User user = (User) session.load(User.class, building.getUserId());
            building.setUser(user);
            session.update(building);
            tx.commit();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            message = "Unable to update building";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
    }

    @Override
    public void create(Building building) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.currentSession();//напрямую нельзя добавить здание
            Transaction tx = session.beginTransaction();//т.к. оно зависит от юзера
            User user = (User) session.load(User.class, building.getUserId());//поэтому достаем (прокси) юзера
            user.getBuilding().add(building);// добавляем ему здание
            session.update(user);// и сохраняем юзера
            tx.commit();
            HibernateUtil.closeSession();
        } catch (Exception e) {
            message = "Unable to save building";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
    }

    public Building isCreated(Building entity) throws DaoException {
        Session session = null;
        Building building = new MyEntityObjectFactory().createBuilding();
        try {
            session = HibernateUtil.currentSession();
//            Query query=session.createQuery("from Building where userId=:userId and nameOfBuilding=:name");
//            query.setParameter("userId",entity.getUserId());
//            query.setParameter("name",entity.getNameOfBuilding());
//            t = query.list();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            userCriteria.add(Restrictions.eq("userId", entity.getUserId()));
            userCriteria.add(Restrictions.eq("nameOfBuilding", entity.getNameOfBuilding()));
            building = (Building) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to get building by name and foreign key";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
        return building;
    }

    public List<Building> geAllByFk(Long userId) throws DaoException {
        Session session = null;
        List<Building> buildings;
        try {
            session = HibernateUtil.currentSession();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            userCriteria.add(Restrictions.eq("userId", userId));
            buildings = (List<Building>) userCriteria.list();
        } catch (Exception e) {
            message = "Unable to get building by foreign key";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
        return buildings;
    }

    @Override
    public Class getPersistentClass() {
        return building.getClass();
    }
}
