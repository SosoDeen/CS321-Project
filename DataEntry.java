public class DataEntry {
    String MODULEID = "DataEntry";
    DocumentRequestForm form;

    public String showDisplay() {
        return "non";
    }

    /**
     * Internal method for requesting 
     * new data when given user data is invalid
     * @return boolean if user sent in data
     */
    private boolean requestNewData(String errorMessage){
        // highlight incorrect field on screen
        //display error message. if error message == null, no message is displayed
        //ask for new data
        return true;
    }


    /**
     * 
     * @return String pass/error message.
     */
    private String validateData(){
        if (form.getName() != null)
            return "errorMessage";
        if (form.getANum() <= 0)
            return "errorMessage";

        return "success!";
    }
}
