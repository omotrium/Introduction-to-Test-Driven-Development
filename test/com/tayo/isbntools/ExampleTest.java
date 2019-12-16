package com.tayo.isbntools;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void checkValid10DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140779117");
        assertFalse(result);
        result = validator.checkISBN("0140889111");
        assertFalse(result);

    }

    //13 digit ISBN test

    @Test
    public void checkValid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781509826643");
        assertTrue("first value", result);
        result = validator.checkISBN("9780140449266");
        assertTrue(result);
    }


    @Test
    public void checkInvalid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781509826648");
        assertFalse(result);
       // fail();
    }

    @Test
    public void checkInvalid10DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140889117");
        assertFalse(result);
}
    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreNotAllowed(){
       ValidateISBN validator = new ValidateISBN();
       validator.checkISBN("123456789111");

    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140889117");
        validator.checkISBN("helloworld");

    }
     @Test(expected = NumberFormatException.class)
    public void ISBNNumberEndingInAnXAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140889117X");
        assertTrue(result);
    }

    @Test

    public void isAValidEmailAddress(){

        MySystem mySystem = new MySystem();
        String email = mySystem.getEmail();
        assertThat(email, StringContains.containsString("@"));
    }

}
