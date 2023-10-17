public class DataEntry {
    String MODULEID = "DataEntry";
    DocumentRequestForm form;

    public String showDisplay() {
        return "non";
    }

    /**
     * Internal method for requesting 
     * new data when given data is invalid
     * @return
     */
    private boolean requestNewData(){
        // highlight incorrect field on screen
        return true;
    }

    private String validateData(){
        return "errorMessage";
    }
}
