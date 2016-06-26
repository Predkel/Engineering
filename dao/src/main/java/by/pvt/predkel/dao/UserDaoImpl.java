package by.pvt.predkel.dao;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.factory.MyEntityObjectFactory;
import by.pvt.predkel.settings.ColumnName;
import by.pvt.predkel.settings.HibernateUtil;
import by.pvt.predkel.utils.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Admin on 29.05.2016.
 */
public class UserDaoImpl extends DaoGeneral<User> {
    private String message;
    private User user = new MyEntityObjectFactory().createUser();
    private Session session;

    public User isAuthorized(String login, String password) throws DaoException {
        Session session;
        User user;
        try {
            session = HibernateUtil.currentSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq(ColumnName.USER_LOGIN, login));
            userCriteria.add(Restrictions.eq(ColumnName.USER_PASSWORD, password));
            user = (User) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to authorize user";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return user;
    }

    public User getByLogin(String login) throws DaoException {
        Session session;
        User user;
        try {
            session = HibernateUtil.currentSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq(ColumnName.USER_LOGIN, login));
            user = (User) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to get user by login";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return user;
    }

    @Override
    public Class getPersistentClass() {
        return user.getClass();
    }
}
