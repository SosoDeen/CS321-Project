import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class DataEntryTester{
    @Test
    public void reviewTest(){
        DocumentRequestForm form1 = new DocumentRequestForm("Test 1", "October", "123 tester", 102, "Book", "Review");
        Review obj = new Review();
        assertTrue("Incorect decision should be true", obj.reviewForm(102) == true); //tests a valid form
        assertTrue("Incorrect decision should be false", obj.reviewForm(2) != true); 
    }
}