import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
class Tester{
    @Test
    public void reviewTest(){
        Form form1 = new Form(102, "test 1", )
        Review review = new Review();
        assertTrue("Incorect dessison should be true", review.review(102) == true); //tests a valid form
        assertTrue("Error was able to fetch unvalid ID", review.review(2) == true);
        
    }
}
