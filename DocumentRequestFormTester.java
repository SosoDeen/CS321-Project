import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class DocumentRequestFormTester {

    DocumentRequestForm form = new DocumentRequestForm("John Doe", "January 2", 
    "123 Test St.", 100, 200, "Book", "Test");

    @Test
    public void getSetNameTest(){
        assertEquals("Incorrect Item/Value", "John Doe", form.getName());
        form.setName();
        assertEquals("Incorrect Item/Value", "Jane Doe", form.getName());
    }
    @Test
    public void getSetDobTest(){
        assertEquals("Incorrect Item/Value", "January 2", form.getDob());
        form.setDob();
        assertEquals("Incorrect Item/Value", "March 14", form.getDob());
    }
    @Test
    public void getSetAddressTest(){
        assertEquals("Incorrect Item/Value", "123 Test St.", form.getAddress());
        form.setAddress();
        assertEquals("Incorrect Item/Value", "52355 Oak St.", form.getAddress());
    }
    @Test
    public void getSetANumTest(){
        assertEquals("Incorrect Item/Value", 200, form.getANum());
        form.setANum();
        assertEquals("Incorrect Item/Value", 300, form.getANum());
    }
    @Test
    public void getSetFormIDTest(){
        assertEquals("Incorrect Item/Value", 100, form.getFormID());
        form.setFormID();
        assertEquals("Incorrect Item/Value", 163, form.getFormID());
    }
    @Test
    public void getSetDocNameTest(){
        assertEquals("Incorrect Item/Value", "Book", form.getDocName());
        form.setDocName();
        assertEquals("Incorrect Item/Value", "Pamphlet", form.getDocName());
    }
    @Test
    public void getSetStatusTest(){
        assertEquals("Incorrect Item/Value", "Test", form.getStatus());
        form.setStatus();
        assertEquals("Incorrect Item/Value", "Review", form.getStatus());
    }

    @Test
    public void createFormTest(){
        DocumentRequestForm form2 = DocumentRequestForm.createForm("Jim", "February 5", "22222 Fifth St.", 
        262, 543, "Diploma", "Entry");
        assertEquals("Incorrect Form", form2, DocumentRequestForm.getForm(262));
    }

    @Test
    public void getFormTest(){
        assertEquals("Incorrect Form", form, DocumentRequestForm.getForm(form.getFormID()));
    }
}
