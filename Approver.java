public class Approver {
    public static String MODULEID = "Approver";
    private DocumentRequestForm form;

    public DocumentRequestForm getForm(){
        return form;
    }

    public String getModuleID(){
        return MODULEID;
    }

    public void setForm(DocumentRequestForm newForm){
        form = newForm;
    }

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
    public void rejectAndReturn(String moduleID){
        ProjectManager.addTask(moduleID, form.getFormID());
    }

    public String nextForm(){
        int formID = ProjectManager.nextTask(MODULEID);
        if(formID == -1){
            form = null;
            return "There are currently no request to approve.";
        }
        else{
            form = DocumentRequestForm.getForm(formID);
            return "Loading next form.";
        }
    }

}
