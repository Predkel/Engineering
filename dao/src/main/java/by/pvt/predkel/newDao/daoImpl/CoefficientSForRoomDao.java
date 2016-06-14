//package by.pvt.predkel.newDao.daoImpl;
//
//import by.pvt.predkel.entities.CoefficientSForRoom;
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
//public class CoefficientSForRoomDao extends Dao implements InterfaceDao<CoefficientSForRoom> {
//    private static CoefficientSForRoomDao instance;
//    static String message;
//
//    private CoefficientSForRoomDao() {
//    }
//
//    public static synchronized CoefficientSForRoomDao getInstance() {
//        if (instance == null) {
//            instance = new CoefficientSForRoomDao();
//        }
//        return instance;
//    }
//
//    @Override
//    public CoefficientSForRoom read(int id) throws DaoException {
//        CoefficientSForRoom coefficients = null;
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.GET_CoefficientSForRoom_BY_ID);
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
//    public void create(CoefficientSForRoom entity) throws DaoException {
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.CREATE_CoefficientSForRoom);
//            statement.setInt(1, entity.getRoomId());
//            statement.setDouble(2, entity.getS().get(0));
//            statement.setDouble(3, entity.getS().get(1));
//            statement.setDouble(4, entity.getS().get(2));
//            statement.setDouble(5, entity.getS().get(3));
//            statement.setDouble(6, entity.getS().get(4));
//            statement.setDouble(7, entity.getS().get(5));
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
//    public void update(CoefficientSForRoom entity) throws DaoException {
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.UPDATE_CoefficientSForRoom);
//            statement.setInt(1, entity.getRoomId());
//            statement.setDouble(2, entity.getS().get(0));
//            statement.setDouble(3, entity.getS().get(1));
//            statement.setDouble(4, entity.getS().get(2));
//            statement.setDouble(5, entity.getS().get(3));
//            statement.setDouble(6, entity.getS().get(4));
//            statement.setDouble(7, entity.getS().get(5));
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
//    public void delete(CoefficientSForRoom entity) throws DaoException {
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.DELETE_CoefficientSForRoom);
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
//    public List<CoefficientSForRoom> getAll() throws DaoException {
//        List<CoefficientSForRoom> list = new ArrayList<>();
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.GET_CoefficientSForRoom);
//            result = statement.executeQuery();
//            while (result.next()) {
//                CoefficientSForRoom room = buildCoefficients(result);
//                list.add(room);
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
//    public List<CoefficientSForRoom> getAllByFkId(int fkId) throws DaoException {
//        List<CoefficientSForRoom> list = new ArrayList<>();
//        try {
//            connection = PoolManager.getInstance().getConnection();
//            statement = connection.prepareStatement(SqlRequests.GET_CoefficientSForRoom_BY_FK_BUILDING);
//            statement.setInt(1, fkId);
//            result = statement.executeQuery();
//            while (result.next()) {
//                CoefficientSForRoom room = buildCoefficients(result);
//                list.add(room);
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
//    private CoefficientSForRoom buildCoefficients(ResultSet result) throws SQLException {
//        CoefficientSForRoom coefficients = new MyEntityObjectFactory().createCoefficientSForRoom();
//        coefficients.setRoomId(result.getShort(ColumnName.COEFFICIENTS_FOR_ROOM_FKID));
//        coefficients.setId(result.getLong(ColumnName.COEFFICIENTS_FOR_ROOM_ID));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_ROOM_S1));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_ROOM_S4));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_ROOM_S7));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_ROOM_S8));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_ROOM_S9));
//        coefficients.getS().add(result.getDouble(ColumnName.COEFFICIENTS_FOR_ROOM_S10));
//        return coefficients;
//    }
//}


