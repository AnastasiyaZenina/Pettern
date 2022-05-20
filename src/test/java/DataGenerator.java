import com.github.javafaker.Faker;
import lombok.Data;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {
    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateCity(String locale) {
        String city = faker.address().cityName();
        return city;
    }
    public static String generateDate(int days) {
        LocalDate date = LocalDate.now();
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName(String locale) {
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

}



