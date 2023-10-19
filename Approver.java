public class Approver {
    String MODULEID = "Approver"; //needs to be constant
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

    
    //generate string, do not generate actual email
    public String acceptAndEmail(){
        return null;
    }

    //return documentrequestform to workflow with status set to review
    public DocumentRequestForm rejectAndReturn(){
        return null;
    }
}
