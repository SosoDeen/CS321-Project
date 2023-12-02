package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;

public class DocumentRequestFormTester {

    @Test
    public void createFormAndSaveToDBTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form2 = DocumentRequestForm.createForm("Tester 1", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");
        
        // checks if form is null
        assertNotNull("Error: form should not be null", form2);
        // checks if from was added to the database successfully
        assertEquals("Error: Form failed to save to database", 1, Database.getdatabaseSize());
    }
    
    @Test
    public void setNameTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");
        
        // tests with a valid name
        String expected = "Tester 2.1";
        form.setName(expected);
        assertEquals("Incorrect Name: expected Tester 2.1, but was " + form.getName(), expected, form.getName());

        // tests with null name
        expected = "Tester 2.2";
        form.setName(expected);
        form.setName(null);
        assertEquals("Incorrect Name: expected Tester 2.2, but was " + form.getName(), expected, form.getName());

        // tests with empty name
        expected = "Tester 2.3";
        form.setName(expected);
        form.setName("");
        assertEquals("Incorrect Name: expected Tester 2.2, but was " + form.getName(), expected, form.getName());
    }
    
    @Test
    public void getSetDobTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");
        
        // tests with a valid dob
        String expected = "10/12/2003";
        form.setDob(expected);
        assertEquals("Incorrect dob: expected "+expected+", but was " + form.getDob(), expected, form.getDob());

        // tests with null dob
        expected = "10/15/2002";
        form.setDob(expected);
        form.setDob(null);
        assertEquals("Incorrect dob: expected "+expected+", but was " + form.getDob(), expected, form.getDob());

        // tests with empty dob
        expected = "10/20/2001";
        form.setDob(expected);
        form.setDob("");
        assertEquals("Incorrect dob: expected "+expected+", but was " + form.getDob(), expected, form.getDob());
    }
    
    @Test
    public void getSetAddressTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");
        
        // tests with valid variable
        String expected = "123 Cool St";
        form.setAddress(expected);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getAddress(), expected, form.getAddress());

        // tests with null variable
        expected = "123 Math St";
        form.setAddress(expected);
        form.setAddress(null);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getAddress(), expected, form.getAddress());

        // tests with empty variable
        expected = "123 Games St";
        form.setAddress(expected);
        form.setAddress("");
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getAddress(), expected, form.getAddress());
    }
    
    @Test
    public void geANumTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");
        
        // tests with valid variable
        int expected = 1231234;
        form.setANum(expected);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getANum(), expected, form.getANum());

        // tests with too small variable
        expected = 1593570;
        form.setANum(expected);
        form.setANum(0);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getANum(), expected, form.getANum());

        // tests with too big variable
        expected = 1673820;
        form.setANum(expected);
        form.setANum(1234567890);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getANum(), expected, form.getANum());
    }

    @Test
    public void getSetDocNameTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");
        
        // tests with valid variable
        String expected = "Book";
        form.setDocName(expected);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getDocName(), expected, form.getDocName());

        // tests with null variable
        expected = "Pamphlet";
        form.setDocName(expected);
        form.setDocName(null);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getDocName(), expected, form.getDocName());

        // tests with empty variable
        expected = "Record";
        form.setDocName(expected);
        form.setDocName("");
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getDocName(), expected, form.getDocName());
    }

    @Test
    public void getSetStatusTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");
        
        // tests with valid variable
        String expected = "Reviewer";
        form.setStatus(expected);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getStatus(), expected, form.getStatus());

        // tests with null variable
        expected = "Approver";
        form.setStatus(expected);
        form.setStatus(null);
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getStatus(), expected, form.getStatus());

        // tests with empty variable
        expected = "Email";
        form.setStatus(expected);
        form.setStatus("");
        assertEquals("Incorrect variable: expected "+expected+", but was " + form.getStatus(), expected, form.getStatus());
    }

    @Test
    public void getFormTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");

        // gets a form from database
        DocumentRequestForm formNew = DocumentRequestForm.getForm(1);

        // checks if not null
        assertNotNull("Error: form should not be null", formNew);

        // compares with main form with new form
        assertEquals("Incorrect Name: expected "+form.getName()+", but was " + formNew.getName(), form.getName(), formNew.getName());
        assertEquals("Incorrect Name: expected "+form.getDob()+", but was " + formNew.getDob(), form.getDob(), formNew.getDob());
        assertEquals("Incorrect Name: expected "+form.getAddress()+", but was " + formNew.getAddress(), form.getAddress(), formNew.getAddress());
        assertEquals("Incorrect Name: expected "+form.getANum()+", but was " + formNew.getANum(), form.getANum(), formNew.getANum());
        assertEquals("Incorrect Name: expected "+form.getDocName()+", but was " + formNew.getDocName(), form.getDocName(), formNew.getDocName());
        assertEquals("Incorrect Name: expected "+form.getFormID()+", but was " + formNew.getFormID(), form.getFormID(), formNew.getFormID());
        assertEquals("Incorrect Name: expected "+form.getStatus()+", but was " + formNew.getStatus(), form.getStatus(), formNew.getStatus());
    }
    
    @Test
    public void toStringTest(){
        // Clears database and project manager
        ProjectManager.clearList();
        Database.clearDatabase();
        DocumentRequestForm form = DocumentRequestForm.createForm("Tester 2", "10/10/2008", "123 tester st.", 1231234, "Book", "Created");

        String expected = "FormID: " + form.getFormID() + "\nStatus: " + form.getStatus() + "\nName: " + form.getName()
        + "\nANumber: " + form.getANum() + "\nDOB: " + form.getDob() + "\nAddress: " + form.getAddress()
        + "\nDocument: " + form.getDocName();

        assertEquals("Incorrect string expected:\n" +expected+ "\nBut was:\n"+ form.toString(), expected, form.toString());
    }

}
