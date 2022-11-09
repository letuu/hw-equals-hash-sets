package pro.sky.java.ds_3_0.task3_3;

import java.time.LocalDate;

public class MainPassport {

    public static void main(String[] args) {

        Passport passport1 = new Passport(6846846,
                "Иванов",
                "Иван",
                "Иванович",
                LocalDate.of(2022, 12, 31));
        Passport passport2 = new Passport(857857,
                "Петров",
                "Петр",
                "Петрович",
                LocalDate.of(2021, 07, 15));
        Passport passport3 = new Passport(54684,
                "Сидоров",
                "Сидор",
                "Сидорович",
                LocalDate.of(2020, 01, 5));
        Passport passportDefault = new Passport(1,
                "Фамилия",
                "Имя",
                null,
                LocalDate.of(0, 1, 1));

        System.out.println(passport1);
        System.out.println();

        PassportList passportList = new PassportList();

        passportList.addOrUpdatePassport(passport1);
        passportList.addOrUpdatePassport(passport2);
        passportList.addOrUpdatePassport(passport3);
        passportList.addOrUpdatePassport(passportDefault);

        System.out.println(passportList);
        System.out.println();

        Passport passport1_2 = new Passport(6846846,
                "Иванов_2",
                "Иван_2",
                "Иванович_2",
                LocalDate.of(2022, 12, 31));

        passportList.addOrUpdatePassport(passport1_2); //номер тот же, изменено ФИО
        System.out.println(passportList);

        System.out.println(passport1_2.equals(passport1));

        System.out.println(passportList.findByNumber(857857));
        System.out.println(passportList.findByNumber(5555));
    }
}
