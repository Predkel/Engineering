package by.pvt.predkel.dao;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.factory.MyEntityObjectFactory;
import by.pvt.predkel.settings.HibernateUtil;
import by.pvt.predkel.utils.PaymentSystemLogger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Admin on 29.05.2016.
 */
public class UserDaoImpl extends DaoGeneral<User> {
    private String message;
    private User user = new MyEntityObjectFactory().createUser();

    public User isAuthorized(String login, String password) throws DaoException {
        Session session = null;
//        boolean isLogIn = false;
        User user = new MyEntityObjectFactory().createUser();
        try {
            session = HibernateUtil.currentSession();
//            Query query=session.createQuery("from User where login=:login and password=:password");
//            query.setParameter("login",login);
//            query.setParameter("password",password);
//            List t = query.list();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("login", login));
            userCriteria.add(Restrictions.eq("password", password));
            user = (User) userCriteria.uniqueResult();
            //  if (t.size()>0)
        } catch (Exception e) {
            message = "Unable to authorize user";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
        return user;
    }

    public User getByLogin(String login) throws DaoException {
        Session session = null;
        User user = new MyEntityObjectFactory().createUser();
        try {
            session = HibernateUtil.currentSession();
//            Query query=session.createQuery("from User where login=:login");
//            query.setParameter("login",login);
//            List t = query.list();
//            user=(User)t.get(0);
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("login", login));
            user = (User) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to get user by login";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }
        return user;
    }

    @Override
    public Class getPersistentClass() {
        return user.getClass();
    }
}
