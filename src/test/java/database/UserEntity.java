package database;

import enums.Region;
import enums.Role;
import enums.SelectRoleDropdownList;

/**
 * POJO class created in purpose to work with databases.
 */
public class UserEntity {
    private String firstName;
    private String lastName;
    private String password;
    private String login;
    private String email;
    private Region region;
    private Role role;

    public UserEntity(Builder userEntityBuilder) {
        this.firstName = userEntityBuilder.firstName;
        this.lastName = userEntityBuilder.lastName;
        this.password = userEntityBuilder.password;
        this.login = userEntityBuilder.login;
        this.email = userEntityBuilder.email;
        this.region = userEntityBuilder.region;
        this.role = userEntityBuilder.role;
    }


    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Region getRegion() {
        return region;
    }

    public Role getRole() {
        return role;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String password;
        private String login;
        private String email;
        private Region region;
        private Role role;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRegion(Region region) {
            this.region = region;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public UserEntity build(){
            return new UserEntity(this);
        }

    }
}
