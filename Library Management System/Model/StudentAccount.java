package com.keyword;

import java.time.LocalTime;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;


public class StudentAccount
{
    private Student student;
    private double fineAmount;
    private ArrayList<String> books = new ArrayList<String>(4);
    private HashMap<String, LocalTime> bookWithTime = new HashMap<String,LocalTime>();

    public StudentAccount(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public LocalTime getBookWithTime(String book) {
        return bookWithTime.get(book);
    }

    public void addBookWithTime(String book,LocalTime time) {
        this.bookWithTime.put(book,time);
    }

    public HashMap<String,LocalTime> getBookWithEntry(){
        return bookWithTime;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<String> getBooksOfStudent(){
        return books;
    }

    public void showBooks() {
        if(books.size()!=0) {
            int counter=1;
            System.out.println("Books are : ");
            for (String book : books) {
                System.out.println(counter+". "+book+" "+getBookWithTime(book));
                counter++;
            }
        }
        else{
            System.out.println("You do not have any books from Library!!!");
        }
    }
    public int numberOfBook()
    {
        return books.size();
    }

    public void addBooks(String books) {
        this.books.add(books);
    }

    public List<String> returnBooksToLibrary(){
        return books;
    }

    public void removeBooks(int index){
        this.books.remove(index);
    }

    public void removeBooksWithTime(String book){
        this.bookWithTime.remove(book);
    }

    public int getBookIndex(String book){
        for(String bestBook:books)
        {
            if(bestBook.equals(book)){
                return books.indexOf(book);
            }

        }
        return 0;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fine) {
        this.fineAmount = fine;
    }
}
