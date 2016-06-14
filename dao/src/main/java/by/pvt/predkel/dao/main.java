package by.pvt.predkel.dao;

import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;

/**
 * Created by Admin on 14.06.2016.
 */
public class main {
    public static void main(String[] args) throws DaoException {
        User user=new User();
        user.setPassword("guevara333");
        user.setRole(1);
        user.setLogin("henk");
        User user1=new User();
        user1.setLogin("Admin");
        user1.setPassword("8827");
        user1.setRole(1);
        UserDaoImpl dao=new UserDaoImpl();
        dao.create(user);
        dao.create(user1);

        FlammableSubstance substance=new FlammableSubstance();
        substance.setNameOfSubstance("Текстильные изделия");
        substance.setAmountOfCombustionAir(2.12);
        substance.setCombustionHeat(16);
        substance.setAverageSpeedBurnout(1.44);

        FlammableSubstance substance1=new FlammableSubstance();
        substance1.setNameOfSubstance("Древесина");
        substance1.setAmountOfCombustionAir(4.2);
        substance1.setCombustionHeat(13);
        substance1.setAverageSpeedBurnout(2.4);

        FlammableSubstance substance2=new FlammableSubstance();
        substance2.setNameOfSubstance("Изоляция проводов, кабелей ПВХ");
        substance2.setAmountOfCombustionAir(13.05);
        substance2.setCombustionHeat(33);
        substance2.setAverageSpeedBurnout(3.73);

        FlammableSubstance substance3=new FlammableSubstance();
        substance3.setNameOfSubstance("Масло");
        substance3.setAmountOfCombustionAir(10.5);
        substance3.setCombustionHeat(42);
        substance3.setAverageSpeedBurnout(2.1);

        FlammableSubstance substance4=new FlammableSubstance();
        substance4.setNameOfSubstance("Пластмасса (Полиэтилен)");
        substance4.setAmountOfCombustionAir(11.42);
        substance4.setCombustionHeat(47);
        substance4.setAverageSpeedBurnout(0.62);

        FlammableSubstance substance5=new FlammableSubstance();
        substance5.setNameOfSubstance("РТИ");
        substance5.setAmountOfCombustionAir(13.18);
        substance5.setCombustionHeat(33);
        substance5.setAverageSpeedBurnout(0.9);

        FlammableSubstanceDaoImpl dao1=new FlammableSubstanceDaoImpl();
        dao1.create(substance);
        dao1.create(substance1);
        dao1.create(substance2);
        dao1.create(substance3);
        dao1.create(substance4);
        dao1.create(substance5);
    }
}
