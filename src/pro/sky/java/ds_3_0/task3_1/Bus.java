package pro.sky.java.ds_3_0.task3_1;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Bus extends Transport implements Competing {

    private Capacity capacity;

    public Bus(String brand, String model, float engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }


    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getBestLapTime() {
        return ThreadLocalRandom.current().nextInt(500, 600);
    }

    @Override
    public int getMaxSpeed() {
        return ThreadLocalRandom.current().nextInt(180, 200);
    }


    @Override
    public void startMoving() {
        System.out.printf("Автобус %s %s поехал\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Автобус %s %s остановился\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void printType() {
        if (capacity != null) {
            System.out.println(capacity);
        } else {
            System.out.println("Данных по автобусу недостаточно");
        }
    }

    @Override
    public boolean passDiagnostics() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " в диагностике не нуждается");
        return true;
    }

    @Override
    public void repair() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + "отремонтирован");
    }


    @Override
    public void pitStop() {
        System.out.printf("Автобус %s %s совершил Пит-стоп\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return capacity == bus.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }

    @Override
    public String toString() {
        return "\nBus{" +
                "transport=" + super.toString() +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
