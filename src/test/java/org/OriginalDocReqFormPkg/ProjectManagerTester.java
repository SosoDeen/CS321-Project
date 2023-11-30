package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;

public class ProjectManagerTester {
    DocumentRequestForm.createForm("John Doe", "January 2", "123 Test St.", 200193, "Book", "Review");
    DocumentRequestForm form2 = new DocumentRequestForm("John", "January 4", 
    "123 Test St.", 2, 201, "Book", "Test");
    
    DocumentRequestForm form3 = new DocumentRequestForm("Jane", "January 2", 
    "123 Test St.", 3, 202, "Book", "Test");
    ProjectManager manager = new ProjectManager();
    @Test
    public void testAdd(){
       // ProjectManager manager = new ProjectManager();
        String message = manager.addTask("Review", 1);
        assertFalse("Unable to add task 1, " + message + " occured", !message.equals("Success"));
        message = manager.addTask("Approver", 2);
        assertFalse("Unable to add task 2" + message +" occuered", !message.equals("Success"));
        message = manager.addTask("Review", -1);
        assertTrue("Able to add task 3, " + message + " occured", !message.equals("Success"));

    }
    @Test
    public void testNext(){
        int formID = manager.nextTask("Review");
        assertTrue("Wrong task was selected, expected 100, but was " + formID, formID==100);
        formID = manager.nextTask("Review");
        assertTrue("A task was selected, expected -1, but was " + formID, formID == -1);
        formID = manager.nextTask("Approver");
        assertTrue("A task was selected, expected 101, but was " + formID, formID == 101);
    }
}
