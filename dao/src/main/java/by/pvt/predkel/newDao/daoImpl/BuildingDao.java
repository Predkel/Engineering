package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.factory.MyEntityObjectFactory;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.newDao.Dao;
import by.pvt.predkel.newDao.InterfaceDao;
import by.pvt.predkel.settings.ColumnName;
import by.pvt.predkel.settings.PoolManager;
import by.pvt.predkel.settings.SqlRequests;
import by.pvt.predkel.utils.ClosingUtil;
import by.pvt.predkel.utils.PaymentSystemLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingDao extends Dao implements InterfaceDao<Building> {
    private static BuildingDao instance;
    static String message;

    private BuildingDao() {
    }

    public static synchronized BuildingDao getInstance() {
        if (instance == null) {
            instance = new BuildingDao();
        }
        return instance;
    }

    @Override
    public Building read(int id) throws DaoException {
        Building building = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_BUILDING_BY_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                building = buildBuilding(result);
            }
        } catch (SQLException e) {
            message = "Unable to return the user ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return building;
    }

    @Override
    public void create(Building entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.CREATE_BUILDING);
            statement.setLong(1, entity.getUserId());
            statement.setString(2, entity.getNameOfBuilding());
            statement.setDouble(3, entity.getSelectedTemperatureOfRegion());
            statement.setDouble(4, entity.getSpecifyingCoefficientS5());
            statement.setString(5, entity.getDateOfBuilding());
            statement.executeUpdate();
        } catch (SQLException e) {
            message = "Unable to add the building ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    @Override
    public void update(Building entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.UPDATE_BUILDING);
            statement.setLong(1, entity.getUserId());
            statement.setString(2, entity.getNameOfBuilding());
            statement.setDouble(3, entity.getSelectedTemperatureOfRegion());
            statement.setDouble(4, entity.getSpecifyingCoefficientS5());
            statement.setString(5, entity.getDateOfBuilding());
            statement.setLong(6, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            message = "Unable to update the building ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    @Override
    public void delete(Building entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_BUILDING);
            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            message = "Unable to delete the building ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    @Override
    public List<Building> getAll() throws DaoException {
        List<Building> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_BUILDINGS);
            result = statement.executeQuery();
            while (result.next()) {
                Building building = buildBuilding(result);
                list.add(building);
            }
        } catch (SQLException e) {
            message = "Unable to return list of users ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return list;
    }

    public List<Building> getAllByFkId(long fkId) throws DaoException {
        List<Building> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_BUILDING_BY_FK_USER);
            statement.setLong(1, fkId);
            result = statement.executeQuery();
            while (result.next()) {
                Building building = buildBuilding(result);
                list.add(building);
            }
        } catch (SQLException e) {
            message = "Unable to return list of users ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return list;
    }

    public List<Building> isCreated(Building entity) throws DaoException {
        List<Building> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.BUILDING_CREATED_EARLY);
            statement.setString(1, entity.getNameOfBuilding());
            statement.setLong(2, entity.getUserId());
            result = statement.executeQuery();
            while (result.next()) {
                Building building = buildBuilding(result);
                list.add(building);
            }
        } catch (SQLException e) {
            message = "Unable to return list of users ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return list;
    }

    private Building buildBuilding(ResultSet result) throws SQLException {
        Building building = new MyEntityObjectFactory().createBuilding();
        building.setNameOfBuilding(result.getString(ColumnName.BUILDING_NAME));
        building.setSelectedTemperatureOfRegion(result.getDouble(ColumnName.BUILDING_TEMPERATURE));
        building.setDateOfBuilding(result.getString(ColumnName.BUILDING_DATE));
        building.setUserId(result.getShort(ColumnName.BUILDING_FK_ID_USER));
        building.setId(result.getLong(ColumnName.BUILDING_ID));
        building.setSpecifyingCoefficientS5(result.getDouble(ColumnName.BUILDING_COEFFICIENT_C5));
        return building;
    }
}