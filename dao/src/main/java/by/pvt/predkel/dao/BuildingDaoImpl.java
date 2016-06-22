package by.pvt.predkel.dao;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.factory.MyEntityObjectFactory;
import by.pvt.predkel.settings.ColumnName;
import by.pvt.predkel.settings.HibernateUtil;
import by.pvt.predkel.utils.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
        Session session;
        try {
            session = HibernateUtil.currentSession();
            User user = (User) session.load(User.class, building.getUserId());
            building.setUser(user);
            session.delete(building);
        } catch (Exception e) {
            message = "Unable to update building";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public void update(Building building) throws DaoException {
        Session session;
        try {
            session = HibernateUtil.currentSession();
            User user = (User) session.load(User.class, building.getUserId());
            building.setUser(user);
            session.merge(building);
        } catch (Exception e) {
            message = "Unable to update building";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public void create(Building building) throws DaoException {
        Session session;
        try {
            session = HibernateUtil.currentSession();//напрямую нельзя добавить здание
            //т.к. оно зависит от юзера
            User user = (User) session.load(User.class, building.getUserId());//поэтому достаем (прокси) юзера
            user.getBuilding().add(building);// добавляем ему здание
            session.update(user);// и сохраняем юзера
        } catch (Exception e) {
            message = "Unable to save building";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    public Building isCreated(Building entity) throws DaoException {
        Session session;
        Building building;
        try {
            session = HibernateUtil.currentSession();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            userCriteria.add(Restrictions.eq(ColumnName.BUILDING_FK_ID_USER, entity.getUserId()));
            userCriteria.add(Restrictions.eq(ColumnName.BUILDING_NAME, entity.getNameOfBuilding()));
            building = (Building) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to get building by name and foreign key";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return building;
    }

    public List<Building> geAllByFk(Long userId) throws DaoException {
        Session session;
        List<Building> buildings;
        try {
            session = HibernateUtil.currentSession();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            userCriteria.add(Restrictions.eq(ColumnName.BUILDING_FK_ID_USER, userId));
            buildings = (List<Building>) userCriteria.list();
        } catch (Exception e) {
            message = "Unable to get building by foreign key";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return buildings;
    }

    @Override
    public Class getPersistentClass() {
        return building.getClass();
    }
}
