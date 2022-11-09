package pro.sky.java.ds_3_0.task3_1;

import java.util.Objects;

public class Sponsor {

    private final String name;
    private final int amount;

    public Sponsor(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void sponsorRace() {
        System.out.printf("Спонсор %s проспонсировал заезд на сумму: %d%n рублей", name, amount);
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return amount == sponsor.amount && Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }

    @Override
    public String toString() {
        return "[" + name + " - сумма поддержки " + amount + "]";
    }
}
