package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var city = new String[]{"Ярославль", "Якутск", "Южно-Сахалинск", "Элиста", "Чита", "Черкесск", "Челябинск", "Чебоксары",
                "Херсон", "Ханты-Мансийск", "Хабаровск", "Уфа", "Ульяновск", "Улан-Удэ", "Тюмень", "Тула", "Томск", "Тверь",
                "Тамбов", "Сыктывкар", "Ставрополь", "Смоленск", "Симферополь", "Севастополь", "Саратов", "Саранск",
                "Санкт-Петербург", "Самара", "Салехард"
        };
        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String geberatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), geberatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }


}