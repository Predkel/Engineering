package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.temperatureSettings.ChangeInTemperatureOfWalls;
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

public class ChangeWallsTemperatureDao extends Dao implements InterfaceDao<ChangeInTemperatureOfWalls> {
    private static ChangeWallsTemperatureDao instance;
    static String message;

    private ChangeWallsTemperatureDao() {
    }

    public static synchronized ChangeWallsTemperatureDao getInstance() {
        if (instance == null) {
            instance = new ChangeWallsTemperatureDao();
        }
        return instance;
    }

    @Override
    public ChangeInTemperatureOfWalls read(int id) throws DaoException {
        ChangeInTemperatureOfWalls temperature = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeWallsT_BY_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                temperature = buildTemperature(result);
            }
        } catch (SQLException e) {
            message = "Unable to return the user ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return temperature;
    }

    @Override
    public void create(ChangeInTemperatureOfWalls entity) throws DaoException {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < entity.getChanges().size(); i++) {
                StringBuilder sb1 = new StringBuilder(",`changes" + i + "`");
                sb.append(sb1);
            }
            StringBuilder sb1 = new StringBuilder();
            for (Double temp : entity.getChanges()) {
                StringBuilder sb2 = new StringBuilder(",'" + temp + "'");
                sb1.append(sb2);
            }
            String sql =
                    "INSERT INTO `changeInTemperatureOfWalls` (`fk.id.room`" + sb + ") " +
                            "VALUES ('" + entity.getRoomId() + "'" + sb1 + ");";

            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            message = "Unable to add the user account ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    @Override
    public void update(ChangeInTemperatureOfWalls entity) throws DaoException {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < entity.getChanges().size(); i++) {
                StringBuilder sb1 = new StringBuilder(", `changes" + i + "`='" + entity.getChanges().get(i) + "'");
                sb.append(sb1);
            }
            String sql = "UPDATE `changeInTemperatureOfWalls` SET `fk.id.room`=" + entity.getRoomId() + "" + sb + " " +
                    "WHERE `id.changeInTemperatureOfWalls`='" + entity.getId() + "';";

            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            message = "Unable to update the user ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    @Override
    public void delete(ChangeInTemperatureOfWalls entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_ChangeWallsT);
            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            message = "Unable to delete the user ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(statement);
        }
    }

    @Override
    public List<ChangeInTemperatureOfWalls> getAll() throws DaoException {
        List<ChangeInTemperatureOfWalls> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeWallsT);
            result = statement.executeQuery();
            while (result.next()) {
                ChangeInTemperatureOfWalls temperature = buildTemperature(result);
                list.add(temperature);
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

    public List<ChangeInTemperatureOfWalls> getAllByFkId(int fkId) throws DaoException {
        List<ChangeInTemperatureOfWalls> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeWallsT_BY_FK_ROOM);
            statement.setInt(1, fkId);
            result = statement.executeQuery();
            while (result.next()) {
                ChangeInTemperatureOfWalls temperature = buildTemperature(result);
                list.add(temperature);
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

    private ChangeInTemperatureOfWalls buildTemperature(ResultSet result) throws SQLException {
        ChangeInTemperatureOfWalls temperature = new MyEntityObjectFactory().createChangeInTemperatureOfWalls();
        temperature.setId(result.getLong(ColumnName.ChangeInTemperatureOfWalls_ID));
        temperature.setRoomId(result.getShort(ColumnName.ChangeInTemperatureOfWalls_FK_ID_ROOM));
        for (int i = 0; i < 121; i++) {
            temperature.getChanges().add(result.getDouble(ColumnName.ChangeInTemperatureOfWalls_FIELD + i));
        }
        return temperature;
    }
}