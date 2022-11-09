package pro.sky.java.ds_3_0.task3_1;

import java.util.Objects;

public class Truck extends Transport implements Competing {

    private LoadCapacity loadCapacity;

    public Truck(String brand, String model, float engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
    }


    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public int getBestLapTime() {
        return 646;
    }

    @Override
    public int getMaxSpeed() {
        return 205;
    }


    @Override
    public void startMoving() {
        System.out.printf("Грузовая машина %s %s поехала\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Грузовая машина %s %s остановилась\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void printType() {
        if (loadCapacity != null) {
            System.out.println("Тип грузоподъемности грузовика: " + loadCapacity);
        } else {
            System.out.println("Данных по грузовому авто недостаточно");
        }
    }

    @Override
    public boolean passDiagnostics() {
        return Math.random() > 0.3;
    }

    @Override
    public void repair() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " отремонтирован");
    }


    @Override
    public void pitStop() {
        System.out.printf("Грузовая машина %s %s совершила Пит-стоп\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return loadCapacity == truck.loadCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity);
    }

    @Override
    public String toString() {
        return "\nTruck{" +
                "transport=" + super.toString() +
                ", loadCapacity='" + loadCapacity + '\'' +
                '}';
    }
}
