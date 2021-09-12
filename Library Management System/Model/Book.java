package com.keyword;

public class Book
{
    private int isbn;
    private String title;
    private String subject;
    private Author author;
    private int pageNumber;
    private int dateOfPublication;
    private int edition;

    public Book(int isbn,String title, String subject, Author author, int pageNumber, int dateOfPublication, int edition) {
        this.isbn = isbn;
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.pageNumber = pageNumber;
        this.dateOfPublication = dateOfPublication;
        this.edition = edition;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setId(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(int dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
