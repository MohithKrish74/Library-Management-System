package com.keyword;

public class Librarian
{
    private String name;
    private int age;
    private String gender;
    private Address address;
    private int registeredId;
    private long phoneNumber;

    public Librarian(String name, int age, String gender, Address address, int registeredId, long phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.registeredId = registeredId;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getRegisteredId() {
        return registeredId;
    }

    public void setRegisteredId(int registeredId) {
        this.registeredId = registeredId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
