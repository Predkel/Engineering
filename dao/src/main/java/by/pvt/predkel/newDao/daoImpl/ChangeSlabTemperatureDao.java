package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.temperatureSettings.ChangeInTemperatureOfSlab;
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

public class ChangeSlabTemperatureDao extends Dao implements InterfaceDao<ChangeInTemperatureOfSlab> {
    private static ChangeSlabTemperatureDao instance;
    static String message;

    private ChangeSlabTemperatureDao() {
    }

    public static synchronized ChangeSlabTemperatureDao getInstance() {
        if (instance == null) {
            instance = new ChangeSlabTemperatureDao();
        }
        return instance;
    }

    @Override
    public ChangeInTemperatureOfSlab read(int id) throws DaoException {
        ChangeInTemperatureOfSlab temperature = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeSlabT_BY_ID);
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
    public void create(ChangeInTemperatureOfSlab entity) throws DaoException {
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
                    "INSERT INTO `changeInTemperatureOfSlab` (`fk.id.room`" + sb + ") " +
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
    public void update(ChangeInTemperatureOfSlab entity) throws DaoException {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < entity.getChanges().size(); i++) {
                StringBuilder sb1 = new StringBuilder(", `changes" + i + "`='" + entity.getChanges().get(i) + "'");
                sb.append(sb1);
            }
            String sql = "UPDATE `changeInTemperatureOfSlab` SET `fk.id.room`='" + entity.getRoomId() + "' " + sb + " " +
                    "WHERE `id.changeInTemperatureOfSlab`='" + entity.getId() + "';";

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
    public void delete(ChangeInTemperatureOfSlab entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_ChangeSlabT);
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
    public List<ChangeInTemperatureOfSlab> getAll() throws DaoException {
        List<ChangeInTemperatureOfSlab> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeSlabT);
            result = statement.executeQuery();
            while (result.next()) {
                ChangeInTemperatureOfSlab temperature = buildTemperature(result);
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

    public List<ChangeInTemperatureOfSlab> getAllByFkId(int fkId) throws DaoException {
        List<ChangeInTemperatureOfSlab> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeSlabT_BY_FK_ROOM);
            statement.setInt(1, fkId);
            result = statement.executeQuery();
            while (result.next()) {
                ChangeInTemperatureOfSlab temperature = buildTemperature(result);
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

    private ChangeInTemperatureOfSlab buildTemperature(ResultSet result) throws SQLException {
        ChangeInTemperatureOfSlab temperature = new MyEntityObjectFactory().createChangeInTemperatureOfSlab();
        temperature.setId(result.getLong(ColumnName.ChangeInTemperatureOfSlab_ID));
        temperature.setRoomId(result.getShort(ColumnName.ChangeInTemperatureOfSlab_FK_ID_ROOM));
        for (int i = 0; i < 121; i++) {
            temperature.getChanges().add(result.getDouble(ColumnName.ChangeInTemperatureOfSlab_FIELD + i));
        }
        return temperature;
    }
}