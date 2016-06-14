package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.SubstanceOfRoom;
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

public class SubstancesOfRoomDao extends Dao implements InterfaceDao<SubstanceOfRoom> {
    private static SubstancesOfRoomDao instance;
    static String message;

    private SubstancesOfRoomDao() {
    }

    public static synchronized SubstancesOfRoomDao getInstance() {
        if (instance == null) {
            instance = new SubstancesOfRoomDao();
        }
        return instance;
    }

    @Override
    public SubstanceOfRoom read(int id) throws DaoException {
        SubstanceOfRoom substance = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_SubstancesOfRoom_BY_ID);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                substance = buildSubstance(result);
            }
        } catch (SQLException e) {
            message = "Unable to return the user ";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            ClosingUtil.close(result);
            ClosingUtil.close(statement);
        }
        return substance;
    }

    @Override
    public void create(SubstanceOfRoom entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.CREATE_SubstancesOfRoom);
            statement.setLong(1, entity.getRoomId());
//            statement.setInt(2, entity.getSubstanceId());
            statement.setDouble(3, entity.getWeight());
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
    public void update(SubstanceOfRoom entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.UPDATE_SubstancesOfRoom);
            statement.setLong(1, entity.getRoomId());
//            statement.setInt(2, entity.getSubstanceId());
            statement.setDouble(3, entity.getWeight());
            statement.setLong(4, entity.getId());
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
    public void delete(SubstanceOfRoom entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_SubstancesOfRoom);
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
    public List<SubstanceOfRoom> getAll() throws DaoException {
        List<SubstanceOfRoom> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_SubstancesOfRoom);
            result = statement.executeQuery();
            while (result.next()) {
                SubstanceOfRoom substance = buildSubstance(result);
                list.add(substance);
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

    public List<SubstanceOfRoom> getAllByFkId(int fkId) throws DaoException {
        List<SubstanceOfRoom> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_SubstancesOfRoom_BY_FK_ROOM);
            statement.setInt(1, fkId);
            result = statement.executeQuery();
            while (result.next()) {
                SubstanceOfRoom aperture = buildSubstance(result);
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

    private SubstanceOfRoom buildSubstance(ResultSet result) throws SQLException {
        SubstanceOfRoom substances = new MyEntityObjectFactory().createSubstanceOfRoom();
        substances.setId(result.getLong(ColumnName.SUBSTANCES_OF_ROOM_ID));
        substances.setWeight(result.getDouble(ColumnName.SUBSTANCES_OF_ROOM_WEIGHT));
        substances.setRoomId(result.getInt(ColumnName.SUBSTANCES_OF_ROOM_FK_ID_ROOM));
//        substances.setSubstanceId(result.getInt(ColumnName.SUBSTANCES_OF_ROOM_FK_ID_SUBSTANCE));
        return substances;
    }
}
