public class Review{
    private String MODULEID = "Review";
    private DocumentRequestForm form;
    /**
    * This method will compare the form ID to the information of the A# to check
    *if the form is correct. If the form is not correct then the form is edited.
    *
    * @return true if it was able to be corrected or correct, false if otherwise.
    **/
    public boolean reviewForm(int formID){
        return false;
    }
    /**
     * This method changes the desired type to be the new updated data
     * @param type
     * @param form
     * @return
     */
    protected DocumentRequestForm editData(String type, String change){    
        return null;
    }
     /**
     * This method changes the desired type to be the new updated data
     * @param type
     * @param form
     * @return
     */
    protected DocumentRequestForm editData(String type, int change){    
        return null;
    }

    /**
     * saves data to database. 
     * @return String the message from the database
     */
    public String saveData(){
        return null;
    }



}