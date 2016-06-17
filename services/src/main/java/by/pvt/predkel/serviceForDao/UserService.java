package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.dao.UserDaoImpl;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.settings.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        UserDaoImpl dao = new UserDaoImpl();
        if (dao.getByLogin(user.getLogin()) == null) {
            dao.create(user);
            tx.commit();
            return true;
        } else
            return false;
    }

    public boolean deleteUser(String login) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.getByLogin(login);
        if (user != null) {
            dao.delete(user);
            tx.commit();
            return true;
        } else
            return false;
    }

    public User loginUser(String login, String password) throws DaoException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        User user = new UserDaoImpl().isAuthorized(login, password);
        tx.commit();
        return user;
    }
}
