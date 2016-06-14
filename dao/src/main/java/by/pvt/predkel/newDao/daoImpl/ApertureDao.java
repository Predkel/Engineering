package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.Aperture;
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

public class ApertureDao extends Dao implements InterfaceDao<Aperture> {
    private static ApertureDao instance;
    static String message;

    private ApertureDao() {
    }

    public static synchronized ApertureDao getInstance() {
        if (instance == null) {
            instance = new ApertureDao();
        }
        return instance;
    }

    @Override
    public Aperture read(int id) throws DaoException {
        Aperture aperture = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_APERTURE_BY_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                aperture = buildAperture(result);
            }
        } catch (SQLException e) {
            message = "Unable to return the user ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return aperture;
    }

    @Override
    public void create(Aperture entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.CREATE_APERTURE);
            statement.setString(1, entity.getTypeOfAperture());
            statement.setDouble(2, entity.getHeight());
            statement.setDouble(3, entity.getWidth());
            statement.setDouble(4, entity.getSquareOfAperture());
            statement.setDouble(5, entity.getCount());
            statement.setLong(6, entity.getRoomId());
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
    public void update(Aperture entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.UPDATE_APERTURE);
            statement.setString(1, entity.getTypeOfAperture());
            statement.setDouble(2, entity.getHeight());
            statement.setDouble(3, entity.getWidth());
            statement.setDouble(4, entity.getSquareOfAperture());
            statement.setDouble(5, entity.getCount());
            statement.setLong(6, entity.getRoomId());
            statement.setLong(7, entity.getId());
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
    public void delete(Aperture entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_APERTURE);
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
    public List<Aperture> getAll() throws DaoException {
        List<Aperture> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_APERTURES);
            result = statement.executeQuery();
            while (result.next()) {
                Aperture aperture = buildAperture(result);
                list.add(aperture);
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

    public List<Aperture> getAllByFkId(int fkId) throws DaoException {
        List<Aperture> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_APERTURE_BY_FK_ROOM);
            statement.setInt(1, fkId);
            result = statement.executeQuery();
            while (result.next()) {
                Aperture aperture = buildAperture(result);
                list.add(aperture);
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

    private Aperture buildAperture(ResultSet result) throws SQLException {
        Aperture aperture = new MyEntityObjectFactory().createAperture();
        aperture.setId(result.getLong(ColumnName.APERTURE_ID));
        aperture.setTypeOfAperture(result.getString(ColumnName.APERTURE_TYPE_OF_APERTURE));
        aperture.setHeight(result.getDouble(ColumnName.APERTURE_HEIGHT));
        aperture.setWidth(result.getInt(ColumnName.APERTURE_WIDTH));
        aperture.setSquareOfAperture(result.getDouble(ColumnName.APERTURE_SQUARE));
        aperture.setCount(result.getShort(ColumnName.APERTURE_COUNT));
        aperture.setRoomId(result.getInt(ColumnName.APERTURE_FKID));
        return aperture;
    }
}


