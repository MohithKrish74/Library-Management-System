package com.keyword;

public class EnumerationClasses
{
    public enum AvailableOptions{
        STUDENT,
        LIBRARIAN,
        EXIT

    }
    public enum Entry{
        LOGIN,
        SIGNUP
    }

    public enum StudentActivity{
        BORROW,
        RENEWAL,
        RETURN,
        FINE,
        PAY,
        SEARCH,
        VIEW,
        LOGOUT
    }

    public enum SearchType{
        BOOK,
        AUTHOR,
        ISBN
    }

    public enum LibrarianActivity{
        ISSUE,
        CONFIRM_MEMBER,
        REMOVE_MEMBER,
        ADD_BOOK,
        REMOVE_BOOK,
        VIEW,
        LOGOUT
    }

    public enum Person{
        STUDENT,
        LIBRARIAN,
    }

    public enum Confirm{
        YES,
        NO,
    }
}
