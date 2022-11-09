package pro.sky.java.ds_3_0.task3_1;

import java.util.Objects;

public abstract class Driver<T extends Transport> {

   private static final String VALID_CATEGORY = "BCD";
    private final String fullName;
    private String category;
    private final int drivingExperience;
    private final T car;

    protected Driver(String fullName,
                     String category,
                     int drivingExperience,
                     T car) {
        this.fullName = fullName;
        setCategory(category);
        this.drivingExperience = drivingExperience;
        this.car = car;
    }

    public void startMovement() {
        System.out.printf("Driver %s started moving", this.fullName);
        this.car.startMoving();
    }

    public void stopMovement() {
        System.out.printf("Driver %s stopped moving", this.fullName);
        this.car.stopMoving();
    }

    public void refill() {
        System.out.printf("Driver %s refilling the %s %s",
                this.fullName, this.car.getBrand(), this.car.getModel());
    }

    public String getFullName() {
        return fullName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.isEmpty() || !VALID_CATEGORY.contains(category)) {
            throw new IllegalArgumentException("Необходимо указать категорию прав");
        }
        this.category = category;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

//    @Override
//    public String toString() {
//        return String.format("Водитель %s управляет автомобилем %s %s и будет участвовать в заезде",
//                this.fullName, this.car.getBrand(), this.car.getModel());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return drivingExperience == driver.drivingExperience && Objects.equals(fullName, driver.fullName) && Objects.equals(category, driver.category) && Objects.equals(car, driver.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, category, drivingExperience, car);
    }

    @Override
    public String toString() {
        return "[" + fullName + ", категория " + category + ", стаж вождения " + drivingExperience + " лет]";
    }
}
