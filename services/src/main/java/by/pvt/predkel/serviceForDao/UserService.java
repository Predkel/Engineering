package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.dao.UserDaoImpl;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;

/**
 * Created by Admin on 13.05.2016.
 */
public class UserService {
    private static UserService instance;

    private UserService() {
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean registerUser(User user) throws DaoException {
        UserDaoImpl dao = new UserDaoImpl();
        if (//UserDao.getInstance().getByLogin(user.getLogin()) == null
                dao.getByLogin(user.getLogin()) == null) {
            //UserDao.getInstance().create(user);
            dao.create(user);
            return true;
        } else
            return false;
    }

    public boolean deleteUser(String login) throws DaoException {
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.getByLogin(login);
        // User user = UserDao.getInstance().getByLogin(login);
        if (user != null) {
            dao.delete(user);
            //UserDao.getInstance().delete(user);
            return true;
        } else
            return false;
    }

    public User loginUser(String login, String password) throws DaoException {
        return new UserDaoImpl().isAuthorized(login, password);

//        if (UserDao.getInstance().isAuthorized(login, password)) {
//            return UserDao.getInstance().getByLogin(login);
//        } else
//            return null;
    }
}
