package by.pvt.predkel.serviceForDao.test;

import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.exceptions.ServiceException;

import java.util.ArrayList;

/**
 * Created by Admin on 14.06.2016.
 */
public class main {


    public static void main(String[] args) throws DaoException, ServiceException {
////        User user = new User();
////        user.setPassword("guevara333");
////        user.setRole(1);
////        user.setLogin("henk");
////        User user1 = new User();
////        user1.setLogin("Admin");
////        user1.setPassword("8827");
////        user1.setRole(1);
////        UserService.getInstance().registerUser(user);
////        UserService.getInstance().registerUser(user1);
////
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:services-context.xml");
////        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//        IFlammableSubstanceService flammableSubstanceService = (IFlammableSubstanceService) context.getBean("flammableSubstanceService");
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
//        flammableSubstanceService.createSubstance(substance);
//        flammableSubstanceService.createSubstance(substance1);
//        flammableSubstanceService.createSubstance(substance2);
//        flammableSubstanceService.createSubstance(substance3);
//        flammableSubstanceService.createSubstance(substance4);
//        flammableSubstanceService.createSubstance(substance5);
//
//        flammableSubstanceService.createSubstance(substance6);
//        flammableSubstanceService.createSubstance(substance7);
//        flammableSubstanceService.createSubstance(substance8);
//        flammableSubstanceService.createSubstance(substance9);
//        flammableSubstanceService.createSubstance(substance10);
//        flammableSubstanceService.createSubstance(substance11);
//        flammableSubstanceService.createSubstance(substance12);
//        flammableSubstanceService.createSubstance(substance13);
//        flammableSubstanceService.createSubstance(substance14);
//        flammableSubstanceService.createSubstance(substance15);
//        flammableSubstanceService.createSubstance(substance16);
//
////        double t = 15 / 10;
////        System.out.print(Math.ceil((double) 11 / 10));
////        List<Integer> first = new ArrayList<>();
////        first.add(1);
////        first.add(2);
////        first.add(3);
////        first.add(4);
////        List<Integer> second = first.subList(0, 2);
////        System.out.print(second);
////        try {
////
//////            User user = UserService.getInstance().loginUser("Admin", "8827");
////
//////            System.out.print(user.getLogin());
////        } catch (DaoException e) {
////            e.printStackTrace();
////        }
//
////        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:services-context.xml");
////        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//        User user = new User();
//        user.setLogin("henk");
//        user.setPassword("guevara333");
//        user.setAccessLevelType(AccessLevelType.SUPER_ADMIN);
//
//        IUserService userService = (IUserService) context.getBean("userService");
//        userService.save(user);
//
//
////        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:services-context.xml");
////        IBuildingService buildingService= (IBuildingService) context.getBean("buildingService");
////        Building building=buildingService.getById((long)1);
////        String name=building.getNameOfBuilding();
////        System.out.print(name);
//        1
//        Integer a=new Integer(2);
//        Integer b = new Integer(2);
//
//        System.out.println(a.intValue()==b.intValue());
//        System.out.println(a.compareTo(b));
//        System.out.println(a.equals(b));
//        System.out.println(a==b);

        //3
//        Building b1=new Building();
//        Building b2=new Warehouse();
//
//        try {
//            Warehouse w1=b2;Warehouse w3 = new SportShop();
//        }catch (ClassCastException e){
//            System.out.print("no");
//        }
//
//        Warehouse w2=(Warehouse) b2;
//
//        Shop s1=(Shop) b1;
//        Shop s2=new SportShop();

        //4
//        Building building=new Building();
//        int v=2;
//        building.shift(v,5);
//        System.out.print(v);

        //5
//        Set product=new HashSet<>();
//        product.add(new SportShop("Hat",3));
//        product.add(new SportShop("Hat",3));
//        System.out.println(product);
//
//         6
//        List list= new ArrayList<>();
//        list.add("i1");
//        list.add("i2");
//
//        final List im= list;
//        im.add("1");

        //7
        Building building = new Building();


        ArrayList product = new ArrayList<>();
        product.add("1");
        product.add("3");
        product.add("5");
        product.add("7");
        product.add("9");

        ArrayList product1 = new ArrayList<>();
        product1.add("2");
        product1.add("4");
        product1.add("6");
        product1.add("8");
        product1.add("10");

        building.merge(product, product1);

        System.out.println(product);
    }
}
