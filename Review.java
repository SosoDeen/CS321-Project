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
    protected DocumentRequestForm editData(String name, String dob, String address, String aNum, String docName){  
        form.setName(name);
        form.setDob(dob);
        form.setAddress(address);
        form.setDocName(docName);
        try {
            form.setANum(Integer.parseInt(aNum));
        } catch (Exception e) {
            System.out.println("BAD A-NUM");
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
    public String addToFlow(String moduleID){
        return ProjectManager.addTask(moduleID, form.getFormID());
    }



}