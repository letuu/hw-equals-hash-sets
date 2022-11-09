package pro.sky.java.ds_3_0.task3_3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class PassportList {

    private final Set<Passport> passports = new HashSet<>();

    public void addOrUpdatePassport(Passport passport) {
        this.passports.add(passport);
        if (!this.passports.add(passport)) {
            Iterator<Passport> passportIterator = passports.iterator();
            while (passportIterator.hasNext()) {
                if (passportIterator.next().getNumber() == passport.getNumber()) {
                    passportIterator.remove();
                    passports.add(passport);
                    break;
                }
            }
        }
    }

    public Passport findByNumber(int number) { //лучше использовать мапу - поиск по ключу без итерации
        for (Passport passport : passports) {
            if (passport.getNumber() == number) {
                return passport;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassportList that = (PassportList) o;
        return Objects.equals(passports, that.passports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passports);
    }

    @Override
    public String toString() {
        return "PassportList{" +
                "passports=" + passports +
                '}';
    }
}
