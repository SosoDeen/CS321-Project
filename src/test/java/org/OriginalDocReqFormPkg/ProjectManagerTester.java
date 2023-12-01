package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;

public class ProjectManagerTester {
    DocumentRequestForm form2 = new DocumentRequestForm("John", "January 4", 
    "123 Test St.", 2, 201, "Book", "Test");
    
    DocumentRequestForm form3 = new DocumentRequestForm("Jane", "January 2", 
    "123 Test St.", 3, 202, "Book", "Test");
    public static ProjectManager manager = new ProjectManager();
    void inizializeDocument(){
        //id 1
        DocumentRequestForm.createForm("John Doe", "January 2", "123 Test St.", 200193, "Book", "Review"); 
        //id 2
        DocumentRequestForm.createForm("John", "January 4", "123 Wonder St.", 322142, "Unicorns", "Review"); 
        //id 3
        DocumentRequestForm.createForm("Starling", "October 4 2002", "115 Bakers St", 224231, "Art book", "Approver");
        
        //id 4
        DocumentRequestForm.createForm("A Bee", "Febuary 13 2001", "123 Test St.", 340758, "Desk", "Approver"); 
        //id 5
        DocumentRequestForm.createForm("Cee Dee", "Jully 4 1969", "123 Wonder St.", 325144, "Paper", "Email"); 
        //id 6
        DocumentRequestForm.createForm("E F", "October 4 2002", "115 Bakers St", 875321, "Work Contract", "Review");
    }
    
    @Test
    public void testAdd(){
       // ProjectManager manager = new ProjectManager();
       this.inizializeDocument();
       String message = manager.addTask("Review", 1);
        assertEquals("Unable to add task 1, " + message + " occured", "Successful", message);
        message = manager.addTask("Review", 2);
        assertEquals("Unable to add task 2" + message +" occuered", "Successful", message);
        message = manager.addTask("Approver", 3);
        assertEquals("Unable to add task 3" + message +" occuered", "Successful", message);
        assertEquals("Unable to add task 1, " + message + " occured", "Successful", message);
        
        
        message = manager.addTask("Review", -1);
        assertEquals("Able to add task 3, expected 'Invailid index!', but was " + message, "Invaild index!", message);
        message = manager.addTask("Review", 11);
        assertEquals("Able to add task 3, expected 'Invailid index!', but was " + message, "Invaild index!", message);
    }
    @Test 
    public void testSize(){
        if (manager.getTasklistSize() == 0){
            testAdd();
        }
        assertTrue("Size is incorrect expected 3, but was " + manager.getTasklistSize(), manager.getTasklistSize() == 3);
        assertTrue("Size for Review tasks is incorrect expected 2, but was " + manager.getModuleTaskListSize("Review"), manager.getModuleTaskListSize("Review") == 2);
        assertTrue("Size for Email tasks is incorrect expected 0, but was " + manager.getModuleTaskListSize("Email"), manager.getModuleTaskListSize("Email") == 0);
        assertTrue("Size for Approver tasks is incorrect expected 1, but was " + manager.getModuleTaskListSize("Approver"), manager.getModuleTaskListSize("Approver") == 1);
    }
    @Test
    public void testWorkFlow(){
        if (manager.getTasklistSize() == 0){
            testAdd();
        }
        String message;
       
        //Next tests 
        int formID = manager.nextTask("Review");
        assertTrue("Wrong task was selected, expected 1, but was " + formID, formID == 1);
        assertTrue("Size is incorrect expected 2, but was " + manager.getTasklistSize(), manager.getTasklistSize() == 2);
        assertTrue("Size for Review tasks is incorrect expected 1, but was " + manager.getModuleTaskListSize("Review"), manager.getModuleTaskListSize("Review") == 1);

        formID = manager.nextTask("Approver");
        assertTrue("A task was selected, expected 3, but was " + formID, formID == 3);
        formID = manager.nextTask("Approver");
        assertTrue("A task was selected, expected -1, but was " + formID, formID == -1);
        formID = manager.nextTask("Review");
        assertTrue("A task was selected, expected 2, but was " + formID, formID == 2);
        formID = manager.nextTask("Review");
        assertTrue("A task was selected, expected -1, but was " + formID, formID == -1);
        assertTrue("Size for Review tasks is incorrect expected 0, but was " + manager.getModuleTaskListSize("Review"), manager.getModuleTaskListSize("Review") == 0);
        assertTrue("Size for tasks is incorrect expected 0, but was " + manager.getTasklistSize(), manager.getTasklistSize() == 0);
        

        message = manager.addTask("Approver", 4);
        assertEquals("Unable to add task 4" + message +" occuered", "Successful", message);
        message = manager.addTask("Email", 5);
        assertEquals("Unable to add task 5" + message +" occuered", "Successful", message);


        message = manager.addTask("Review", 6);
        assertEquals("Unable to add task 6" + message +" occuered", "Successful", message);
        assertTrue("Size for Review tasks is incorrect expected 1, but was " + manager.getModuleTaskListSize("Review"), manager.getModuleTaskListSize("Review") == 1);
        formID = manager.nextTask("Review");
        assertTrue("A task was selected, expected 6, but was " + formID, formID == 6);

        
    }
}
