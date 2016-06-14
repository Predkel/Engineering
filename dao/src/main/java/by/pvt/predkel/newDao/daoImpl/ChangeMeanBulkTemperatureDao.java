package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.temperatureSettings.ChangeInMeanBulkTemperature;
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

public class ChangeMeanBulkTemperatureDao extends Dao implements InterfaceDao<ChangeInMeanBulkTemperature> {
    private static ChangeMeanBulkTemperatureDao instance;
    static String message;

    private ChangeMeanBulkTemperatureDao() {
    }

    public static synchronized ChangeMeanBulkTemperatureDao getInstance() {
        if (instance == null) {
            instance = new ChangeMeanBulkTemperatureDao();
        }
        return instance;
    }

    @Override
    public ChangeInMeanBulkTemperature read(int id) throws DaoException {
        ChangeInMeanBulkTemperature temperature = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeMeanBulkT_BY_ID);
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
    public void create(ChangeInMeanBulkTemperature entity) throws DaoException {
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
                    "INSERT INTO changeinmeanbulktemperature (`fk.id.room`" + sb + ") " +
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
    public void update(ChangeInMeanBulkTemperature entity) throws DaoException {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < entity.getChanges().size(); i++) {
                StringBuilder sb1 = new StringBuilder(", `changes" + i + "`='" + entity.getChanges().get(i) + "'");
                sb.append(sb1);
            }
            String sql = "UPDATE `changeinmeanbulktemperature` SET `fk.id.room`='" + entity.getRoomId() + "'" + sb + " " +
                    "WHERE `id.changeinmeanbulktemperature`='" + entity.getId() + "';";

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
    public void delete(ChangeInMeanBulkTemperature entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_ChangeMeanBulkT);
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
    public List<ChangeInMeanBulkTemperature> getAll() throws DaoException {
        List<ChangeInMeanBulkTemperature> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeMeanBulkT);
            result = statement.executeQuery();
            while (result.next()) {
                ChangeInMeanBulkTemperature temperature = buildTemperature(result);
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

    public List<ChangeInMeanBulkTemperature> getAllByFkId(int fkId) throws DaoException {
        List<ChangeInMeanBulkTemperature> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_ChangeMeanBulkT_BY_FK_ROOM);
            statement.setInt(1, fkId);
            result = statement.executeQuery();
            while (result.next()) {
                ChangeInMeanBulkTemperature temperature = buildTemperature(result);
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

    private ChangeInMeanBulkTemperature buildTemperature(ResultSet result) throws SQLException {
        ChangeInMeanBulkTemperature temperature = new MyEntityObjectFactory().createChangeInMeanBulkTemperature();
        temperature.setId(result.getLong(ColumnName.ChangeInMeanBulkTemperature_ID));
        temperature.setRoomId(result.getShort(ColumnName.ChangeInMeanBulkTemperature_FK_ID_ROOM));
        for (int i = 0; i < 121; i++) {
            temperature.getChanges().add(result.getDouble(ColumnName.ChangeInMeanBulkTemperature_FIELD + i));
        }
        return temperature;
    }
}

