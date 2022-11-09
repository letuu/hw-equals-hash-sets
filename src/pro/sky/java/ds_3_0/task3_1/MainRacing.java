package pro.sky.java.ds_3_0.task3_1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainRacing {
    public static void main(String[] args) {

        Sponsor gazprom = new Sponsor("Газпром", 10_000_000);
        Sponsor tinkoff = new Sponsor("Олег Тиньков", 5_000_000);
        Mechanic<Transport> pirogov = new Mechanic<Transport>("Михаил", "Пирогов", "AutoRem");

        Car audi = new Car("Audi", "A6", 2.3f, BodyType.COUPE);
        Car audiDouble = new Car("Audi", "A6", 2.3f, BodyType.COUPE);
        Car bmw = new Car("BMW", "X3", 1.6f, BodyType.CROSSOVER);
        Car kia = new Car("Kia", "Spectra", 1.8f, BodyType.SEDAN);
        Car opel = new Car("Opel", "Astra", 1.3f, BodyType.HATCHBACK);
        Car car = new Car(null, null, 0f, null);
        DriverB ivanov = new DriverB("Иванов Олег", 5, opel);
        Mechanic<Car> popov = new Mechanic<Car>("Сергей", "Попов", "AutoRemCar1");
        Mechanic<Car> sergeev = new Mechanic<Car>("Антон", "Сергеев", "AutoRemCar2");

//        ivanov.setCategory("C");

        audi.addDriver(ivanov);
        audi.addMechanic(popov, sergeev);
        audi.addSponsor(tinkoff);
        audiDouble.addDriver(ivanov);
        audiDouble.addMechanic(popov, sergeev);
//        audiDouble.addSponsor(tinkoff); //если добавить этого спонсора, то получится полный дубль audi и исключение

        Truck volvo = new Truck("Volvo", "655", 3.2f, LoadCapacity.N1);
        Truck maz = new Truck("MAZ", "64684", 3.0f, LoadCapacity.N2);
        Truck kamaz = new Truck("Kamaz", "3553", 3.4f, LoadCapacity.N3);
        Truck iveco = new Truck("Iveco", "V985", 3.6f, LoadCapacity.N2);
        DriverC leonov = new DriverC("Леонов Михаил", 4, kamaz);
        Mechanic<Truck> nosov = new Mechanic<Truck>("Алексей", "Носов", "AutoRemTruck");

//        leonov.setCategory("D");

        volvo.addDriver(leonov);
        volvo.addDriver(ivanov); //добавление второго водителя невозможно - сообщение в консоли
        volvo.addMechanic(nosov);
        volvo.addSponsor(gazprom);

        Bus paz = new Bus("PAZ", "09840", 2.8f, Capacity.SMALL);
        Bus liaz = new Bus("Liaz", "896t5", 3.5f, Capacity.MEDIUM);
        Bus ikarus = new Bus("Ikarus", "8955t", 3.3f, Capacity.LARGE);
        Bus gaz = new Bus("GAZ", "78738", 2.4f, Capacity.EXTRA_SMALL);
        DriverD petrov = new DriverD("Петров Юрий", 6, ikarus);
        Mechanic<Bus> titov = new Mechanic<Bus>("Александр", "Титов", "AutoRemBus");

//        petrov.setCategory("B");        //валидно

        paz.addDriver(petrov);
        paz.addMechanic(titov);
        paz.addSponsor(gazprom, tinkoff);


        // Проверка задачи 3-1 Множества ****************************************************
//        List<Transport> transports = List.of(audi, volvo, paz);
        Set<Transport> transports = Set.of(audi, volvo, paz, audiDouble);
//        Set<Car> cars = Set.of(audi, bmw, kia, audiDouble);
        Set<Car> cars = new HashSet<>();
        cars.add(audi);
        cars.add(bmw);
        cars.add(kia);
        cars.add(audiDouble); //отличается только спонсором
        cars.add(bmw); //дубль - код отрабатывает, в множество не добавляется и в консоль не выводится
        Set<Driver<?>> drivers = Set.of(ivanov, leonov, petrov);
        Set<Mechanic<Car>> mechanics = Set.of(popov, sergeev);
        Set<Sponsor> sponsors = Set.of(gazprom, tinkoff);
//        Set<Sponsor> sponsors = Set.of(gazprom, tinkoff, tinkoff);  //исключение - дубликат


        for (Transport transport : transports) {
            printInfoAuto(transport);
        }

        System.out.println("Транспорт:");
        System.out.println(transports);
        System.out.println("\nЛегковые автомобили:");
        System.out.println(cars);
        System.out.println("\nВодители:");
        System.out.println(drivers);
        System.out.println("\nМеханики:");
        System.out.println(mechanics);
        System.out.println("\nСпонсоры:");
        System.out.println(sponsors);
        System.out.println();


//        petrov.setCategory(null);       //невалидно - null
//        petrov.setCategory("");         //невалидно - isEmpty
//        petrov.setCategory(" ");        //невалидно - !contains в "BCD"
//        petrov.setCategory("D ");       //невалидно - !contains в "BCD"
//        petrov.setCategory("dsfkuhr");  //невалидно - !contains в "BCD"
//        System.out.println("Водитель " + petrov.getFullName() + " имеет права категории " + petrov.getCategory());
//        System.out.println();

        diagnostics(
                audi, bmw, kia, opel, car,
                volvo, maz, kamaz, iveco,
                paz, liaz, ikarus, gaz
        );

        System.out.println();

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCarQueue(audi);
        serviceStation.addCarQueue(bmw);
        serviceStation.addCarQueue(kia);
        serviceStation.addTruckQueue(maz);
        serviceStation.addTruckQueue(kamaz);
        serviceStation.addTruckQueue(iveco);
        serviceStation.doAutoService();
        serviceStation.doAutoService();
        serviceStation.doAutoService();
        serviceStation.doAutoService();
        serviceStation.doAutoService();
        serviceStation.doAutoService();


//        audi.printType();
//        opel.printType();
//        car.printType();
//
//        volvo.printType();
//        maz.printType();
//        kamaz.printType();
//
//        paz.printType();
//        liaz.printType();
//        ikarus.printType();
//        System.out.println();
//
//
//        System.out.println(audi);
//        System.out.println(bmw);
//        System.out.println(kia);
//        System.out.println(opel);
////        audi.startMoving();
////        opel.stopMoving();
//        System.out.println();
//
//        System.out.println(volvo);
//        System.out.println(maz);
//        System.out.println(kamaz);
//        System.out.println(iveco);
////        maz.startMoving();
////        iveco.stopMoving();
//        System.out.println();
//
//        System.out.println(paz);
//        System.out.println(liaz);
//        System.out.println(ikarus);
//        System.out.println(gaz);
////        liaz.startMoving();
////        ikarus.stopMoving();
//        System.out.println();
//
//
//        System.out.println(ivanov);
//        System.out.println(leonov);
//        System.out.println(petrov);
    }

    //Все машины проверяет на диагностику
    private static void diagnostics(Transport... transports) {
        for (Transport transport : transports) {
            diagnosticsTransport(transport);
        }
    }

    //Проверка на диагностику каждой отдельной машины (в try обвернуто if и throw, можно только throw)
    private static void diagnosticsTransport(Transport transport) {
        try {
            if (!transport.passDiagnostics()) {
                throw new RuntimeException("Авто " + transport.getBrand() + " " + transport.getModel() + " диагностику не прошел");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printInfoAuto(Transport transport) {
        System.out.println("Информация по автомобилю " + transport.getBrand() + " " + transport.getModel() + ":");
        System.out.println("Водители: " + transport.getDrivers());
        System.out.println("Механики: " + transport.getMechanics());
        System.out.println("Спонсоры: " + transport.getSponsors());
        System.out.println();
    }
}
