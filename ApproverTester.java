import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ApproverTester {
    @Test
    public void testDataTest(){
        DocumentRequestForm form1 = new DocumentRequestForm("John Doe", "May 5", 
        "123 First St.", 102, "Book", "Approve");
        Approver obj = new Approver();
        assertTrue("Incorrect decision should be true", obj.dataTest() == true);
        assertTrue("Incorrect decision should be false", obj.dataTest() == false);
    }
    
    public void acceptTest(){
        Approver obj = new Approver();
        assertTrue("Incorrect outcome should be true", obj.acceptAndEmail() == true);
        assertTrue("Incorrect outcome should be false", obj.acceptAndEmail() == false);
    }

    public void rejectTest(){
        Approver obj = new Approver();
        assertTrue("Incorrect outcome should be true", obj.rejectAndReturn() == true);
        assertTrue("Incorrect outcome should be false", obj.rejectAndReturn() == false);
    }
}
