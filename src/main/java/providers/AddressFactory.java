package providers;

import com.github.javafaker.Faker;
import models.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AddressFactory {

    private static final Logger log = LoggerFactory.getLogger(AddressFactory.class);

    public static Address getRandomAddress() {
        Faker faker = new Faker();
        return new Address.AddressBuilder()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setAddress(faker.address().streetAddress())
                .setCity(faker.address().city())
                .setState(faker.address().state())
                .setZipPostalCode(faker.address().zipCode())
                .setCountry(String.valueOf(faker.country()))
                .build();
    }

    public static Address getSpecificAddress() {
        return new Address.AddressBuilder()
                .setFirstName("Janusz")
                .setLastName("Kowalewski")
                .setAddress("ul. Cicha 1")
                .setCity("Warszawa")
                .setState("Alabama")
                .setZipPostalCode("01-358")
                .setCountry("Poland")
                .build();
    }

    public static Address getSpecificInvoiceAddress() {
        return new Address.AddressBuilder()
                .setFirstName("Janusz")
                .setLastName("Kowalewski")
                .setAddress("ul. Warecka 2")
                .setCity("Warszawa")
                .setState("Alabama")
                .setZipPostalCode("01-338")
                .setCountry("Poland")
                .build();
    }
}