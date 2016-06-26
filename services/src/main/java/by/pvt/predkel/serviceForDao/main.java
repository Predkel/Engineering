package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;

/**
 * Created by Admin on 14.06.2016.
 */
public class main {
    public static void main(String[] args) throws DaoException {
//        User user = new User();
//        user.setPassword("guevara333");
//        user.setRole(1);
//        user.setLogin("henk");
//        User user1 = new User();
//        user1.setLogin("Admin");
//        user1.setPassword("8827");
//        user1.setRole(1);
//        UserService.getInstance().registerUser(user);
//        UserService.getInstance().registerUser(user1);
//
//        FlammableSubstance substance = new FlammableSubstance();
//        substance.setNameOfSubstance("Текстильные изделия");
//        substance.setAmountOfCombustionAir(2.12);
//        substance.setCombustionHeat(16);
//        substance.setAverageSpeedBurnout(1.44);
//
//        FlammableSubstance substance1 = new FlammableSubstance();
//        substance1.setNameOfSubstance("Древесина");
//        substance1.setAmountOfCombustionAir(4.2);
//        substance1.setCombustionHeat(13);
//        substance1.setAverageSpeedBurnout(2.4);
//
//        FlammableSubstance substance2 = new FlammableSubstance();
//        substance2.setNameOfSubstance("Изоляция проводов, кабелей ПВХ");
//        substance2.setAmountOfCombustionAir(13.05);
//        substance2.setCombustionHeat(33);
//        substance2.setAverageSpeedBurnout(3.73);
//
//        FlammableSubstance substance3 = new FlammableSubstance();
//        substance3.setNameOfSubstance("Масло");
//        substance3.setAmountOfCombustionAir(10.5);
//        substance3.setCombustionHeat(42);
//        substance3.setAverageSpeedBurnout(2.1);
//
//        FlammableSubstance substance4 = new FlammableSubstance();
//        substance4.setNameOfSubstance("Пластмасса (Полиэтилен)");
//        substance4.setAmountOfCombustionAir(11.42);
//        substance4.setCombustionHeat(47);
//        substance4.setAverageSpeedBurnout(0.62);
//
//        FlammableSubstance substance5 = new FlammableSubstance();
//        substance5.setNameOfSubstance("РТИ");
//        substance5.setAmountOfCombustionAir(13.18);
//        substance5.setCombustionHeat(33);
//        substance5.setAverageSpeedBurnout(0.9);
//
//        FlammableSubstance substance6 = new FlammableSubstance();
//        substance6.setNameOfSubstance("Хлопок");
//        substance6.setAmountOfCombustionAir(9.72);
//        substance6.setCombustionHeat(16.4);
//        substance6.setAverageSpeedBurnout(1.26);
//
//        FlammableSubstance substance7 = new FlammableSubstance();
//        substance7.setNameOfSubstance("Лен");
//        substance7.setAmountOfCombustionAir(7.73);
//        substance7.setCombustionHeat(15.7);
//        substance7.setAverageSpeedBurnout(1.26);
//
//        FlammableSubstance substance16 = new FlammableSubstance();
//        substance16.setNameOfSubstance("Индустриальное масло");
//        substance16.setAmountOfCombustionAir(6.71);
//        substance16.setCombustionHeat(42.7);
//        substance16.setAverageSpeedBurnout(2.58);
//
//        FlammableSubstance substance8 = new FlammableSubstance();
//        substance8.setNameOfSubstance("Ковролин");
//        substance8.setAmountOfCombustionAir(10.77);
//        substance8.setCombustionHeat(15.4);
//        substance8.setAverageSpeedBurnout(0.78);
//
//        FlammableSubstance substance9 = new FlammableSubstance();
//        substance9.setNameOfSubstance("Каучук СКС");
//        substance9.setAmountOfCombustionAir(10.16);
//        substance9.setCombustionHeat(43.89);
//        substance9.setAverageSpeedBurnout(0.78);
//
//        FlammableSubstance substance10 = new FlammableSubstance();
//        substance10.setNameOfSubstance("Полистирол");
//        substance10.setAmountOfCombustionAir(10.25);
//        substance10.setCombustionHeat(39);
//        substance10.setAverageSpeedBurnout(0.84);
//
//        FlammableSubstance substance11 = new FlammableSubstance();
//        substance11.setNameOfSubstance("Резина");
//        substance11.setAmountOfCombustionAir(12.63);
//        substance11.setCombustionHeat(33.52);
//        substance11.setAverageSpeedBurnout(0.66);
//
//        FlammableSubstance substance12 = new FlammableSubstance();
//        substance12.setNameOfSubstance("Пенополиуретан");
//        substance12.setAmountOfCombustionAir(6);
//        substance12.setCombustionHeat(24.3);
//        substance12.setAverageSpeedBurnout(0.18);
//
//        FlammableSubstance substance13 = new FlammableSubstance();
//        substance13.setNameOfSubstance("Полиэтилен");
//        substance13.setAmountOfCombustionAir(11.42);
//        substance13.setCombustionHeat(47.14);
//        substance13.setAverageSpeedBurnout(0.6);
//
//        FlammableSubstance substance14 = new FlammableSubstance();
//        substance14.setNameOfSubstance("Полипропилен");
//        substance14.setAmountOfCombustionAir(11.42);
//        substance14.setCombustionHeat(45.67);
//        substance14.setAverageSpeedBurnout(0.9);
//
//        FlammableSubstance substance15 = new FlammableSubstance();
//        substance15.setNameOfSubstance("Поливинилхлорид");
//        substance15.setAmountOfCombustionAir(9.25);
//        substance15.setCombustionHeat(20.70);
//        substance15.setAverageSpeedBurnout(1.44);
//
//        FlammableSubstanceService.getInstance().createSubstance(substance);
//        FlammableSubstanceService.getInstance().createSubstance(substance1);
//        FlammableSubstanceService.getInstance().createSubstance(substance2);
//        FlammableSubstanceService.getInstance().createSubstance(substance3);
//        FlammableSubstanceService.getInstance().createSubstance(substance4);
//        FlammableSubstanceService.getInstance().createSubstance(substance5);
//
//        FlammableSubstanceService.getInstance().createSubstance(substance6);
//        FlammableSubstanceService.getInstance().createSubstance(substance7);
//        FlammableSubstanceService.getInstance().createSubstance(substance8);
//        FlammableSubstanceService.getInstance().createSubstance(substance9);
//        FlammableSubstanceService.getInstance().createSubstance(substance10);
//        FlammableSubstanceService.getInstance().createSubstance(substance11);
//        FlammableSubstanceService.getInstance().createSubstance(substance12);
//        FlammableSubstanceService.getInstance().createSubstance(substance13);
//        FlammableSubstanceService.getInstance().createSubstance(substance14);
//        FlammableSubstanceService.getInstance().createSubstance(substance15);
//        FlammableSubstanceService.getInstance().createSubstance(substance16);

//        double t = 15 / 10;
//        System.out.print(Math.ceil((double) 11 / 10));
//        List<Integer> first = new ArrayList<>();
//        first.add(1);
//        first.add(2);
//        first.add(3);
//        first.add(4);
//        List<Integer> second = first.subList(0, 2);
//        System.out.print(second);
        try {

            User user = UserService.getInstance().loginUser("Admin", "8827");

            System.out.print(user.getLogin());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
