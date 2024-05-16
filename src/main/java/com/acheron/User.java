package com.acheron;

import java.util.Random;

public class User {
    private String username;
    private String email;
    private String password;
    private Role role;
    private String phoneNumber;

    public User(String username, String email, String password, Role role, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }
    public static User generateRandomUser() {
        Random random = new Random();
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        String[] emails = {"user1@example.com", "user2@example.com", "user3@example.com", "user4@example.com", "user5@example.com"};
        String[] passwords = {"password1", "password2", "password3", "password4", "password5"};
        Role[] roles = {Role.ADMIN, Role.USER};
        String[] phoneNumbers = {"1234567890", "9876543210", "1112223333", "4445556666", "7778889999"};

        String randomUsername = usernames[random.nextInt(usernames.length)];
        String randomEmail = emails[random.nextInt(emails.length)];
        String randomPassword = passwords[random.nextInt(passwords.length)];
        Role randomRole = roles[random.nextInt(roles.length)];
        String randomPhoneNumber = phoneNumbers[random.nextInt(phoneNumbers.length)];

        return new User(randomUsername, randomEmail, randomPassword, randomRole, randomPhoneNumber);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getUsername().equals(user.getUsername())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getRole() != user.getRole()) return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(user.getPhoneNumber()) : user.getPhoneNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getRole().hashCode();
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
