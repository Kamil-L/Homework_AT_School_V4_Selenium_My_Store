package models.userGenerator;

public class User {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String birthday;


    public User(String firstName, String lastName, String email, String password, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.birthday = userBuilder.birthday;
    }

    public static final class UserBuilder {

        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthday;



        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public User build() {
            if (firstName.isEmpty()) {
                throw new IllegalStateException("First name cannot be empty");
            }
            if (lastName.isEmpty()) {
                throw new IllegalStateException("Last name cannot be empty");
            }
            if (email.isEmpty()) {
                throw new IllegalStateException("Email cannot be empty");
            }
            if (password.isEmpty()) {
                throw new IllegalStateException("Password cannot be empty");
            }
            return new User(this);
        }
    }
}