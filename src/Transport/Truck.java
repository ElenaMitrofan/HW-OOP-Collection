package Transport;

import java.util.Objects;

public class Truck extends Transport implements Competing {
    private final boolean service;
    public Truck(String brand, String model, double engineVolume, boolean service) {
        super(brand, model, engineVolume);
        this.service = service;
    }
    public Truck() {
        this ("default",
                "default",
                1.1, false);
    }

    public void startMoving(){
        return;
    }
    public void finishMoving(){
        return;
    }
    @Override
    public String toString() {
        return "Грузовой автомобиль: " + getBrand()+
                ", модель: " + getModel()+
                ", объём двигателя: " + getEngineVolume();
    }

    @Override
    public void pitStop() {
        System.out.printf("Автомобиль заезжает на обслуживание %s %s.\n", getBrand(), getModel());
        System.out.printf("Автомобиль %s %s прошел обслуживание, выезжает на трассу.\n", getBrand(), getModel());

    }

    @Override
    public void bestLapTime() {
        System.out.printf("Лучшее время автомобиля %s %s составляет: %.0f мин.\n", getBrand(), getModel(), (1+Math.random() * (5)));
    }

    @Override
    public void maxSpeed() {
        System.out.printf("Максимальная скорость автомобиля %s %s составила: %.1f км/ч.\n", getBrand(), getModel(), (100+Math.random() * (200)));
    }
    @Override
    public boolean service() {
        return false;
    }
    @Override
    public void fixTheCar() {
        System.out.printf("Мфшина %s починена", getBrand());
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return service == truck.service;
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }
}

