package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;

public class ApproverTester {
    private Approver approver = new Approver();

    @Test
    public void acceptTest(){
        
        approver.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = approver.acceptAndEmail("Email");
        String expected = "Email";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void wrongEmailModuleTest(){
        approver.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = approver.acceptAndEmail(Review.MODULEID);
        String expected = "Invalid moduleID";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void rejectTest(){
        
        approver.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = approver.rejectAndReturn(Review.MODULEID);
        String expected = "Successfully Rejected";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void invalidModuleTest(){
        
        approver.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = approver.rejectAndReturn(Approver.MODULEID);
        String expected = "Invalid moduleID";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void noFormsLeftTest(){
        String result = approver.nextForm();
        String expected = "There are currently no request to approve.";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }


    @Test
    public void nextFormTest(){
        approver.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        ProjectManager.addTask(Approver.MODULEID, approver.getForm().getFormID());

        String result = approver.nextForm();
        String expected = "Loading next form.";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }
}
