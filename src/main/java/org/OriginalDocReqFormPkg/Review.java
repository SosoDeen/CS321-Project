package org.OriginalDocReqFormPkg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Review{
    public static String MODULEID = "Review";
    private DocumentRequestForm form;
    
    
    
    /**
    * This method will compare the form ID to the information of the A# to check
    *if the form is correct. If the form is not correct then the form is edited.
    *
    * @return true if it was able to be corrected or correct, false if otherwise.
    **/
    public String setForm(){
        int formID = ProjectManager.nextTask(MODULEID);
        if(formID == -1){
            form = null;
            return "No more tasks to review!";
        }

        form = DocumentRequestForm.getForm(formID);
        return "Success";
    }
    public DocumentRequestForm getForm(){
        return form;
    }
    // public boolean reviewForm(int formID){
    //     if(formID == -1){
    //         return false;
    //     }
    //     return false;
    // }
    public static String getModuleID(){
        return MODULEID;
    }
    /**
     * This method changes the desired type to be the new updated data
     * @param type
     * @param form
     * @return
     */
    protected String editData(String name, String dob, String address, String aNum, String docName){  
        if(name == null || name.equals("")){
            return "Invalid Name";
        }
        if(dob != null && dob.length() == 10){
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH);
                LocalDate givenDate = LocalDate.parse(dob, formatter);
                int givenYear = givenDate.getYear();
                LocalDate d = LocalDate.now();
                if(givenYear > d.getYear() || givenYear < 1920){

                    return "Invalid Year";
                }
            }
            catch (DateTimeParseException e){
                if (e.getMessage().contains("Invalid value for MonthOfYear (valid values 1 - 12):")){
                    return "Invalid Month";
                } 
                else if(e.getMessage().contains("Invalid value for DayOfMonth (valid values 1 - 28/31):")){
                    return "Invalid Day";
                }
                return "Invalid Date of Birth, enter in the mm/dd/yyyy format";
            }
        //el
        }
        else{
            return "Invalid Date of Birth, enter in the mm/dd/yyyy format";
        }

        if(address == null || address.equals("")){
            return "Invalid Address";
        }
        if(docName == null || docName.equals("")){
            return "Invalid Document Name";
        }
        int num = 0;
        if(aNum.length() < 7 || aNum.length() > 9){
            return "Invalid A-Number";
        }
        else{
            try{
                num = Integer.parseInt(aNum);
            }
            catch (Exception e) {
                System.out.println("Invalid A-Number");
            }
        }
        form.setName(name);
        form.setDob(dob);
        form.setAddress(address);
        form.setDocName(docName);
        form.setANum(num);
        return "Updated!";
    }
    //  /**
    //  * This method changes the desired type to be the new updated data
    //  * @param type
    //  * @param form
    //  * @return
    //  */
    // protected DocumentRequestForm editData(String type, int change){    
    //     return null;na
    // }

    /**
     * saves data to database. 
     * @return String the message from the database
     */
    public String saveForm(){
        return form.saveToDatabase();
    }
    public String addToFlow(String moduleID){
        return ProjectManager.addTask(moduleID, form.getFormID());
    }



}