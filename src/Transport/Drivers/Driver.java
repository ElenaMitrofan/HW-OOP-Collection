package Transport.Drivers;

import Transport.*;

import java.util.Objects;

public class Driver<T extends Transport, C extends Category> {
    protected final String fio;
    protected final boolean HavingALicense;
    protected final int experience;

    private final Category category;

    public Driver(String fio, boolean havingALicense, int experience, C category) {
        if (fio == null || fio == "") {
            this.fio = "default";
        } else {
            this.fio = fio;
        }
        HavingALicense = havingALicense;

        if (experience <= 0) {
            this.experience = 3;
        } else {
            this.experience = experience;
        }
        if (category == null) {
            throw new IllegalArgumentException("Необходимо указать категорию прав!");
        } else {
            this.category = category;
        }
    }
    public void participatesInTheRace(T car) {
        if ((car instanceof Car && category instanceof CategoryB)
                || (car instanceof Truck && category instanceof CategoryC)
                || (car instanceof Bus && category instanceof CategoryD)) {
            System.out.println("водитель [" + getFio() + "] управляет автомобилем [" + car.getBrand() + "] и будет участвовать в заезде");
        } else {
            System.out.println("Водитель не может принять участие");
        }
    }
    public String getFio() {
        return fio;
    }

    public boolean isHavingALicense() {
        return HavingALicense;
    }

    public int getExperience() {
        return experience;
    }

    public void startMoving() {

    }

    public void finishMoving() {

    }

    public void refuel() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?, ?> driver = (Driver<?, ?>) o;
        return HavingALicense == driver.HavingALicense && experience == driver.experience && Objects.equals(fio, driver.fio) && Objects.equals(category, driver.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, HavingALicense, experience, category);
    }

    @Override
    public String toString() {
        return "водитель: " + fio +
                ", опыт вождения: " + experience + "л. " +
                ", категория прав: " + category;
    }
}

