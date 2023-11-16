public class Review{
    private static String MODULEID = "Review";
    private DocumentRequestForm form;
    /**
    * This method will compare the form ID to the information of the A# to check
    *if the form is correct. If the form is not correct then the form is edited.
    *
    * @return true if it was able to be corrected or correct, false if otherwise.
    **/
    public Review(int formID){
        form = DocumentRequestForm.getForm(formID);
    }
    public DocumentRequestForm getForm(){
        return form;
    }
    public boolean reviewForm(int formID){
        if(formID == -1){
            return false;
        }
        return false;
    }
    public static String getModuleID(){
        return MODULEID;
    }
    /**
     * This method changes the desired type to be the new updated data
     * @param type
     * @param form
     * @return
     */
    protected DocumentRequestForm editData(String type, String change){  
        if(type.equals("Name")){
            form.setName(change);
        }  
        else if(type.equals("DOB")){
            form.setDob(change);
        }
        else if(type.equals("Address")){
            form.setAddress(change);
        }
        else if(type.equals("Document Name")){
            form.setDocName(change);
        }
        return form;
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



}