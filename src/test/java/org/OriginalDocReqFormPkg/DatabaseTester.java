package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;

public class DatabaseTester {
   private DocumentRequestForm form;
    
    @Test
    public void saveFormAndGetFormDataTest(){

        Database.clearDatabase();

        form = DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
        20202020, "Document", "Approver");
        DocumentRequestForm expected = Database.getFormData(form.getFormID()-1);
        
        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + form + " instead.", expected, form);

    }

    //@Test
    //public void noFormTest(){
    //    IndexOutOfBoundsException e = new IndexOutOfBoundsException();
    //    assertEquals("Error, unsuccessful: Expected an out of bounds exception.", e, Database.getFormData(2));
    //}

    @Test
    public void newFormIDTester(){

        Database.clearDatabase();

        int expected = 1;
        int result = Database.getNewFormID();

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);

        form = DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
        20202020, "Document", "Approver");

        expected = 2;
        result = Database.getNewFormID();
        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void databaseSizeTest(){

        Database.clearDatabase();

        int expected = 0;
        int result = Database.getdatabaseSize();

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);

        form = DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
        20202020, "Document", "Approver");

        expected = 1;
        result = Database.getdatabaseSize();

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test public void clearDatabaseTest(){

        Database.clearDatabase();

        form = DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
        20202020, "Document", "Approver");
       
        Database.clearDatabase();

        int expected = 0;
        int result = Database.getdatabaseSize();

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }
}
