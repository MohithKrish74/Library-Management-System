package com.keyword;

public class LibrarianAccount
{
    private Librarian librarian;

    public LibrarianAccount(Librarian librarian){
        this.librarian = librarian;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public void getBooksInfo() {
        Library library = new Library();
        if(library.getBookFromLibrary().size()!=0) {
            int counter=1;
            System.out.println("Books are : ");
            for (String book : library.getBookFromLibrary()) {
                System.out.println(counter+". "+book+" "+library.getBookQuantities(book));
                counter++;
            }
        }
        else{
            System.out.println("You do not have any books from Library!!!");
        }
    }

}
