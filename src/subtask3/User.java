package subtask3;

public class User {
    private String surname, name, username, password, gender, telno;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.username = builder.username;
        this.password = builder.password;
        this.gender = builder.gender;
        this.telno = builder.telno;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getTelno() {
        return telno;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() +
                "\nUsername: " + getUsername() +
                "\nPassword: " + getPassword() +
                "\nGender: " + getGender() +
                "\nTelephone: " + getTelno();
    }

    public static class UserBuilder {
        private String surname, name, username, password, gender, telno;

        public UserBuilder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder setTelno(String telno) {
            this.telno = telno;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
