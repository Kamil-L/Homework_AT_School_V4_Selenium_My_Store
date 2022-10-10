package providers;

import com.github.javafaker.Faker;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

public class UserFactory {

    private static final Logger log = LoggerFactory.getLogger(UserFactory.class);

    public static User getRandomUser() {
        Faker faker = new Faker();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return new User.UserBuilder()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password(8, 10, true, true))
                .setBirthday(dateFormat.format(faker.date().birthday()))
                .build();
    }

    public static User getAlreadyRegisteredUser() {
        return new User.UserBuilder()
                .setFirstName("Janusz")
                .setLastName("Kowalewski")
                .setEmail("janusz.kowalewski@email.com")
                .setPassword("Jan.Kowal123")
                .setBirthday("01/01/1980")
                .build();
    }
}