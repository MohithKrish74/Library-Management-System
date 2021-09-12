package com.keyword;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarianOperations
{
    Scanner in = new Scanner(System.in);
    public void issueBook(){
        Authenticate authenticate = new Authenticate();
        int min = 0;
        int max = authenticate.totalLibrarianInLibrary()-1;
        int randomLibrarianAssign = (int)(Math.random()*(max-min+1)+min);
        System.out.println("Book is issued by "+authenticate.getLibrarians(randomLibrarianAssign)+" Librarian!!!");
    }

    public void issueBookConfirm(LibrarianAccount librarianAccount){
        System.out.println("Book is issued and confirmed by "+librarianAccount.getLibrarian().getName()+".");

    }
    public void addMember(){
        DetailsGenerate generate = new DetailsGenerate();
        Authenticate authenticate = new Authenticate();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name : ");String name = in.next();
        System.out.print("Enter the age : ");int age = in.nextInt();
        System.out.print("Enter the gender : ");String gender = in.next();
        System.out.print("Enter the door number : ");int doorNumber = in.nextInt();
        System.out.print("Enter the street : ");String street = in.next();
        System.out.print("Enter the city : ");String city = in.next();
        System.out.print("Enter the state : ");String state = in.next();
        System.out.print("Enter the country : ");String country = in.next();
        generate.generatingPinCode();generate.generatingRegisterNumber();generate.generatingPhoneNumber();
        System.out.print("Are you a Student/Librarian : ");
        String input = in.next();
        EnumerationClasses.Person person = EnumerationClasses.Person.valueOf(input.toUpperCase());
        switch (person){
            case STUDENT :{
                System.out.print("Enter the year of study : ");int yearOfStudy = in.nextInt();
                System.out.print("Enter the semester : ");int semester = in.nextInt();
                Address address = new Address(doorNumber,street,city, generate.pinCode, state,country);
                Student student = new Student(name,age,gender,address,yearOfStudy,generate.registerNumber,generate.phoneNumber,semester);
                StudentAccount account = new StudentAccount(student);
                authenticate.addStudentAccount(account);
                authenticate.addStudentCredentials(generate.registerNumber,generate.phoneNumber);
                System.out.println("Hi "+account.getStudent().getName()+" your student account is created successfully!!!");
                break;

            }
            case LIBRARIAN:{
                Address address = new Address(doorNumber,street,city, generate.pinCode, state,country);
                Librarian librarian = new Librarian(name,age,gender,address,generate.registerNumber,generate.phoneNumber);
                LibrarianAccount librarianAccount = new LibrarianAccount(librarian);
                authenticate.addLibrarianAccount(librarianAccount);
                authenticate.addLibrarianCredentials(generate.registerNumber,generate.phoneNumber);
                System.out.println("Hi "+librarianAccount.getLibrarian().getName()+" your librarian account is created successfully!!!");
                break;

            }
        }



    }
    public void confirmApplicant(LibrarianAccount myAccount){
        System.out.println("Hi "+myAccount.getLibrarian().getName()+" Librarian!!!");
        System.out.println("Please check to confirm the account submitted.");
        System.out.print("Enter Yes/No : ");
        String option = in.next();
        EnumerationClasses.Confirm confirm = EnumerationClasses.Confirm.valueOf(option.toUpperCase());
        switch (confirm){
            case YES :{
                System.out.println("Account is created and confirmed by "+myAccount.getLibrarian().getName()+" .");
                break;
            }
            case NO:{
                System.out.println("Dear applicant,your account is not confirmed.Please check for changes in the form!!!");
                break;
            }
        }

    }
    public void removeMember(LibrarianAccount myAccount){

        System.out.println("Hi "+myAccount.getLibrarian().getName()+" Librarian.");
        System.out.println("Enter the person type Student/Librarian to remove the account ? ");
        System.out.print("Your option : ");
        String librarianWish = in.next();
        EnumerationClasses.Person person = EnumerationClasses.Person.valueOf(librarianWish.toUpperCase());
        switch(person){
            case STUDENT:{
                Authenticate authenticate = new Authenticate();
                System.out.print("Enter the Student Id to remove the account : ");
                int registerNumber = in.nextInt();
                authenticate.removeStudentAccount(registerNumber);
                break;
            }
            case LIBRARIAN:{
                Authenticate authenticate = new Authenticate();
                System.out.print("Enter the Librarian Id to remove the account : ");
                int registeredId = in.nextInt();
                authenticate.removeLibrarianAccount(registeredId);
                break;
            }
        }

    }
    public void addBook(LibrarianAccount librarianAccount,String book){
        Library library = new Library();
        System.out.print("Enter the quantity of the book : ");
        int quantity = in.nextInt();
        if(library.getBookFromLibrary().contains(book)){
            library.setBookQuantities(book, library.getBookQuantities(book)+quantity);
            System.out.println(book + " book quantities is added successfully to the Library!!! ");
        }
        else {
            library.addBookToLibrary(book);
            library.setBookQuantities(book, quantity);
            System.out.println(book + " book is added successfully to the Library!!! ");
        }
    }
    public void removeBook(LibrarianAccount librarianAccount){
        Library library = new Library();
        System.out.print("Enter the number of books to remove from Library : ");
        int numberOfBookToRemove = in.nextInt();
        ArrayList<String> removeBooks = new ArrayList<>();
        System.out.println("Enter the Books : ");
        for(int i=0;i<numberOfBookToRemove;i++)
        {
            removeBooks.add(Main.capitalize(in.next()));
        }
        for(String removeBook: removeBooks) {
            if (library.getBookFromLibrary().contains(removeBook)) {
                int index = library.getBookIndex(removeBook);
                library.removeBooks(index);
                library.setBookQuantities(removeBook, 0);
                System.out.println(removeBook + " book is removed successfully from the Library!!! ");
            }
            else{
                System.out.println("Entered book is not available to remove from the Library!!!");
            }
        }


    }
    public void showBookDetails(LibrarianAccount librarianAccount){
        librarianAccount.getBooksInfo();

    }
}
