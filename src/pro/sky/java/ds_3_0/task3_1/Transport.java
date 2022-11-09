package pro.sky.java.ds_3_0.task3_1;

import java.util.*;

public abstract class Transport {

    private final String brand;
    private final String model;
    private final float engineVolume;
    private final Set<Driver<?>> drivers = new HashSet<>();
    private final Set<Mechanic<?>> mechanics = new HashSet<>();
    private final Set<Sponsor> sponsors = new HashSet<>();

    protected Transport(String brand, String model, float engineVolume) {
        this.brand = brand;
        this.model = model;
        this.engineVolume = engineVolume;
    }

    public void addDriver(Driver<?> driver) {
        if (drivers.size() > 0) {
            System.out.println("У автомобиля " + getBrand() + " " + getModel() +
                    " уже есть водитель, добавление водителя " + driver.getFullName() + " невозможно!\n");
        } else {
            drivers.add(driver);
        }
    }

    public void addMechanic(Mechanic<?>... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public abstract void startMoving();
    public abstract void stopMoving();
    public abstract void printType();

    public abstract boolean passDiagnostics();
    public abstract void repair();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public Set<Driver<?>> getDrivers() {
        return drivers;
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Float.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) && Objects.equals(drivers, transport.drivers) && Objects.equals(mechanics, transport.mechanics) && Objects.equals(sponsors, transport.sponsors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, drivers, mechanics, sponsors);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
}
