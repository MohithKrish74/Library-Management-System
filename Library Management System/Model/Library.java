package com.keyword;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

public class Library
{
    String book,author;
    private Book books;
    private static List<String> bookList = new ArrayList<>();
    private static List<Integer> isbnList = new ArrayList<>();
    private static List<String> authorList = new ArrayList<>();
/*    private static List<Integer> bookQuantity = new ArrayList<>();//optional*/
    private static Map<String,Integer> bookQuantities = new HashMap<String,Integer>();

    public Book getBooks(){
        return books;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getBookQuantities(String book) {
        return bookQuantities.get(book);
    }

    public String getBookThroughIndex(int index){
        if(index<=bookList.size()){
            book = bookList.get(index);
            return book;
        }
        return "No book!!!";
    }

    public void setBookQuantities(String book,int quantity) {
        Library.bookQuantities.put(book,quantity);
    }

    public List<String> getBookFromLibrary() {
        return bookList;
    }

    public void addBookToLibrary(String book) {
        Library.bookList.add(book);
    }

    public List<Integer> getIsbnList() {
        return isbnList;
    }

    public void addToIsbnList(int isbnNumber) {
        Library.isbnList.add(isbnNumber);
    }

    public int indexOfIsbnNumber(int isbnNumber)
    {
        for (Integer number : isbnList)
        {
            if(isbnNumber==number)
            {
                return isbnList.indexOf(isbnNumber);
            }
        }
        return 0;
    }

    public List<String> getAuthorList() {
        return authorList;
    }

    public void addToAuthorList(String author) {
        Library.authorList.add(author);
    }

    public int indexOfAuthor(String author)
    {
        for (String authors : authorList)
        {
            if(authors.equals(author))
            {
                return authorList.indexOf(author);
            }
        }
        return 0;
    }
    public String getAuthorThroughIndex(int index){
        if(index<=authorList.size()){
            author = authorList.get(index);
            return author;
        }
        return "No Author found for the book !!!";
    }

    public void removeBooks(int index){
        this.bookList.remove(index);

    }

    public int getBookIndex(String book){
        for(String bestBook:bookList)
        {
            if(bestBook.equals(book)){
                return bookList.indexOf(book);
            }

        }
        return 0;
    }
}
