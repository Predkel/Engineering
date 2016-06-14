package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.Room;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.factory.MyEntityObjectFactory;
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

public class RoomDao extends Dao implements InterfaceDao<Room> {
    private static RoomDao instance;
    static String message;

    private RoomDao() {
    }

    public static synchronized RoomDao getInstance() {
        if (instance == null) {
            instance = new RoomDao();
        }
        return instance;
    }

    @Override
    public Room read(int id) throws DaoException {
        Room room = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ROOM_BY_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                room = buildRoom(result);
            }
        } catch (SQLException e) {
            message = "Unable to return the user ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return room;
    }

    @Override
    public void create(Room entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.CREATE_ROOM);

            statement.setString(1, entity.getCommonParameters().getPositionOfRoom());
            statement.setString(2, entity.getCommonParameters().getNameOfRoom());
            statement.setDouble(3, entity.getCommonParameters().getSquare());
            statement.setDouble(4, entity.getCommonParameters().getHeight());
            statement.setDouble(5, entity.getCommonParameters().getPerimeter());
            statement.setDouble(6, entity.getCommonParameters().getSquareOfConstruction());
            statement.setDouble(7, entity.getParametersCalculatedFireLoad().getSpecificFireLoad());
            statement.setDouble(8, entity.getParametersCalculatedFireLoad().getSpecificFireLoadZVEZDOCHKA());
            statement.setDouble(9, entity.getParametersCalculatedFireLoad().getReducedHeightOfApertures());
            statement.setDouble(10, entity.getParametersCalculatedFireLoad().getGeneralSquareOfApertures());
            statement.setDouble(11, entity.getParametersCalculatedFireLoad().getVentilationParameter());
            statement.setDouble(12, entity.getParametersCalculatedFireLoad().getCoefficientK());
            statement.setDouble(13, entity.getParametersCalculatedFireLoad().getCoefficientA());
            statement.setDouble(14, entity.getParametersCalculatedFireLoad().getCoefficientB());
            statement.setDouble(15, entity.getParametersCalculatedFireLoad().getCoefficientS());
            statement.setDouble(16, entity.getParametersCalculatedFireLoad().getEstimatedFireLoad());
            statement.setDouble(17, entity.getDetermineTheTypeOfFire().getProemnostOfRoom());
            statement.setDouble(18, entity.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir());
            statement.setDouble(19, entity.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad());
            statement.setDouble(20, entity.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad());
            statement.setBoolean(21, entity.getDetermineTheTypeOfFire().getPrn());
            statement.setDouble(22, entity.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature());
            statement.setDouble(23, entity.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
            statement.setDouble(24, entity.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature());
            statement.setDouble(25, entity.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface());
            statement.setDouble(26, entity.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface());
            statement.setDouble(27, entity.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab());
            statement.setDouble(28, entity.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface());
            statement.setDouble(29, entity.getBuildingId());
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
    public void update(Room entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.UPDATE_ROOM);

            statement.setString(1, entity.getCommonParameters().getPositionOfRoom());
            statement.setString(2, entity.getCommonParameters().getNameOfRoom());
            statement.setDouble(3, entity.getCommonParameters().getSquare());
            statement.setDouble(4, entity.getCommonParameters().getHeight());
            statement.setDouble(5, entity.getCommonParameters().getPerimeter());
            statement.setDouble(6, entity.getCommonParameters().getSquareOfConstruction());
            statement.setDouble(7, entity.getParametersCalculatedFireLoad().getSpecificFireLoad());
            statement.setDouble(8, entity.getParametersCalculatedFireLoad().getSpecificFireLoadZVEZDOCHKA());
            statement.setDouble(9, entity.getParametersCalculatedFireLoad().getReducedHeightOfApertures());
            statement.setDouble(10, entity.getParametersCalculatedFireLoad().getGeneralSquareOfApertures());
            statement.setDouble(11, entity.getParametersCalculatedFireLoad().getVentilationParameter());
            statement.setDouble(12, entity.getParametersCalculatedFireLoad().getCoefficientK());
            statement.setDouble(13, entity.getParametersCalculatedFireLoad().getCoefficientA());
            statement.setDouble(14, entity.getParametersCalculatedFireLoad().getCoefficientB());
            statement.setDouble(15, entity.getParametersCalculatedFireLoad().getCoefficientS());
            statement.setDouble(16, entity.getParametersCalculatedFireLoad().getEstimatedFireLoad());
            statement.setDouble(17, entity.getDetermineTheTypeOfFire().getProemnostOfRoom());
            statement.setDouble(18, entity.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir());
            statement.setDouble(19, entity.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad());
            statement.setDouble(20, entity.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad());
            statement.setBoolean(21, entity.getDetermineTheTypeOfFire().getPrn());
            statement.setDouble(22, entity.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature());
            statement.setDouble(23, entity.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
            statement.setDouble(24, entity.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature());
            statement.setDouble(25, entity.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface());
            statement.setDouble(26, entity.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface());
            statement.setDouble(27, entity.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab());
            statement.setDouble(28, entity.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface());
            statement.setLong(29, entity.getBuildingId());
            statement.setLong(30, entity.getId());
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
    public void delete(Room entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_ROOM);
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
    public List<Room> getAll() throws DaoException {
        List<Room> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ROOMS);
            result = statement.executeQuery();
            while (result.next()) {
                Room building = buildRoom(result);
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


    public List<Room> getAllByFkId(int fkId) throws DaoException {
        List<Room> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ROOM_BY_FkID_BUILDING);
            statement.setInt(1, fkId);
            result = statement.executeQuery();
            while (result.next()) {
                Room building = buildRoom(result);
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

    private Room buildRoom(ResultSet result) throws SQLException {
        Room room = new MyEntityObjectFactory().createRoom();
        room.setId(result.getLong(ColumnName.ROOM_ID));
        room.getCommonParameters().setPositionOfRoom(result.getString(ColumnName.ROOM_POSITION));
        room.getCommonParameters().setNameOfRoom(result.getString(ColumnName.ROOM_NAME));
        room.getCommonParameters().setSquare(result.getDouble(ColumnName.ROOM_SQUARE));
        room.getCommonParameters().setHeight(result.getDouble(ColumnName.ROOM_HEIGHT));
        room.getCommonParameters().setPerimeter(result.getDouble(ColumnName.ROOM_PERIMETER));
        room.getCommonParameters().setSquareOfConstruction(result.getDouble(ColumnName.ROOM_SquareOfConstruction));
        room.getParametersCalculatedFireLoad().setSpecificFireLoad(result.getDouble(ColumnName.ROOM_SpecificFireLoad));
        room.getParametersCalculatedFireLoad().setSpecificFireLoadZVEZDOCHKA(result.getDouble(ColumnName.ROOM_SpecificFireLoadZVEZDOCHKA));
        room.getParametersCalculatedFireLoad().setReducedHeightOfApertures(result.getDouble(ColumnName.ROOM_ReducedHeightOfApertures));
        room.getParametersCalculatedFireLoad().setGeneralSquareOfApertures(result.getDouble(ColumnName.ROOM_GeneralSquareOfApertures));
        room.getParametersCalculatedFireLoad().setVentilationParameter(result.getDouble(ColumnName.ROOM_VentilationParameter));
        room.getParametersCalculatedFireLoad().setCoefficientK(result.getDouble(ColumnName.ROOM_CoefficientK));
        room.getParametersCalculatedFireLoad().setCoefficientA(result.getDouble(ColumnName.ROOM_CoefficientA));
        room.getParametersCalculatedFireLoad().setCoefficientB(result.getDouble(ColumnName.ROOM_CoefficientB));
        room.getParametersCalculatedFireLoad().setCoefficientS(result.getDouble(ColumnName.ROOM_CoefficientS));
        room.getParametersCalculatedFireLoad().setEstimatedFireLoad(result.getDouble(ColumnName.ROOM_EstimatedFireLoad));
        room.getDetermineTheTypeOfFire().setProemnostOfRoom(result.getDouble(ColumnName.ROOM_ProemnostOfRoom));
        room.getDetermineTheTypeOfFire().setAverageAmountOfCombustionAir(result.getDouble(ColumnName.ROOM_AverageAmountOfCombustionAir));
        room.getDetermineTheTypeOfFire().setSpecificCriticalAmountOfFireLoad(result.getDouble(ColumnName.ROOM_SpecificCriticalAmountOfFireLoad));
        room.getDetermineTheTypeOfFire().setSpecificValueOfFireLoad(result.getDouble(ColumnName.ROOM_SpecificValueOfFireLoad));
        room.getDetermineTheTypeOfFire().setPrn(result.getBoolean(ColumnName.ROOM_PRN));
        room.getIntegratedThermalAndTechnicalParameters().setMaximumMeanBulkTemperature(result.getDouble(ColumnName.ROOM_MaximumMeanBulkTemperature));
        room.getIntegratedThermalAndTechnicalParameters().setDurationOfFireSurround(result.getDouble(ColumnName.ROOM_DurationOfFireSurround));
        room.getIntegratedThermalAndTechnicalParameters().setTimeReachMaximumMeanBulkTemperature(result.getDouble(ColumnName.ROOM_TimeReachMaximumMeanBulkTemperature));
        room.getIntegratedThermalAndTechnicalParameters().setMaximumAverageTemperatureOfWallSurface(result.getDouble(ColumnName.ROOM_MaximumAverageTemperatureOfWallSurface));
        room.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfWallSurface(result.getDouble(ColumnName.ROOM_TimeToReachMaximumTemperatureOfWallSurface));
        room.getIntegratedThermalAndTechnicalParameters().setAverageMaximumTemperatureOfSlab(result.getDouble(ColumnName.ROOM_AverageMaximumTemperatureOfSlab));
        room.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfSlabSurface(result.getDouble(ColumnName.ROOM_TimeToReachMaximumTemperatureOfSlabSurface));
        room.setBuildingId(result.getInt(ColumnName.ROOM_FkIdBuilding));
        return room;
    }
}

