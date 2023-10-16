public class Approver {
    String MODULEID = "Approver"; //needs to be constant
    String askerID;
    DocumentRequestForm form;

    /** 
     * This method is meant to check if the data in the form
     * is valid. 
     * 
     * Note that this method leads into acceptAndEmail if data is valid 
     * and rejectAndReturn if data is invalid
     * 
     * @return true if valid and false otherwise.
     **/
    public boolean dataTest(){
        return false;
    }

    public boolean acceptAndEmail(){
        return false;
    }

    public boolean rejectAndReturn(){
        return false;
    }
}
