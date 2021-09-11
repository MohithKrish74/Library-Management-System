package com.keyword;

import java.util.ArrayList;
import java.util.HashMap;

public class Authenticate {

    private static ArrayList<StudentAccount> studentAccount = new ArrayList<>();
    private static HashMap<Integer,Long> studentCredentials = new HashMap<Integer,Long>();
    private static ArrayList<LibrarianAccount> librarianAccount = new ArrayList<LibrarianAccount>();
    private static HashMap<Integer,Long> librarianCredentials = new HashMap<Integer,Long>();
    private static ArrayList<String> librarians = new ArrayList<String>();

    static {
        Authenticate authenticate = new Authenticate();
        DetailsGenerate generate = new DetailsGenerate();
        Library library = new Library();
        generate.generatingYearOfPublishing();generate.generatingEdition();
        Address address = new Address(1,"Krishna Nagar","Chennai",600001,"Tamil Nadu","India");
        Student student = new Student("Ram",22,"M",address,3,1,12345,6);
        StudentAccount account = new StudentAccount(student);
        authenticate.addStudentAccount(account);
        authenticate.addStudentCredentials(1,12345);

        Author author1 = new Author("Robert",45,4,"Maths","US");
        Book book1 = new Book(1, "The Maths","Maths",author1,100,generate.yearOfPublishing, generate.edition);

        library.addBookToLibrary(book1.getSubject());
        library.setBookQuantities(book1.getSubject(),5);
        library.addToIsbnList(1);
        library.addToAuthorList(book1.getAuthor().getName());

        Author author2 = new Author("Steve",50,4.5,"Maths","UK");
        Book book2 = new Book(2, "The Science","Science",author2,200,generate.yearOfPublishing,generate.edition);

        library.addBookToLibrary(book2.getSubject());
        library.setBookQuantities(book2.getSubject(),5);
        library.addToIsbnList(2);
        library.addToAuthorList(book2.getAuthor().getName());


        Address address1 = new Address(1,"Prem Nagar","Chennai",600002,"Tamil Nadu","India");
        Librarian librarian1 = new Librarian("Raju",35,"M",address1,100,54321);
        LibrarianAccount accounts1= new LibrarianAccount(librarian1);
        authenticate.addLibrarianAccount(accounts1);
        authenticate.addLibrariansNameList(librarian1.getName());authenticate.addLibrariansNameList("Prem");
        authenticate.addLibrarianCredentials(100,54321);

        Address address2 = new Address(5,"ALS Nagar","Chennai",600004,"Tamil Nadu","India");
        Librarian librarian2 = new Librarian("Ganesh",30,"M",address2,200,67890);
        LibrarianAccount accounts2= new LibrarianAccount(librarian2);
        authenticate.addLibrarianAccount(accounts2);
        authenticate.addLibrariansNameList(librarian2.getName());
        authenticate.addLibrarianCredentials(200,67890);



    }


    public ArrayList<StudentAccount> getStudentAccount() {
        return studentAccount;
    }

    public void addStudentAccount(StudentAccount studentId) {
        this.studentAccount.add(studentId);
    }

    public  ArrayList<LibrarianAccount> getLibrarianAccount() {
        return librarianAccount;
    }

    public String getLibrarians(int index) {
        return librarians.get(index);
    }
    public void addLibrariansNameList(String name) {
        Authenticate.librarians.add(name);
    }

    public int totalLibrarianInLibrary(){
        return librarians.size();
    }


    public void addLibrarianAccount(LibrarianAccount librarianId) {
        this.librarianAccount.add(librarianId);
    }

    public HashMap<Integer, Long> getStudentCredentials() {
        return studentCredentials;
    }

    public void addStudentCredentials(int registerNumber , long phoneNumber) {
        this.studentCredentials.put(registerNumber,phoneNumber);
    }

    public HashMap<Integer, Long> getLibrarianCredentials() {
        return librarianCredentials;
    }

    public void addLibrarianCredentials(int registeredId , long phoneNumber) {
        this.librarianCredentials.put(registeredId,phoneNumber);
    }

    public boolean checkAccount(int registerNumber, int phoneNumber) {
        for (StudentAccount acc :studentAccount){
            if(acc.getStudent().getRegisterNumber()==registerNumber && studentCredentials.get(registerNumber)==phoneNumber){
                return true;
            }
        }
        System.out.println("Invalid register number or phone number!!!");
        return false;
    }

    public StudentAccount getAccount(int registerNumber) {
        for (StudentAccount acc : studentAccount) {
            if (acc.getStudent().getRegisterNumber() == (registerNumber)) {
                return acc;
            }
        }
        Address address = new Address(0,"Null","Null",0,"Null","Null");
        Student student = new Student("Null",0,"Null",address,0,0,0,0);
        return new StudentAccount(student);
    }

    public void removeStudentAccount(int registerNumber){
        boolean accountFound = false;
        for (StudentAccount acc : studentAccount) {
            if (acc.getStudent().getRegisterNumber() == (registerNumber)) {
                studentAccount.remove(acc);
                System.out.println("Student account removed Successfully!!!");
                accountFound = true;
                break;
            }
        }
        if(accountFound==false)
        {
            System.out.println("Entered registered number of the Student does not exists!!!");
        }

    }

    public void removeLibrarianAccount(int registeredId){
        boolean accountFound = false;
        for (LibrarianAccount acc : librarianAccount) {
            if (acc.getLibrarian().getRegisteredId() == (registeredId)) {
                librarianAccount.remove(acc);
                System.out.println("Librarian account removed Successfully!!!");
                accountFound = true;
                break;
            }
        }
        if(accountFound==false)
        {
            System.out.println("Entered registered Id of the Librarian does not exists!!!");
        }

    }

    public boolean checkLibrarianAccount(int registerId, int phoneNumber) {
        for (LibrarianAccount acc :librarianAccount){
            if(acc.getLibrarian().getRegisteredId()==registerId && librarianCredentials.get(registerId)==phoneNumber){
                return true;
            }
        }
        System.out.println("Invalid register number or phone number!!!");
        return false;
    }

    public LibrarianAccount getLibrarianAccount(int registerId) {
        for (LibrarianAccount acc : librarianAccount) {
            if (acc.getLibrarian().getRegisteredId()== (registerId)) {
                return acc;
            }
        }
        Address address = new Address(0,"Null","Null",0,"Null","Null");
        Librarian librarian = new Librarian("Null",0,"Null",address,0,0);
        return new LibrarianAccount(librarian);
    }




}








