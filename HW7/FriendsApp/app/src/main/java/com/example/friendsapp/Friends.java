package com.example.friendsapp;

public class Friends {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Friends (int newId, String newFirstName, String newLastName, String newEmail) {
        setId(newId);
        setFirstName(newFirstName);
        setLastName(newLastName);
        setEmail(newEmail);
    }

    private void setId(int newId) {
        id = newId;
    }

    private void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    private void setLastName(String newLastName) {
        lastName = newLastName;
    }

    private void setEmail(String newEmail) {
        email = newEmail;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return id + " " + firstName + " " + lastName + " " + email;
    }
}
