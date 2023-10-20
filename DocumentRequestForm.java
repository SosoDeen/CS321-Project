public class DocumentRequestForm {
    String name;
    String dob;
    String address;
    int aNum;
    int formID;
    String docName;
    String status;// hihi this is a soso edit

    DocumentRequestForm(String name, String dob, String address,int formID, int aNum, String docName, String status){
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.formID = formID;
        this.docName = docName;
        this.status = status;
        // soso wuz here too
    }
    public String getName(){
        return null;
    }
    public String getDob(){
        return null;
    }
    public String getAddress(){
        return null;
    }
    public int getANum(){
        return 0;
    }
    public int getFormID(){
        return 0;
    }
    public String getDocName(){
        return null;
    }
    public String getStatus(){
        return null;
    }

    public void setName(){
    }
    public void setDob(){
    }
    public void setAddress(){
    }
    public void setANum(){
    }
    public void setFormID(){
    }
    public void setDocName(){
    
    }
    public void setStatus(){
       
    }

    // I changed createForm, getForm, and Validate to static methods because it doesn't make much sense
    // for these methods to require an instance of DocumentRequestForm to be called
    // ie needing a DocumentRequestForm already created in order to call createForm  - William O'Brien
    public static DocumentRequestForm createForm(String name, String dob, String address,int formID, int aNum, String docName, String status){
        return null;
        //return new DocumentRequestForm(name, dob, address, formID, aNum, docName, status);
    }
    public static DocumentRequestForm getForm(int formID){
        return null; //FIXME ask database for form
    }
    public static String validate(DocumentRequestForm form){
        return null;
    }
    /**
     * Save the current for to the database 
     * @return
     */
    public String saveToDatabase(){
        return null;
    }
}
