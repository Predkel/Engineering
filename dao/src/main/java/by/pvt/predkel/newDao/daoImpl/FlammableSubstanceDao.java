package by.pvt.predkel.newDao.daoImpl;

import by.pvt.predkel.entities.FlammableSubstance;
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

public class FlammableSubstanceDao extends Dao implements InterfaceDao<FlammableSubstance> {
    private static FlammableSubstanceDao instance;
    static String message;

    private FlammableSubstanceDao() {
    }

    public static synchronized FlammableSubstanceDao getInstance() {
        if (instance == null) {
            instance = new FlammableSubstanceDao();
        }
        return instance;
    }

    @Override
    public FlammableSubstance read(int id) throws DaoException {
        FlammableSubstance substance = null;
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_FLAMMABLE_SUBSTANCE_BY_ID);
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
    public void create(FlammableSubstance entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.CREATE_FlammableSubstance);
            statement.setString(1, entity.getNameOfSubstance());
            statement.setDouble(2, entity.getAmountOfCombustionAir());
            statement.setDouble(3, entity.getAverageSpeedBurnout());
            statement.setDouble(4, entity.getCombustionHeat());
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
    public void update(FlammableSubstance entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.UPDATE_FlammableSubstance);
            statement.setString(1, entity.getNameOfSubstance());
            statement.setDouble(2, entity.getAmountOfCombustionAir());
            statement.setDouble(3, entity.getAverageSpeedBurnout());
            statement.setDouble(4, entity.getCombustionHeat());
            statement.setLong(5, entity.getId());
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
    public void delete(FlammableSubstance entity) throws DaoException {
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.DELETE_FlammableSubstance);
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
    public List<FlammableSubstance> getAll() throws DaoException {
        List<FlammableSubstance> list = new ArrayList<>();
        try {
            connection = PoolManager.getInstance().getConnection();
            statement = connection.prepareStatement(SqlRequests.GET_FlammableSubstance);
            result = statement.executeQuery();
            while (result.next()) {
                FlammableSubstance substance = buildSubstance(result);
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


    private FlammableSubstance buildSubstance(ResultSet result) throws SQLException {
        FlammableSubstance substance = new MyEntityObjectFactory().createFlammableSubstance();
        substance.setId(result.getLong(ColumnName.FLAMMABLE_SUBSTANCE_ID));
        substance.setAmountOfCombustionAir(result.getDouble(ColumnName.FLAMMABLE_SUBSTANCE_AMOUNT_OF_Combustion_Air));
        substance.setAverageSpeedBurnout(result.getDouble(ColumnName.FLAMMABLE_SUBSTANCE_Average_Speed_Burnout));
        substance.setCombustionHeat(result.getInt(ColumnName.FLAMMABLE_SUBSTANCE_Combustion_Heat));
        substance.setNameOfSubstance(result.getString(ColumnName.FLAMMABLE_SUBSTANCE_NAME));
        return substance;
    }
}
