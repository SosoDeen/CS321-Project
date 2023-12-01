package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;
//import org.junit.Test;

public class DataEntryTester{
    DataEntry obj = new DataEntry();

    @Test
    public void validTest(){
        // tests a valid form
        assertTrue("TEST 1: All fields should be valid", 
        obj.createNewForm("Tester 1", "10/10/2008", "123 tester st.", "1231234", "Book")
        .equals("Form has been submitted!"));
    }

    @Test
    public void nameInvalidTest(){
        // tests form with invalid name
        assertTrue("TEST 2.1: Name should be empty",
        obj.createNewForm("", "10/10/2008", "123 tester st.", "1231234", "Book")
        .equals("Please enter a name"));

        // tests form with null name
        assertTrue("TEST 2.2: Name should be null", 
        obj.createNewForm(null, "10/10/2008", "123 tester st.", "1231234", "Book")
        .equals("Please enter a name"));
    }

    @Test
    public void dobInvalidTest(){
        // tests form with incorrectly formatted dob
        assertTrue("TEST 3.1: DoB should be incorrectly formatted", 
        obj.createNewForm("Tester 3.1", "10/10/28", "123 tester st.", "1231234", "Book")
        .equals("Please format date following mm/dd/yyyy"));

        // tests form with invalid dob month range
        assertTrue("TEST 3.2: DoB month should be invalid", 
        obj.createNewForm("Tester 3.2", "16/10/2008", "123 tester st.", "1231234", "Book")
        .equals("Please enter a valid month"));

        // tests form with invalid dob day range
        assertTrue("TEST 3.3: DoB day should be invalid", 
        obj.createNewForm("Tester 3.2", "10/51/2008", "123 tester st.", "1231234", "Book")
        .equals("Please enter a valid day"));

        // tests form with invalid dob year range
        assertTrue("TEST 3.4: DoB year should be invalid", 
        obj.createNewForm("Tester 3.2", "10/10/0100", "123 tester st.", "1231234", "Book")
        .equals("Please enter a valid year"));

        // tests form with a date containing letters and numbers
        assertTrue("TEST 3.5: DoB should mix numbers and letters",
        obj.createNewForm("Tester 3.3", "May 1 2001", "123 tester st.", "1231234", "Book")
        .equals("Please format date following mm/dd/yyyy"));

        // tests form with empty dob
        assertTrue("TEST 3.6: DoB should be empty", 
        obj.createNewForm("Tester 3.4", "", "123 tester st.", "1231234", "Book")
        .equals("Please enter a date of birth"));

        // tests form with null dob
        assertTrue("TEST 3.7: DoB should be null", 
        obj.createNewForm("Tester 3.5", null, "123 tester st.", "1231234", "Book")
        .equals("Please enter a date of birth"));
    }

    @Test
    public void addressInvalidTest(){
        // tests form with invalid address
        assertTrue("TEST 4.1: Address should be empty", 
        obj.createNewForm("Tester 4.1", "10/10/2008", "", "1231234", "Book")
        .equals("Please enter a valid address"));

        // tests form with null address
        assertTrue("TEST 4.2: Address should be null", 
        obj.createNewForm("Tester 4.2", "10/10/2008", null, "1231234", "Book")
        .equals("Please enter a valid address"));
    }

    @Test
    public void aNumInvalidTest(){
        // tests form with invalid a-number length
        assertTrue("TEST 5.1: A-Number should be too short", 
        obj.createNewForm("Tester 5.1", "10/10/2008", "123 tester st.", "123", "Book")
        .equals("Please enter a number 7-9 digits long"));

        // tests form with an a-number containing letters and numbers
        assertTrue("TEST 5.2: A-Number should mix letters and numbers",
        obj.createNewForm("Tester 5.2", "10/10/2008", "123 tester st.", "2a3c4b5d", "Book")
        .equals("Please enter a number 7-9 digits long"));

        // tests form with empty a-number
        assertTrue("TEST 5.3: A-Number should be empty",
        obj.createNewForm("Tester 5.3", "10/10/2008", "123 tester st.", "", "Book")
        .equals("Please enter an A-Number"));

         // tests form with null a-number
        assertTrue("TEST 5.4: A-Number should be null",
        obj.createNewForm("Tester 5.4", "10/10/2008", "123 tester st.", null, "Book")
        .equals("Please enter an A-Number"));
    }

    @Test
    public void docNameInvalidTest(){
        // tests form with empty document
        assertTrue("TEST 6.1: Document Name should be empty",
        obj.createNewForm("Tester 6.1", "10/10/2008", "123 tester st.", "1231234", "")
        .equals("Please enter a document name"));

        // tests form with null document name
        assertTrue("TEST 6.2: Document Name should be null",
        obj.createNewForm("Tester 6.2", "10/10/2008", "123 tester st.", "1231234", null)
        .equals("Please enter a document name"));
    }

    public static void main (String[] args){
        DataEntryTester tester = new DataEntryTester();
        tester.validTest();
        tester.nameInvalidTest();
        tester.dobInvalidTest();
        tester.addressInvalidTest();
        tester.aNumInvalidTest();
        tester.docNameInvalidTest();
    }
}