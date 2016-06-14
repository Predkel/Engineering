package by.pvt.predkel.dao;

import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.factory.MyEntityObjectFactory;

/**
 * Created by Admin on 02.06.2016.
 */
public class FlammableSubstanceDaoImpl extends DaoGeneral<FlammableSubstance> {
    private FlammableSubstance substance = new MyEntityObjectFactory().createFlammableSubstance();

    @Override
    public Class getPersistentClass() {
        return substance.getClass();
    }
}
