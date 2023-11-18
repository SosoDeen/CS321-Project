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

    
    public void acceptAndEmail(String moduleID){
        ProjectManager.addTask(moduleID, form.getFormID());
    }

    //return documentrequestform to workflow with status set to review
    public void rejectAndReturn(String moduleID){
        ProjectManager.addTask(moduleID, form.getFormID());
        form.setStatus("Review");
    }

    public String nextForm(){
        int formID = ProjectManager.nextTask(MODULEID);
        if(formID == -1){
            setForm(null);
            return "There are currently no request to approve.";
        }
        else{
            setForm(DocumentRequestForm.getForm(formID));
            return "Loading next form.";
        }
    }

}
