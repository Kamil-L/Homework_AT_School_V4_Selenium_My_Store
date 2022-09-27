package models.userGenerator;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class UserFactory {


    public User getRandomUser() {
        Faker faker = new Faker();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
        User user = new User.UserBuilder()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password(8, 10, true, true))
                .setBirthday(dateFormat.format(faker.date().birthday(18, 100)))
                .build();
        return user;
    }

    public User getAlreadyRegisteredUser() {
        User user = new User.UserBuilder()
                .setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("jan.kowalski@email.com")
                .setPassword("Jan.Kow123")
                .setBirthday("30/10/2022")
                .build();
        return user;
    }
}