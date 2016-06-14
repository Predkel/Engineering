package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.dao.BuildingDaoImpl;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;

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
        //return BuildingDao.getInstance().isCreated(build).get(0);
        return new BuildingDaoImpl().isCreated(building);
    }

    public List<Building> getAllByFk(Long userId) throws DaoException {
        //return BuildingDao.getInstance().isCreated(build).get(0);
        return new BuildingDaoImpl().geAllByFk(userId);
    }

    public Building readBuilding(Long id) throws DaoException {
        //return BuildingDao.getInstance().read(id);
        return new BuildingDaoImpl().getById(id);
    }

    public void deleteBuilding(Building building) throws DaoException {
        //BuildingDao.getInstance().delete(building);
        new BuildingDaoImpl().delete(building);
    }

    public boolean addBuilding(Building building) throws DaoException {
        GregorianCalendar time = new GregorianCalendar();
        String buildingTime = (time.get(time.HOUR_OF_DAY) + ":" + time.get(time.MINUTE) + " " + time.get(time.DATE) + "-" + (time.get(time.MONTH) + 1) + "-" + time.get(time.YEAR));

        //List<Building> list = BuildingDao.getInstance().isCreated(building);
        BuildingDaoImpl dao = new BuildingDaoImpl();
        Building build = dao.isCreated(building);
        if (//list.size() > 0
                build != null || building.getId() != 0) {
            building.setId(//list.get(0).getId()
                    build.getId());
            building.setDateOfBuilding("изм. " + buildingTime);
            //BuildingDao.getInstance().update(building);
            dao.update(building);
            return false;
        } else {
            building.setDateOfBuilding("созд. " + buildingTime);
            dao.create(building);
            //BuildingDao.getInstance().create(building);
            return true;
        }

    }
}
