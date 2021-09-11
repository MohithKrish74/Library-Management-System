package com.keyword;

public class Author{
    private String name;
    private int numberOfBooksWritten;
    private double rating;
    private String field;
    private String country;

    public Author(String name, int numberOfBooksWritten, double rating, String field, String country) {
        this.name = name;
        this.numberOfBooksWritten = numberOfBooksWritten;
        this.rating = rating;
        this.field = field;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBooksWritten() {
        return numberOfBooksWritten;
    }

    public void setNumberOfBooksWritten(int numberOfBooksWritten) {
        this.numberOfBooksWritten = numberOfBooksWritten;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
