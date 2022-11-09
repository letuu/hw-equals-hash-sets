package pro.sky.java.ds_3_0.task3_1;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Transport implements Competing {

    private BodyType bodyType;

    public Car(String brand, String model, float engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }


    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public int getBestLapTime() {
        return ThreadLocalRandom.current().nextInt(900, 1000);
    }

    @Override
    public int getMaxSpeed() {
        return ThreadLocalRandom.current().nextInt(300, 370);
    }


    @Override
    public void startMoving() {
        System.out.printf("Легковая машина %s %s поехала\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Легковая машина %s %s остановилась\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println(bodyType);
        } else {
            System.out.println("Данных по авто недостаточно");
        }
    }

    @Override
    public boolean passDiagnostics() {
        return Math.random() > 0.4;
    }

    @Override
    public void repair() {
        System.out.println("Машина " + getBrand() + " " + getModel() + " отремонтирована");
    }


    @Override
    public void pitStop() {
        System.out.printf("Легковая машина %s %s совершила Пит-стоп\n",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return bodyType == car.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "transport=" + super.toString() +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
