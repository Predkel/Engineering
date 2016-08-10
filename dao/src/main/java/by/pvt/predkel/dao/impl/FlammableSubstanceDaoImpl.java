package by.pvt.predkel.dao.impl;

import by.pvt.predkel.dao.DaoGeneral;
import by.pvt.predkel.dao.IFlammableSubstanceDao;
import by.pvt.predkel.entities.FlammableSubstance;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 02.06.2016.
 */
@Repository
public class FlammableSubstanceDaoImpl extends DaoGeneral<FlammableSubstance> implements IFlammableSubstanceDao {
    private FlammableSubstance substance = new FlammableSubstance();

    @Autowired
    public FlammableSubstanceDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class getPersistentClass() {
        return substance.getClass();
    }

}
