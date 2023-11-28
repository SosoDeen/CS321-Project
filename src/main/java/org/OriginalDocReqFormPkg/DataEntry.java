package org.OriginalDocReqFormPkg;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        ProjectManager.addTask(Review.MODULEID, form.getFormID());

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
        if (name == null || name.equals("")) return "Please enter a name";

        // dob validation (18-103 years)
        if (dob == null || dob.equals("")) return "Please enter a date of birth";
        else if (dob.length() == 10){
            try{
                // parces date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH);
                LocalDate givenDate = LocalDate.parse(dob, formatter);
                int givenYear = givenDate.getYear();
                LocalDate d = LocalDate.now();

                // validates year
                if(givenYear > d.getYear() || givenYear < 1920){

                    return "Please enter a valid year";
                }
            }
            catch (DateTimeParseException e){
                if (e.getMessage().contains("Invalid value for MonthOfYear (valid values 1 - 12):")){
                    return "Please enter a valid month";
                } 
                else if(e.getMessage().contains("Invalid value for DayOfMonth (valid values 1 - 28/31):")){
                    return "Please enter a valid day";
                }
                else return "Please format date following mm/dd/yyyy";
            }
            //else System.out.println("NICE!");
            //System.out.println(givenDate);
            
        } else return "Please format date following mm/dd/yyyy";

        // address validation
        if (address == null || address.equals("")) return "Please enter a valid address";

        // a number validation
        if (aNum == null || aNum.equals("")) return "Please enter an A-Number";
        else if (aNum.length() >= 7 && aNum.length() <= 9){
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
