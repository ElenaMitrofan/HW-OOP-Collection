import Transport.Drivers.Category;
import Transport.Drivers.CategoryB;
import Transport.Drivers.CategoryC;
import Transport.Drivers.CategoryD;
import Transport.Drivers.Driver;
import Transport.Bus;
import Transport.Car;
import Transport.Truck;
import Transport.Transport;
import Transport.Mechanic;
import Transport.Sponsor;
import Transport.ServiceStation;

import java.util.*;

public class Main {
    private static final List<String> NAMES = List.of(
            "Иванов Иван",
            "Петров Петр",
            "Васильев Василий",
            "Александров Александр",
            "Сергеев Сергей",
            "Николаев Николай",
            "Сидорова Марина",
            "Болотникова Ольга",
            "Печатникова Алевтина",
            "Арестанова Ирина"
    );
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE=5;

    public static void main(String[] args) {
        Car bmw = new Car("BMW", "Z8", 3.2, false);
//        System.out.println(bmw);
//        bmw.pitStop();
//        bmw.bestLapTime();
//        bmw.maxSpeed();
//        bmw.service();
        Driver<Car, CategoryB> ivan = new Driver<Car, CategoryB>("Иван Ианович Иванов", true, 3, new CategoryB());
//        ivan.participatesInTheRace(bmw);
        Mechanic<Car, CategoryB> petr = new Mechanic<Car, CategoryB>("Петрович", "Pirelli", new CategoryB(), new Car());
        Sponsor lukoil = new Sponsor("Лукойл", 2000_000);
        ivan.participatesInTheRace(bmw);

        bmw.addDriver(ivan);
        bmw.addMechanic(petr);
        bmw.addSponsor(lukoil);


        Truck gazelle = new Truck("ГАЗель", "Next", 2.9, true);
        System.out.println(gazelle);
        gazelle.pitStop();
        gazelle.bestLapTime();
        gazelle.maxSpeed();
        gazelle.service();
        Driver<Truck, CategoryC> misha = new Driver<Truck, CategoryC>("Михайлов Михаил Михайлович", true, 4, new CategoryC());
        misha.participatesInTheRace(gazelle);
        System.out.println();

        Bus zis = new Bus("ЗИС", "154", 4.5);
        System.out.println(zis);
        zis.pitStop();
        zis.bestLapTime();
        zis.maxSpeed();
        zis.service();
        Driver<Bus, CategoryC> alex = new Driver<Bus, CategoryC>("Александров Александр Александрович", true, 5, new CategoryC());
        alex.participatesInTheRace(zis);
        System.out.println();

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(bmw);
        serviceStation.addTruck(gazelle);
        serviceStation.service();
        serviceStation.service();

        List<Transport> transports = List.of(bmw, gazelle, zis);
        for (Transport transport : transports) {
            printInfo(transport);
        }

        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        randomFilling(queue1);
        randomFilling(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();
        add("владимир Петров", queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();
        remove(queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();


    }

    private static void add(String name,
                            Queue<String> queue1,
                            Queue<String> queue2){
        if (queue1.size()==MAX_SIZE && queue2.size()==MAX_SIZE){
            System.out.println("Нужно позвать Галю!");
            return;
        }
        if (queue1.size()<queue2.size()){
            queue1.offer(name);
        }else{
            queue2.offer(name);
        }

    }
    private static void remove(Queue<String> queue1,
                            Queue<String> queue2){
        if (RANDOM.nextBoolean()){
            queue1.poll();
        }else {
            queue2.poll();
        }

    }

    private static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю: " + transport.getBrand() + transport.getModel());
        System.out.println("водители: " + transport.getDrivers());
        System.out.println("спонсоры: " + transport.getSponsors());
        System.out.println("механики: " + transport.getMechanics());

    }


    private static void randomFilling(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE+1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }

}
