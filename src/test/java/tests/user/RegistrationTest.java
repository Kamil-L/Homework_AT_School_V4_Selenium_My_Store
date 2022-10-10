package tests.user;

import base.Pages;
import models.User;
import providers.UserFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends Pages {

        @Test
        //@RepeatedTest(10)
        @Tag("user")
        @Tag("RegistrationTest")
        public void shouldRegisterNewUser() {

            User user = UserFactory.getRandomUser();

            headerPage
                    .goToSignIn()
                    .goToRegistration();
            registrationPage
                    .registerUser(user);

            assertThat(headerPage.getUserAccountName()).isEqualTo((user.getFirstName() + " " + user.getLastName()));

    }
}
