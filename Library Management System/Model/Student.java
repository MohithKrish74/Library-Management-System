package com.keyword;


public class Student
{
    private String name;
    private int age;
    private String gender;
    private Address address;
    private int yearOfStudy;
    private int registerNumber;
    private long phoneNumber;
    private int semester;

    public Student(String name, int age, String gender, Address address, int yearOfStudy, int registerNumber, long phoneNumber, int semester) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.yearOfStudy = yearOfStudy;
        this.registerNumber = registerNumber;
        this.phoneNumber = phoneNumber;
        this.semester = semester;

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

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
