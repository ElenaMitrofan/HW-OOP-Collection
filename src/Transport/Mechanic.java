package Transport;

import Transport.Drivers.Category;
import Transport.Drivers.CategoryB;
import Transport.Drivers.CategoryC;
import Transport.Drivers.CategoryD;
import Transport.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Mechanic <T extends Transport, C extends Category> {
    private final String name;
    private final String company;
    private List<Transport> carType = new ArrayList<>();
    private final Category category;

    public Mechanic(String name, String company, C category, T car) {

        if (name == null || name == "") {
            this.name = "default";
        } else {
            this.name = name;
        }
        if (company == null || company == "") {
            this.company = "default";
        } else {
            this.company = company;
        }
        if (category == null) {
            throw new IllegalArgumentException("Необходимо указать категорию прав!");
        } else {
            this.category = category;
        }
        if ((car instanceof Car && category instanceof CategoryB)
                || (car instanceof Truck && category instanceof CategoryC)
                || (car instanceof Bus && category instanceof CategoryD)) {
            this.carType = carType;
        } else {
            throw new IllegalArgumentException("Механик не может принять участие");
        }
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public List<Transport> getCarType() {
        return carType;
    }

    public void setCarType(List<Transport> carType) {
        this.carType = carType;
    }

    public Category getCategory() {
        return category;
    }



    public boolean  service(T t){
       return t.service();
    }
    public void fixTheCar(T t){
        t.fixTheCar();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?, ?> mechanic = (Mechanic<?, ?>) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(company, mechanic.company) && Objects.equals(carType, mechanic.carType) && Objects.equals(category, mechanic.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, carType, category);
    }

    @Override
    public String toString() {
        return "Mechanic: " + name +
                ", компания: " + company +
                ", категория автомобиля: " + category;
    }
}
