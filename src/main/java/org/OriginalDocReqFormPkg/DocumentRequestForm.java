package org.OriginalDocReqFormPkg;

public class DocumentRequestForm {
    private String name;
    private String dob;
    private String address;
    private int aNum;
    private int formID;
    private String docName;
    private String status;

    private DocumentRequestForm(String name, String dob, String address,int formID, int aNum, String docName, String status){
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.formID = formID;
        this.aNum = aNum;
        this.docName = docName;
        this.status = status;
    }

    public String getName(){
        return this.name;
    }
    public String getDob(){
        return this.dob;
    }
    public String getAddress(){
        return this.address;
    }
    public int getANum(){
        return this.aNum;
    }
    public int getFormID(){
        return this.formID;
    }
    public String getDocName(){
        return this.docName;
    }
    public String getStatus(){
        return this.status;
    }

    public void setName(String name){
        if (name == null || name == "") return;
        this.name = name;
    }
    public void setDob(String dob){
        if (dob == null || dob == "") return;
        this.dob = dob;
    }
    public void setAddress(String address){
        if (address == null || address == "") return;
        this.address = address;
    }
    public void setANum(int aNum){
        if (aNum < 1000000 || aNum > 999999999) return;
        this.aNum = aNum;
    }
    public void setDocName(String docName){
        if (docName == null || docName == "") return;
        this.docName = docName;
    }
    public void setStatus(String status){
        if (status == null || status == "") return;
        this.status = status;
    }

    // I changed createForm, getForm, and Validate to static methods because it doesn't make much sense
    // for these methods to require an instance of DocumentRequestForm to be called
    // ie needing a DocumentRequestForm already created in order to call createForm  - William O'Brien
    public static DocumentRequestForm createForm(String name, String dob, String address, int aNum, String docName, String status){
        DocumentRequestForm form = new DocumentRequestForm(name, dob, address, Database.getNewFormID(), aNum, docName, status);
        // add form to database
        Database.saveFormData(form);
        return form;
    }

    public static DocumentRequestForm getForm(int formID){
        return Database.getFormData(formID-1);
    }
    
    /**
     * Save the current form to the database 
     * @return
     */
    public String saveToDatabase(){
        return Database.saveFormData(this);
    }

    /**
     * A string representation of the form
     * @return String the string containing the form information.
     */
    public String toString(){
        return "FormID: " + this.getFormID() + "\nStatus: " + this.getStatus() + "\nName: " + this.getName()
        + "\nANumber: " + this.getANum() + "\nDOB: " + this.getDob() + "\nAddress: " + this.getAddress()
        + "\nDocument: " + this.getDocName();
        //return null;
    }
}