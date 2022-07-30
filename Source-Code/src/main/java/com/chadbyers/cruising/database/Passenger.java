package com.chadbyers.cruising.database;

public class Passenger {

    private int id;
    private String firstName;
    private String lastName;
    private int passportNumber;
    private String birthdate;
    private String city;
    private String state;

    public Passenger(int id, String firstName, String lastName, int passportNumber, String birthdate, String city, String state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.birthdate = birthdate;
        this.city = city;
        this.state = state;
    }

    public Passenger(String firstName, String lastName, int passportNumber, String birthdate, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.birthdate = birthdate;
        this.city = city;
        this.state = state;
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

    public int getPassportNumber() {
        return passportNumber;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return  "Passenger ID = " + id + "\r\n" +
                "First Name = '" + firstName + "\r\n" +
                "Last Name = '" + lastName + "\r\n" +
                "Passport Number = " + passportNumber
                ;
    }
}
