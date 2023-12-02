package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;
/**
 * This class tests the ProjectManager class to make sure that all methods return 
 * as expected
 */
public class ProjectManagerTester {
    
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
       // ProjectProjectManager ProjectManager = new ProjectProjectManager();
       Database.clearDatabase();
       this.inizializeDocument();
       String message = ProjectManager.addTask("Review", 1);
        assertEquals("Unable to add task 1, " + message + " occured", "Successful", message);
        message = ProjectManager.addTask("Review", 2);
        assertEquals("Unable to add task 2" + message +" occuered", "Successful", message);
        message = ProjectManager.addTask("Approver", 3);
        assertEquals("Unable to add task 3" + message +" occuered", "Successful", message);
        
        assertEquals("Unable to add task 1, " + message + " occured", "Successful", message);
        
        
        message = ProjectManager.addTask("Review", -1);
        assertEquals("Able to add task 3, expected 'Invailid index!', but was " + message, "Invaild index!", message);
        message = ProjectManager.addTask("Review", 11);
        assertEquals("Able to add task 3, expected 'Invailid index!', but was " + message, "Invaild index!", message);
    }
    @Test 
    public void testSize(){
        ProjectManager.clearList();
        testAdd();
        assertTrue("Size is incorrect expected 3, but was " + ProjectManager.getTasklistSize(), ProjectManager.getTasklistSize() == 3);
        assertTrue("Size for Review tasks is incorrect expected 2, but was " + ProjectManager.getModuleTaskListSize("Review"), ProjectManager.getModuleTaskListSize("Review") == 2);
        assertTrue("Size for Email tasks is incorrect expected 0, but was " + ProjectManager.getModuleTaskListSize("Email"), ProjectManager.getModuleTaskListSize("Email") == 0);
        assertTrue("Size for Approver tasks is incorrect expected 1, but was " + ProjectManager.getModuleTaskListSize("Approver"), ProjectManager.getModuleTaskListSize("Approver") == 1);
    }
    @Test
    public void testWorkFlow(){
        if(ProjectManager.getTasklistSize() > 0){
            ProjectManager.clearList();
            assertTrue("Unable to clear tasklist", ProjectManager.getTasklistSize() == 0);

        }
        testAdd();
        String message;
        //Next tests 
        int formID = ProjectManager.nextTask("Review");
        assertTrue("Wrong task was selected, expected 1, but was " + formID, formID == 1);
        assertTrue("Size is incorrect expected 2, but was " + ProjectManager.getTasklistSize(), ProjectManager.getTasklistSize() == 2);
        assertTrue("Size for Review tasks is incorrect expected 1, but was " + ProjectManager.getModuleTaskListSize("Review"), ProjectManager.getModuleTaskListSize("Review") == 1);

        formID = ProjectManager.nextTask("Approver");
        assertTrue("A task was selected, expected 3, but was " + formID, formID == 3);
        formID = ProjectManager.nextTask("Approver");
        assertTrue("A task was selected, expected -1, but was " + formID, formID == -1);
        formID = ProjectManager.nextTask("Review");
        assertTrue("A task was selected, expected 2, but was " + formID, formID == 2);
        formID = ProjectManager.nextTask("Review");
        assertTrue("A task was selected, expected -1, but was " + formID, formID == -1);
        assertTrue("Size for Review tasks is incorrect expected 0, but was " + ProjectManager.getModuleTaskListSize("Review"), ProjectManager.getModuleTaskListSize("Review") == 0);
        assertTrue("Size for tasks is incorrect expected 0, but was " + ProjectManager.getTasklistSize(), ProjectManager.getTasklistSize() == 0);
        

        message = ProjectManager.addTask("Approver", 4);
        assertEquals("Unable to add task 4" + message +" occuered", "Successful", message);
        message = ProjectManager.addTask("Email", 5);
        assertEquals("Unable to add task 5" + message +" occuered", "Successful", message);


        message = ProjectManager.addTask("Review", 6);
        assertEquals("Unable to add task 6" + message +" occuered", "Successful", message);
        assertTrue("Size for Review tasks is incorrect expected 1, but was " + ProjectManager.getModuleTaskListSize("Review"), ProjectManager.getModuleTaskListSize("Review") == 1);
        formID = ProjectManager.nextTask("Review");
        assertTrue("A task was selected, expected 6, but was " + formID, formID == 6);

        
    }
}
