package Transport;

import Transport.Drivers.Driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Transport {
    protected final String brand;
    protected final String model;
    protected final double engineVolume;
    private final Set<Driver> drivers = new HashSet<>();
    private final Set <Mechanic> mechanics = new HashSet<>();
    private final Set <Sponsor> sponsors = new HashSet<>();

    public Transport(String brand, String model, double engineVolume) {

        if (brand == null || brand == "") {
            this.brand = "default";
        }else{
            this.brand = brand;
        }
        if (model == null || model == "") {
            this.model = "default";
        }else{
            this.model = model;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 1.1;
        }else{
            this.engineVolume = engineVolume;
        }

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void addDriver(Driver driver){
        drivers.add(driver);
    }
    public void addMechanic(Mechanic mechanic){
        mechanics.add(mechanic);
    }
    public void addSponsor(Sponsor sponsor){
        sponsors.add(sponsor);
    }

    public abstract void startMoving();
    public abstract void finishMoving();
    public abstract boolean service();
    public abstract void fixTheCar();

}
