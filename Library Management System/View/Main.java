package com.keyword;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
;



public class Main {

    public static void main(String[] args) {
        while(true) {
            Scanner in = new Scanner(System.in);
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = date.format(format);
            System.out.println("\n                 "+formattedDate);
            try
            {
                System.out.println("\n---------------- Welcome to Library !!! ----------------");
                System.out.println("\n1.Student\n2.Librarian\n3.Exit");
                System.out.print("Your option : ");
                String input = in.nextLine().trim();
                EnumerationClasses.AvailableOptions options = EnumerationClasses.AvailableOptions.valueOf(input.toUpperCase());
                switch (options){
                    case STUDENT:{
                        System.out.println("\n1.Login\n2.Signup");
                        System.out.print("Your option : ");
                        String choice = in.nextLine().trim();
                        EnumerationClasses.Entry entry = EnumerationClasses.Entry.valueOf(choice.toUpperCase());
                        switch (entry){
                            case LOGIN:studentLogin();break;
                            case SIGNUP: studentSignUp();break;
                        }
                        break;
                    }
                    case LIBRARIAN:{
                        System.out.println("\n1.Login\n2.Signup");
                        System.out.print("Your option : ");
                        String choice = in.nextLine().trim();
                        EnumerationClasses.Entry entry = EnumerationClasses.Entry.valueOf(choice.toUpperCase());
                        switch (entry){
                            case LOGIN:librarianLogin();break;
                            case SIGNUP: librarianSignUp();break;
                        }
                        break;
                    }
                    case EXIT:
                    {
                        System.out.println("Thank you.Please visit again!!!");
                        System.exit(0);
                    }
                    default:{
                        System.out.println("Invalid Option!!!");
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void studentLogin()
    {
        Scanner in = new Scanner(System.in);
        Authenticate authenticate = new Authenticate();
        System.out.print("Enter the Register number : ");
        int registerNumber = in.nextInt();
        System.out.print("Enter the phone number : ");
        int phoneNumber = in.nextInt();
        if(authenticate.checkAccount(registerNumber,phoneNumber)){
            System.out.println("Login Successful!!!");
            StudentAccount myAccount = authenticate.getAccount(registerNumber);
            System.out.println("Hi "+ myAccount.getStudent().getName()+" welcome to the Library!!!");
            studentOperations(myAccount);
        }
        else{
            System.out.println("No account exists!!! ");
        }
    }
    public static void studentSignUp()
    {
        LibrarianOperations operations = new LibrarianOperations();
        operations.addMember();
    }
    public static void studentOperations(StudentAccount myAccount){
        Scanner in = new Scanner(System.in);
        Inner:
        while(true){
            System.out.println("\n1.Borrow\n2.Renewal\n3.Return\n4.Fine\n5.Pay\n6.Search\n7.View\n8.Logout");
            System.out.print("Your option : ");
            String input = in.next();
            Library library = new Library();
            EnumerationClasses.StudentActivity activity = EnumerationClasses.StudentActivity.valueOf(input.toUpperCase());
            StudentOperations operations = new StudentOperations();
            switch (activity){
                case BORROW:  {
                    System.out.print("Enter the book you want to borrow from the Library : ");
                    String book = in.next();
                    if (library.getBookFromLibrary().contains(capitalize(book))) {
                        if (library.getBookQuantities(capitalize(book)) != 0) {
                            System.out.println("Book is available!!!");
                            operations.borrowBook(myAccount,capitalize(book));
                        } else {
                            System.out.println("Out of Stock!!!");
                        }

                    } else {
                        System.out.println(capitalize(book) + " book is not available!!! ");
                    }
                }
                    break;

                case RENEWAL: {
                    System.out.println("Welcome to Renewal section!!!");
                    System.out.print("Enter the book to renew : ");
                    String book = in.next();
                    operations.renewalBook(myAccount,Main.capitalize(book));
                    break;
                }
                case RETURN:{
                    System.out.println("Welcome to Return Section!!!");
                    operations.returnBook(myAccount);
                    break;
                }
                case FINE:{
                    System.out.println("Welcome to Fine Amount Section!!!");
                    operations.fine(myAccount);
                    break;
                }
                case PAY:{
                    System.out.println("Welcome to Pay Fine Amount Section!!!");
                    operations.payFine(myAccount);
                    break;
                }
                case SEARCH: {
                    System.out.println("Welcome to Search section!!!");
                    System.out.println("\n1.Book\n2.Author\n3.ISBN");
                    System.out.print("Your option : ");
                    String search = in.next();
                    EnumerationClasses.SearchType searchType = EnumerationClasses.SearchType.valueOf(search.toUpperCase());
                    switch (searchType) {
                        case BOOK: {
                            operations.search(myAccount,1);
                            break ;
                        }
                        case AUTHOR: {
                            operations.search(myAccount,2);
                            break;
                        }
                        case ISBN: {
                            operations.search(myAccount,3);
                            break;
                        }

                    }
                    break;
                }case VIEW:{
                    System.out.println("Welcome to View Section!!!");
                    operations.showInfo(myAccount);
                    break;
                }case LOGOUT:{
                    System.out.println("Logout Successfully!!!");
                    break Inner;
                }

            }

        }

    }
    public static void librarianLogin(){
        Scanner in = new Scanner(System.in);
        Authenticate authenticate = new Authenticate();
        System.out.print("Enter the Register ID : ");
        int registerId = in.nextInt();
        System.out.print("Enter the phone number : ");
        int phoneNumber = in.nextInt();
        if(authenticate.checkLibrarianAccount(registerId,phoneNumber)){
            System.out.println("Login Successful!!!");
            LibrarianAccount myAccount = authenticate.getLibrarianAccount(registerId);
            System.out.println("Hi "+ myAccount.getLibrarian().getName()+" welcome to the Library!!!");
            librarianOperations(myAccount);
        }
        else{
            System.out.println("No account exists!!! ");
        }

    }
    public static void librarianSignUp(){
        LibrarianOperations operations = new LibrarianOperations();
        operations.addMember();

    }
    public static void librarianOperations(LibrarianAccount librarianAccount){
        Scanner in = new Scanner(System.in);
        Inner:
        while(true) {
            System.out.println("\n1.Issue\n2.Confirm Member\n3.Remove Member\n4.Add Book\n5.Remove Book\n6.View\n7.Logout");
            System.out.print("Your option : ");
            String input = in.next();
            EnumerationClasses.LibrarianActivity activity = EnumerationClasses.LibrarianActivity.valueOf(input.toUpperCase());
            LibrarianOperations operations = new LibrarianOperations();
            switch (activity){
                case ISSUE:{
                    operations.issueBookConfirm(librarianAccount);
                    break;
                }
                case CONFIRM_MEMBER:{
                    operations.confirmApplicant(librarianAccount);
                    break ;
                }
                case REMOVE_MEMBER:{
                    operations.removeMember(librarianAccount);
                    break;
                }
                case ADD_BOOK:{
                    System.out.println("Welcome to Add Book Section!!!");
                    System.out.print("Enter the book to add to Library : ");
                    String book = in.next();
                    operations.addBook(librarianAccount,Main.capitalize(book));
                    break;
                }
                case REMOVE_BOOK:{
                    operations.removeBook(librarianAccount);
                    break;
                }
                case VIEW:{
                    operations.showBookDetails(librarianAccount);
                    break;
                }
                case LOGOUT:{
                    System.out.println("Logout Successfully!!!");
                    break Inner;
                }
            }
        }

    }
    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
