package by.pvt.predkel.dao;

import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.factory.MyEntityObjectFactory;
import by.pvt.predkel.settings.HibernateUtil;
import by.pvt.predkel.utils.PaymentSystemLogger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by Admin on 02.06.2016.
 */
public class FlammableSubstanceDaoImpl extends DaoGeneral<FlammableSubstance> {
    private FlammableSubstance substance = new MyEntityObjectFactory().createFlammableSubstance();
    private String message;

    @Override
    public Class getPersistentClass() {
        return substance.getClass();
    }

    public List<FlammableSubstance> pagination(int firstResult, int maxResult) throws DaoException {
        List<FlammableSubstance> list;
        Session session = null;
        try {
            session = HibernateUtil.currentSession();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            list = (List<FlammableSubstance>) userCriteria.setFirstResult(firstResult).setMaxResults(maxResult).list();
        } catch (Exception e) {
            message = "Unable to get flammable substances";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.closeSession();
            }
        }

        return list;
    }

    public Long getCount() throws DaoException {
        Session session;
        try {
            session = HibernateUtil.currentSession();
            return (Long) session.createCriteria(getPersistentClass())
                    .setProjection(Projections.rowCount())
                    .list()
                    .get(0);
        } catch (Exception e) {
            message = "Unable to get row count of flammable substances";
            PaymentSystemLogger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }
}
