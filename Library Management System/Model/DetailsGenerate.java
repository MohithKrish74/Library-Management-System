package com.keyword;

public class DetailsGenerate
{
    int registerNumber=0,pinCode=0,yearOfPublishing=0,edition=0;
    long phoneNumber;
    String registerNumberString = Integer.toString(registerNumber);
    public void generatingRegisterNumber() {
        Authenticate authenticate = new Authenticate();
        while (!(authenticate.getStudentAccount().contains(registerNumber)) && (!(registerNumberString.length() == 5)) ) {
            int min = 10000;
            int max = 99999;
            registerNumber = (int) (Math.random() * (max - min + 1) + min);
            break;
        }
        System.out.println("Register Number : " + registerNumber);
    }
    public void generatingPinCode()
    {
        int min = 600000;
        int max = 699999;
        pinCode = (int)(Math.random()*(max-min+1)+min);
        System.out.println("Pin code : "+pinCode);
    }
    public void generatingPhoneNumber()
    {
        long min = 700000000;
        long max = 999999999;
        phoneNumber = (long) (Math.random()*(max-min+1)+min);
        System.out.println("Phone Number : "+phoneNumber);
    }
    public void generatingYearOfPublishing()
    {
        int min = 1900;
        int max = 1990;
        yearOfPublishing = (int)(Math.random()*(max-min+1)+min);
    }
    public void generatingEdition()
    {
        int min = 1;
        int max = 9;
        edition = (int)(Math.random()*(max-min+1)+min);

    }

}
