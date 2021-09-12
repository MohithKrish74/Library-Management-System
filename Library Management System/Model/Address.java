package com.keyword;

public class Address
{
    private int number;
    private String street;
    private String city;
    private int pinCode;
    private String state;
    private String country;

    public Address(int number, String street, String city, int pinCode, String state, String country) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
