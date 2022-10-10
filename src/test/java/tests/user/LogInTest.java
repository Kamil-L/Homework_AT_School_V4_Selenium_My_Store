package tests.user;

import base.Pages;
import models.User;
import providers.UserFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static providers.UserFactory.getAlreadyRegisteredUser;

public class LogInTest extends Pages {

    @Test
    //@RepeatedTest(10)
    @Tag("user")
    @Tag("LogInTest")
    public void shouldLogInRegisteredUser() {

        User user = UserFactory.getAlreadyRegisteredUser();

        headerPage
                .goToSignIn();
        loginPage
                .logIn(user);

        assertThat(headerPage.getUserAccountName()).isEqualTo("Janusz Kowalewski");
    }
}
