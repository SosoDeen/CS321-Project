package org.OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;
//import org.junit.Test;
public class ReviewTester{
    private Review obj;
    
    @Test
    public void setFormTest(){
        obj = new Review();
        Database.clearDatabase();
        ProjectManager.clearList();
        //id == 1;
        DocumentRequestForm.createForm("John Doe", "January 2 2002", "123 Test St.", 200193, "Book", "Review");
        ProjectManager.addTask("Review", 1);
        String message = obj.setForm();
        assertEquals("Expected 'Success', but was " + message , "Success", message); //tests a valid form
        message = obj.setForm();
        assertEquals("Expected 'No more tasks to review!', but was " + message, "No more tasks to review!", message); 
    }
    @Test
    public void editTest(){
        //DocumentRequestForm form1 = new DocumentRequestForm("Test 1", "October", "123 tester", 102, 10203, "Book", "Review");
        obj = new Review();
        Database.clearDatabase();
        ProjectManager.clearList();
        //id == 1;
        DocumentRequestForm.createForm("John Doe", "January 2 2002", "123 Test St.", 200193, "Book", "Review");
        ProjectManager.addTask("Review", 1);
        obj.setForm();
        assertTrue("Expected a size of 0 for the module list for review, but was " + ProjectManager.getModuleTaskListSize("Review"), 0 == ProjectManager.getModuleTaskListSize("Review"));
        String message = obj.editData("Great Dane", "10/10/1967", "111 Easy World", "12345678", "Pixel Art");

        assertEquals("Expected 'Updated!', but was " + message, "Updated!", message);
        assertEquals("Incorrect change! Expected 'Great Dane', but was " + obj.getForm().getName(), "Great Dane", obj.getForm().getName());
        assertEquals("Incorrect change! Expected '10/10/1967', but was " + obj.getForm().getDob(), "10/10/1967", obj.getForm().getDob());
        assertEquals("Incorrect change! Expected '111 Easy World', but was " + obj.getForm().getAddress(), "111 Easy World", obj.getForm().getAddress());
        assertEquals("Incorrect change! Expected '12345678', but was " + obj.getForm().getANum(), "12345678", obj.getForm().getANum() + "");
        assertEquals("Incorrect change! Expected 'Pixel Art', but was " + obj.getForm().getDocName(), "Pixel Art", obj.getForm().getDocName());
        
        message = obj.editData("", "10/10/1967", "111 Easy World", "12345678", "Pixel Art");
        assertEquals("Expected 'Invalid Name', but was " + message, "Invalid Name", message);
        message = obj.editData("Great Dane", "October 10th 2002", "111 Easy World", "12345678", "Pixel Art");
        assertEquals("Expected 'Invalid Date of Birth, enter in the mm/dd/yyyy format', but was " + message, "Invalid Date of Birth, enter in the mm/dd/yyyy format", message);
        message = obj.editData("Great Dane", "20/12/2002", "111 Easy World", "12345678", "Pixel Art");
        assertEquals("Expected 'Invalid Month', but was " + message, "Invalid Month", message);
        message = obj.editData("Great Dane", "02/45/2002", "111 Easy World", "12345678", "Pixel Art");
        assertEquals("Expected 'Invalid Day', but was " + message, "Invalid Day", message);
        message = obj.editData("Great Dane", "02/12/0001", "111 Easy World", "12345678", "Pixel Art");
        assertEquals("Expected 'Invalid Year', but was " + message, "Invalid Year", message);
        message = obj.editData("Great Dane", "10/10/1957", null, "12345678", "Pixel Art");
        assertEquals("Expected 'Invalid Address', but was " + message, "Invalid Address", message);
        message = obj.editData("Great Dane", "10/10/2010", "111 Easy World", "1234567890", "Pixel Art");
        assertEquals("Expected 'Invalid A-Number', but was " + message, "Invalid A-Number", message);
        message = obj.editData("Great Dane", "10/10/2010", "111 Easy World", "123456", "Pixel Art");
        assertEquals("Expected 'Invalid A-Number', but was " + message, "Invalid A-Number", message);
        message = obj.editData("Great Dane", "10/10/2010", "111 Easy World", "Hello", "Pixel Art");
        assertEquals("Expected 'Invalid A-Number', but was " + message, "Invalid A-Number", message);
        message = obj.editData("Great Dane", "10/10/2010", "111 Easy World", "12345678", null);
        assertEquals("Expected 'Invalid Document Name', but was " + message, "Invalid Document Name", message);
        
        obj.addToFlow("Approver");
        assertTrue("Expected a size of 1 for the module list for approver, but was " + ProjectManager.getModuleTaskListSize("Approver"), 1 == ProjectManager.getModuleTaskListSize("Approver"));
       

        
        
        
        
        
        
        
    }
    
}
