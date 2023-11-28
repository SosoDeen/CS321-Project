package OriginalDocReqFormPkg;

import org.junit.*;
import static org.junit.Assert.*;
//import java.util.*;
//import org.junit.Test;
public class ReviewTester{
    @Test
    public void reviewTest(){
        DocumentRequestForm form1 = new DocumentRequestForm("Test 1", "October", "123 tester", 102, 10203, "Book", "Review");
        Review obj = new Review();
        assertTrue("Incorect decision should be true", obj.reviewForm(102) == true); //tests a valid form
        assertTrue("Incorrect decision should be false", obj.reviewForm(2) != true); 
    }
    public void editTest(){
        DocumentRequestForm form1 = new DocumentRequestForm("Test 1", "October", "123 tester", 102, 10203, "Book", "Review");
        Review obj = new Review();
        obj.reviewForm(form1.getFormID());
        obj.editData("dob", "September");

        assertEquals("Incorrect change:", "September", obj.editData("dob", "September").getDob());
        assertEquals("Incorrect change:", "Changed name", obj.editData("name", "Changed name").getName());
        assertEquals("Incorrect change:", "111 woods", obj.editData("address", "113 woods").getAddress());
        assertEquals("Incorrect change:", "Paint", obj.editData("doc", "Paint").getDocName());
        assertEquals("Incorrect change:", "Approval", obj.editData("dob", "Approval").getStatus());
    }
}
