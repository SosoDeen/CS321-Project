package org.OriginalDocReqFormPkg;

public class Approver {
    public static String MODULEID = "Approver";
    private DocumentRequestForm form;
    private int nothing;

    public DocumentRequestForm getForm(){
        return form;
    }

    public String getModuleID(){
        return MODULEID;
    }

    public void setForm(DocumentRequestForm newForm){
        form = newForm;
    }

    
    public String acceptAndEmail(String moduleID){
        if (moduleID.equals("Email")){
            ProjectManager.addTask(moduleID, form.getFormID());
            return "Email";
        }
        else{
            return "Invalid moduleID";
        }
    }

    //return documentrequestform to workflow with status set to review
    public String rejectAndReturn(String moduleID){
        if(moduleID.equals(Review.MODULEID)){
            int before = ProjectManager.getModuleTaskListSize(Review.MODULEID);

            ProjectManager.addTask(moduleID, form.getFormID());
            form.setStatus("Review");

            int after = ProjectManager.getModuleTaskListSize(Review.MODULEID);

            if(before + 1 == after){
                return "Successfully Rejected";
            }
            else{
                return "Task was not added to Review task list";
            }
        }
        else{
            return "Invalid moduleID";
        }
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
