package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;

public class ApproverTester {
    Approver obj = new Approver();
    DocumentRequestForm a = new DocumentRequestForm("John Doe", "01/01/2001/", "12345", 
    100, 20202020, "Document", "Approver");
    

    @Test
    public void acceptTest(){
        
        obj.setForm(a);

        String result = obj.acceptAndEmail("Email");
        String expected = "Email";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    public void rejectTest(){
        
        obj.setForm(a);

        String result = obj.rejectAndReturn(Review.MODULEID);
        String expected = Review.MODULEID;

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    public void noFormsLeftTest(){
        String result = obj.nextForm();
        String expected = "There are currently no request to approve.";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }

    public void nextFormTest(){
        obj.setForm(a);

        ProjectManager.addTask(Approver.MODULEID, obj.getForm().getFormID());

        String result = obj.nextForm();
        String expected = "Loading next form.";

        assertEquals("Error, unsuccessful: Expected " + expected + " but got " + result + " instead.", expected, result);
    }
}
