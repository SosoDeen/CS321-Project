import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class DocumentRequestFormTester {

    DocumentRequestForm form = new DocumentRequestForm("John Doe", "January 2", 
    "123 Test St.", 100, 200, "Book", "Test");
    String expectedString = "FormID: 100\nStatus: Test\nName: John Doe\nANumber: 200\nDOB: January 2\nAddress: 123 Test St.\nDocument: Book";
    @Test
    public void getSetNameTest(){
        assertEquals("Incorrect Item/Value, expected John Doe, but was " + form.getName(), "John Doe", form.getName());
        form.setName("Jane Doe");
        assertEquals("Incorrect Item/Value, expected Jane Doe, but was " + form.getName(), "Jane Doe", form.getName());
        form.setName(null);
        assertTrue("Expected form to not be null", form.getName() != null);
    }
    @Test
    public void getSetDobTest(){
        assertEquals("Incorrect Item/Value expected January 2, but was " + form.getDob(), "January 2", form.getDob());
        form.setDob("March 14");
        assertEquals("Incorrect Item/Value expected March 14, but was " + form.getDob(), "March 14", form.getDob());
    }
    @Test
    public void getSetAddressTest(){
        assertEquals("Incorrect Item/Value expected 123 Test St., but was " + form.getAddress(), "123 Test St.", form.getAddress());
        form.setAddress("52355 Oak St.");
        assertEquals("Incorrect Item/Value expected 52355 Oak St., but was " + form.getAddress(), "52355 Oak St.", form.getAddress());
    }
     @Test
     public void geANumTest(){
         assertEquals("Incorrect Item/Value expected 200, but was " + form.getANum(), 200, form.getANum());
     }
     @Test
     public void getSetFormIDTest(){
         assertEquals("Incorrect Item/Value expected 100, but was " + form.getFormID(), 100, form.getFormID());
     }
    @Test
    public void getSetDocNameTest(){
        assertEquals("Incorrect Item/Value expected Book, but was " + form.getDocName(), "Book", form.getDocName());
        form.setDocName("Pamphlet");
        assertEquals("Incorrect Item/Value expected Pamphlet, but was " + form.getDocName(), "Pamphlet", form.getDocName());
    }
    @Test
    public void getSetStatusTest(){
        assertEquals("Incorrect Item/Value expected Test, but was " + form.getStatus(), "Test", form.getStatus());
        form.setStatus("Review");
        assertEquals("Incorrect Item/Value expected Review, but was " + form.getStatus(), "Review", form.getStatus());
    }

    @Test
    public void toStringTest(){
        assertEquals("Incorrect string expected:\n" + expectedString+ "\nBut was:\n"+ form.toString(), expectedString, form.toString());
    }
    @Test
    public void createFormTest(){
        DocumentRequestForm form2 = DocumentRequestForm.createForm("Jim", "February 5", "22222 Fifth St.", 
        262, 543, "Diploma", "Entry");
        assertEquals("Incorrect Form", form2, DocumentRequestForm.getForm(262));
        //assertTrue("Form was not null", )
        //TODO Add how you will test the data entry
    }

    @Test
    public void getFormTest(){
        assertEquals("Incorrect Form", form.getFormID(), DocumentRequestForm.getForm(form.getFormID()).getFormID());
        assertTrue("Form was not null", DocumentRequestForm.getForm(123) == null);
    }
    @Test
    public void saveToDatabase(){
        Database obj = new Database();
        String result = obj.add(this);
        assertEquals("Error unsucessful. Expected 'Success', but got" + result + "instead", "Success", result);
        assertTrue("Error was successful", obj.add(null) != "Success");
        result = obj.add(new DocumentRequestForm("test 12", "12/6/01", "10000 results", 4, 120, "Book", "Review"));
        assertEquals("Error unsucessful. Expected 'Success', but got" + result + "instead", "Success", result);

    }
}
