import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DataEntry {
    String MODULEID = "DataEntry";
    DocumentRequestForm form;

    /**
     * Creates a new document request form
     * @param name string of the immigrant
     * @param dob string of the immigrant
     * @param address string of the immigrant
     * @param aNum string of the immigrant
     * @param docName string of the immigrant
     * @return string pass/error message
     */
    public String createNewForm(String name, String dob, String address, String aNum, String docName){
        // validate data
        String validationMessage = validateData(name, dob, address, aNum, docName);
        if (!validationMessage.equals("success!")){
            return validationMessage;
        }

        // create a new Document Request Form
        form = DocumentRequestForm.createForm(name, dob, address, Integer.parseInt(aNum), docName, "Added");
        // add form to worflow
        ProjectManager.addTask("Review", form.getFormID());

        return "Form has been submitted!";
    }


    /**
     * Validates form input
     * @param name string of the immigrant
     * @param dob string of the immigrant
     * @param address string of the immigrant
     * @param aNum string of the immigrant
     * @param docName string of the immigrant
     * @return string pass/error message
     */
    private String validateData(String name, String dob, String address, String aNum, String docName){
        // name validation
        if (name == null || name.equals("")) return "Please enter your name";

        // dob validation (18-103 years)
        if (dob.length() == 10){
            try{
                // parces date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH);
                LocalDate givenDate = LocalDate.parse(dob, formatter);

                // validates date
                if((givenDate.getDayOfMonth() > 31 &&  givenDate.getDayOfMonth() < 1) ||
                (givenDate.getMonthValue() > 12 && givenDate.getMonthValue() < 1)||
                (givenDate.getYear() > 2005 && givenDate.getYear() < 1920)){

                    return "Please provide a valid date";
                }
            } catch (Exception e){
                return "Please provide a valid date";
            }
            //else System.out.println("NICE!");
            //System.out.println(givenDate);
            
        } else return "Please format date following mm/dd/yyyy";

        // address validation
        if (address == null || address.equals("")) return "Please enter a valid address";

        // a number validation
        if (aNum.length() >= 7 && aNum.length() <= 9){
            try {
                int parsedInt = Integer.parseInt(aNum);
             }
             catch (NumberFormatException e) {
                return "Please enter a number 7-9 digits long";
             }
        }
        else return "Please enter a number 7-9 digits long";
        
        // document name validation
        if (docName == null || docName.equals("")) return "Please enter a document name";

        return "success!";
    }


}
