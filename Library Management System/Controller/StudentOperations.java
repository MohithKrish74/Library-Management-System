package com.keyword;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentOperations
{
    Scanner in = new Scanner(System.in);
    public void borrowBook(StudentAccount myAccount, String book){
        Library library = new Library();
        if(myAccount.numberOfBook()>=4)
        {
            System.out.println("You cannot borrow a book from Library.Maximum book one can have is 4.");
        }
        else {
            myAccount.addBooks(book);
            library.setBookQuantities(book,library.getBookQuantities(book)-1);
            System.out.println(book + " book is issued to you Successfully!!!");
            myAccount.addBookWithTime(book, LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
            LibrarianOperations operations = new LibrarianOperations();
            operations.issueBook();
            System.out.println(book+ " book next renewal time is "+myAccount.getBookWithTime(book));

        }

    }

    public void renewalBook(StudentAccount myAccount, String book){
        if(myAccount.getBooksOfStudent().contains(book)) {
            myAccount.addBookWithTime(book, LocalTime.now().plusMinutes(2).truncatedTo(ChronoUnit.SECONDS));
            System.out.println(book + " book next renewal is " + myAccount.getBookWithTime(book));
            System.out.println("Book is renewed Successfully!!!");
        }
        else{
            System.out.println("You do not have "+book+" book to renew!!!");
        }
    }

    public void returnBook(StudentAccount myAccount){
        Library library = new Library();
        System.out.print("Enter the number of books to return : ");
        int numberOfBookReturn = in.nextInt();
        ArrayList<String>returnBooks = new ArrayList<>();
        System.out.println("Enter the Books : ");
        for(int i=0;i<numberOfBookReturn;i++)
        {
            returnBooks.add(Main.capitalize(in.next()));
        }
        for(String returnBook: returnBooks){
            int index =myAccount.getBookIndex(returnBook);
            myAccount.removeBooks(index);
            myAccount.removeBooksWithTime(returnBook);
            System.out.println(returnBook + " book is successfully returned to Library!!! ");
            library.setBookQuantities(returnBook, library.getBookQuantities(returnBook)+1);
        }
    }

    public void fine(StudentAccount myAccount){
        if(myAccount.numberOfBook()!=0) {
            double due=0;
            for (String book : myAccount.getBooksOfStudent()) {
                if (myAccount.getBookWithEntry().containsKey(book)) {
                    long minutes = ChronoUnit.MINUTES.between(myAccount.getBookWithTime(book), LocalTime.now()) % 60;
                    if (minutes > 1 && minutes <= 5) {
                        myAccount.setFineAmount(myAccount.getFineAmount() + minutes * 1.5);
                        due+= myAccount.getFineAmount();
                    } else if (minutes > 6) {
                        myAccount.setFineAmount(myAccount.getFineAmount() + minutes * 2.5);
                        due+= myAccount.getFineAmount();
                    } else {
                        myAccount.setFineAmount(0);
                        due+= myAccount.getFineAmount();
                    }
                }
                myAccount.setFineAmount(due);
            }
            System.out.println("Dear "+myAccount.getStudent().getName() + " fine amount for the book is " + myAccount.getFineAmount());
        }
        else{
            System.out.println("You do not have the book. Your fine amount is "+myAccount.getFineAmount());
        }
    }

    public void payFine(StudentAccount myAccount){
        System.out.println("Dear "+myAccount.getStudent().getName()+" your fine amount is "+myAccount.getFineAmount());
        if(myAccount.getFineAmount()!=0.) {
            System.out.print("Enter the amount : ");
            double fineAmount = in.nextDouble();
            myAccount.setFineAmount(myAccount.getFineAmount() - fineAmount);
            System.out.println("Your current fine amount is " + myAccount.getFineAmount());

        }
        else{
            System.out.println("You do not have any fine!!!");
        }
    }

    public void search(StudentAccount myAccount, int choice){
        Library library = new Library();
        boolean availability = false;
        if(choice==1){
            System.out.print("Enter the book name : ");
            String bookName = in.next();
            for(String book : library.getBookFromLibrary())
            {
                if(book.equals(Main.capitalize(bookName))){
                    System.out.println(book+" book is available.Available quantity of "+ book+" book is "+library.getBookQuantities(book)+".");
                    availability = true;
                    break;
                }
            }
            if(availability==false){
                System.out.println("Book is not available.");
            }

        }
        else if(choice==2){
            System.out.print("Enter the author name : ");
            String author = in.next();
            for(String authors : library.getAuthorList())
            {
                if(authors.equals(Main.capitalize(author)))
                {
                    System.out.println("Author "+Main.capitalize(author)+" books are available in the Library.");
                    int index =(library.indexOfAuthor(Main.capitalize(author)));
                    System.out.println("Book you are searching is "+library.getBookThroughIndex(index)+".");
                    System.out.println("Quantities of book available are "+library.getBookQuantities(library.book)+".");
                    availability = true;
                    break;

                }
            }
            if(availability==false){
                System.out.println("Author is not available.");
            }

        }
        else if(choice==3){
            System.out.print("Enter the ISBN number of the book : ");
            int isbnNumber = in.nextInt();
            for(Integer numbers : library.getIsbnList())
            {
                if(numbers==isbnNumber)
                {
                    System.out.println("ISBN number : "+isbnNumber);
                    String author = library.getAuthorThroughIndex(library.indexOfIsbnNumber(isbnNumber));
                    System.out.println("Author "+Main.capitalize(author)+" books are available in the Library.");
                    int index =(library.indexOfAuthor(Main.capitalize(author)));
                    System.out.println("Book you are searching is "+library.getBookThroughIndex(index)+".");
                    System.out.println("Quantities of book available are "+library.getBookQuantities(library.book)+".");
                    availability = true;
                    break;
                }
            }
            if(availability==false){
                System.out.println("ISBN is not available.");
            }

        }

    }

    public void showInfo(StudentAccount myAccount){
        myAccount.showBooks();
    }
}
