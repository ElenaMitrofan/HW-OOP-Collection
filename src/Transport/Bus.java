package Transport;

public class Bus extends Transport implements Competing {
    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }
    public Bus() {
        this ("default",
                "default",
                1.1);
    }
    public void startMoving(){
        return;
    }
    public void finishMoving(){
        return;
    }
    @Override
    public String toString() {
        return "Автобус: " + getBrand()+
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
    public boolean service(){
        System.out.println("Автобус " + getBrand() + " " +getModel() + " в диагностике не требуется");
        return true;
    }
    @Override
    public void fixTheCar() {
        System.out.printf("Мфшина %s починена", getModel());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
