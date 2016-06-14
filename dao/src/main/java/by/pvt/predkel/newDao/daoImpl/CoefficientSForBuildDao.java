//package by.pvt.predkel.newDao.daoImpl;
//
//
//import by.pvt.predkel.exceptions.DaoException;
//import by.pvt.predkel.factory.MyEntityObjectFactory;
//import by.pvt.predkel.newDao.Dao;
//import by.pvt.predkel.newDao.InterfaceDao;
//import by.pvt.predkel.settings.ColumnName;
//import by.pvt.predkel.settings.PoolManager;
//import by.pvt.predkel.settings.SqlRequests;
//import by.pvt.predkel.utils.ClosingUtil;
//import by.pvt.predkel.utils.PaymentSystemLogger;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CoefficientSForBuildDao extends Dao implements InterfaceDao<CoefficientSForBuild> {
//    private static CoefficientSForBuildDao instance;
//    static String message;
//
//    private CoefficientSForBuildDao() {
//    }
//
//    public static synchronized CoefficientSForBuildDao getInstance() {
//        if (instance == null) {
//            instance = new CoefficientSForBuildDao();
//        }
//        return instance;
//    }
//
//    @Override
//    public CoefficientSForBuild read(int id) throws DaoException {
//        CoefficientSForBuild coefficients = null;
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.GET_CoefficientSForBuild_BY_ID);
//            statement.setInt(1, id);
//            result = statement.executeQuery();
//            while (result.next()) {
//                coefficients = buildCoefficients(result);
//            }
//        } catch (SQLException e) {
//            message = "Unable to return the user ";
//            PaymentSystemLogger.getInstance().logError(getClass(), message);
//            throw new DaoException(message, e);
//        } finally {
//            ClosingUtil.close(result);
//            ClosingUtil.close(statement);
//        }
//        return coefficients;
//    }
//
//    @Override
//    public void create(CoefficientSForBuild entity) throws DaoException {
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.CREATE_CoefficientSForBuild);
//            statement.setInt(1, entity.getBuildingId());
//            statement.setDouble(2, entity.getS().get(0));
//            statement.setDouble(3, entity.getS().get(1));
//            statement.setDouble(4, entity.getS().get(2));
//            statement.setDouble(5, entity.getS().get(3));
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            message = "Unable to add the building ";
//            PaymentSystemLogger.getInstance().logError(getClass(), message);
//            throw new DaoException(message, e);
//        } finally {
//            ClosingUtil.close(statement);
//        }
//    }
//
//    @Override
//    public void update(CoefficientSForBuild entity) throws DaoException {
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.UPDATE_CoefficientSForBuild);
//            statement.setInt(1, entity.getBuildingId());
//            statement.setDouble(2, entity.getS().get(0));
//            statement.setDouble(3, entity.getS().get(1));
//            statement.setDouble(4, entity.getS().get(2));
//            statement.setDouble(5, entity.getS().get(3));
//            statement.setDouble(6, entity.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            message = "Unable to update the building ";
//            PaymentSystemLogger.getInstance().logError(getClass(), message);
//            throw new DaoException(message, e);
//        } finally {
//            ClosingUtil.close(statement);
//        }
//    }
//
//    @Override
//    public void delete(CoefficientSForBuild entity) throws DaoException {
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.DELETE_CoefficientSForBuild);
//            statement.setLong(1, entity.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            message = "Unable to delete the building ";
//            PaymentSystemLogger.getInstance().logError(getClass(), message);
//            throw new DaoException(message, e);
//        } finally {
//            ClosingUtil.close(statement);
//        }
//    }
//
//    @Override
//    public List<CoefficientSForBuild> getAll() throws DaoException {
//        List<CoefficientSForBuild> list = new ArrayList<>();
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.GET_CoefficientSForBuild);
//            result = statement.executeQuery();
//            while (result.next()) {
//                CoefficientSForBuild building = buildCoefficients(result);
//                list.add(building);
//            }
//        } catch (SQLException e) {
//            message = "Unable to return list of users ";
//            PaymentSystemLogger.getInstance().logError(getClass(), message);
//            throw new DaoException(message, e);
//        } finally {
//            ClosingUtil.close(result);
//            ClosingUtil.close(statement);
//        }
//        return list;
//    }
//
//    public List<CoefficientSForBuild> getAllByFkId(int fkId) throws DaoException {
//        List<CoefficientSForBuild> list = new ArrayList<>();
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.GET_CoefficientSForBuild_BY_FK_BUILDING);
//            statement.setInt(1, fkId);
//            result = statement.executeQuery();
//            while (result.next()) {
//                CoefficientSForBuild building = buildCoefficients(result);
//                list.add(building);
//            }
//        } catch (SQLException e) {
//            message = "Unable to return list of users ";
//            PaymentSystemLogger.getInstance().logError(getClass(), message);
//            throw new DaoException(message, e);
//        } finally {
//            ClosingUtil.close(result);
//            ClosingUtil.close(statement);
//        }
//        return list;
//    }
//
//    private CoefficientSForBuild buildCoefficients(ResultSet result) throws SQLException {
//        CoefficientSForBuild coefficients = new MyEntityObjectFactory().createCoefficientSForBuild();
//        coefficients.setBuildingId(result.getShort(ColumnName.COEFFICIENTS_FOR_BUILDING_FKID));
//        coefficients.setId(result.getLong(ColumnName.COEFFICIENTS_FOR_BUILDING_ID));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_BUILDING_S2));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_BUILDING_S3));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_BUILDING_S5));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_BUILDING_S6));
//        return coefficients;
//    }
//}
