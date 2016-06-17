package by.pvt.predkel.settings;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
//    public static final ThreadLocal session = new ThreadLocal();

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new RuntimeException("Configuration problem: " + ex.getMessage(), ex);
        }
    }

    public static Session currentSession() throws HibernateException {
//        Session s = (Session) session.get();
//        if (s == null) {
//            s = sessionFactory.getCurrentSession();
//            session.set(s);
//        }
//        return s;
        return sessionFactory.getCurrentSession();
    }

//    public static void closeSession() throws HibernateException {
//        Session s = (Session) session.get();
//        session.set(null);
//        if (s != null)
//            s.close();
//    }
}
