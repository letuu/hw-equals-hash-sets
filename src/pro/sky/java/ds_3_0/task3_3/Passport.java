package pro.sky.java.ds_3_0.task3_3;

import java.time.LocalDate;
import java.util.Objects;

public class Passport {

    private final int number;
    private final String surname;
    private final String name;
    private final String patronymic;
    private final LocalDate birthDate;

    public Passport(int number, String surname, String name, String patronymic, LocalDate birthDate) {
        if (number < 1
                || surname == null || surname.isBlank()
                || name == null || name.isBlank()
                || birthDate == null) {
            throw new IllegalArgumentException("Заполните все данные паспорта");
        }
        this.number = number;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
    }

    public int getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return number == passport.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "\nPassport{" +
                "number=" + number +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
