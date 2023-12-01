package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;

public class ApproverTester {
    private Approver obj = new Approver();
    private int nothing;
    
    @Test
    public void acceptTest(){
        
        obj.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = obj.acceptAndEmail("Email");
        String expected = "Email";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void wrongEmailModuleTest(){
        obj.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = obj.acceptAndEmail(Review.MODULEID);
        String expected = "Invalid moduleID";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void rejectTest(){
        
        obj.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = obj.rejectAndReturn(Review.MODULEID);
        String expected = "Successfully Rejected";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void invalidModuleTest(){
        
        obj.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        String result = obj.rejectAndReturn(Approver.MODULEID);
        String expected = "Invalid moduleID";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    @Test
    public void noFormsLeftTest(){
        String result = obj.nextForm();
        String expected = "There are currently no request to approve.";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }


    @Test
    public void nextFormTest(){
        obj.setForm(DocumentRequestForm.createForm("John Doe", "01/01/2001/", "12345", 
    20202020, "Document", "Approver"));

        ProjectManager.addTask(Approver.MODULEID, obj.getForm().getFormID());

        String result = obj.nextForm();
        String expected = "Loading next form.";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }
}
