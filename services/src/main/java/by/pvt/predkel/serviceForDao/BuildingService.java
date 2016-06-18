package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.dao.BuildingDaoImpl;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.settings.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Admin on 14.05.2016.
 */
public class BuildingService {
    private static BuildingService instance;

    private BuildingService() {
    }

    public static synchronized BuildingService getInstance() {
        if (instance == null) {
            instance = new BuildingService();
        }
        return instance;
    }

    public Building getBuildingByFkAndName(Building building) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        Building newBuilding = new BuildingDaoImpl().isCreated(building);
        tx.commit();
        return newBuilding;
    }

    public List<Building> getAllByFk(Long userId) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List<Building> list = new BuildingDaoImpl().geAllByFk(userId);
        tx.commit();
        return list;
    }

    public Building readBuilding(Long id) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        Building building = new BuildingDaoImpl().getById(id);
        tx.commit();
        return building;
    }

    public void deleteBuilding(Building building) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        new BuildingDaoImpl().delete(building);
        tx.commit();
    }

    public boolean addBuilding(Building building) throws DaoException {
        GregorianCalendar time = new GregorianCalendar();
        String buildingTime = (time.get(time.HOUR_OF_DAY) + ":" + time.get(time.MINUTE) + " " + time.get(time.DATE) + "-" + (time.get(time.MONTH) + 1) + "-" + time.get(time.YEAR));
        Boolean checker;

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        BuildingDaoImpl dao = new BuildingDaoImpl();
        Building build = dao.isCreated(building);

        if (building.getId() != 0) {
            building.setDateOfBuilding("изм. " + buildingTime);
            dao.update(building);
            checker = false;
        } else if (build != null) {
            building.setId(build.getId());
            building.setDateOfBuilding("изм. " + buildingTime);
            dao.update(building);
            checker = false;
        } else {
            building.setDateOfBuilding("созд. " + buildingTime);
            dao.create(building);
            checker = true;
        }
        tx.commit();

        return checker;
    }
}
