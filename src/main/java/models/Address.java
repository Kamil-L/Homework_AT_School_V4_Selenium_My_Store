package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Address {

    private static final Logger log = LoggerFactory.getLogger(Address.class);

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String state;
    private final String zipPostalCode;
    private final String country;


    public Address(String firstName, String lastName, String address, String city, String state, String zipPostalCode,
                   String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipPostalCode = zipPostalCode;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public String getCountry() {
        return country;
    }

    public Address(AddressBuilder addressBuilder) {

        this.firstName = addressBuilder.firstName;
        this.lastName = addressBuilder.lastName;
        this.address = addressBuilder.address;
        this.city = addressBuilder.city;
        this.state = addressBuilder.state;
        this.zipPostalCode = addressBuilder.zipPostalCode;
        this.country = addressBuilder.country;
    }

    public static final class AddressBuilder {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zipPostalCode;
        private String country;


        public AddressBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AddressBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AddressBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public AddressBuilder setZipPostalCode(String zipPostalCode) {
            this.zipPostalCode = zipPostalCode;
            return this;
        }

        public AddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build() {

            if (firstName.isEmpty()) {
                throw new IllegalStateException("First name cannot be empty");
            }
            if (lastName.isEmpty()) {
                throw new IllegalStateException("Last name cannot be empty");
            }
            if (address.isEmpty()) {
                throw new IllegalStateException("Address cannot be empty");
            }
            if (city.isEmpty()) {
                throw new IllegalStateException("City cannot be empty");
            }
            if (state.isEmpty()) {
                throw new IllegalStateException("State cannot be empty");
            }
            if (zipPostalCode.isEmpty()) {
                throw new IllegalStateException("Zip/Postal Code cannot be empty");
            }

            if (country.isEmpty()) {
                throw new IllegalStateException("Country cannot be empty");
            }

            return new Address(this);
        }
    }
}