public class DocumentRequestForm {
    String name;
    String dob;
    String address;
    int aNum;
    int formID;
    String docName;
    String status;

    public DocumentRequestForm(String name, String dob, String address,int formID, int aNum, String docName, String status){
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.formID = formID;
        this.docName = docName;
        this.status = status;
    }
    public String getName(){
        //return this.name;
        return null;
    }
    public String getDob(){
        //return this.dob;
        return null;
    }
    public String getAddress(){
        //return this.address;
        return null;
    }
    public int getANum(){
        //return this.aNum;
        return 0;
    }
    public int getFormID(){
        //return this.formID;
        return 0;
    }
    public String getDocName(){
        //return this.docName;
        return null;
    }
    public String getStatus(){
        //return this.status;
        return null;
    }

    public void setName(String name){
        //this.name = name;
    }
    public void setDob(String dob){
        //this.dob = dob;
    }
    public void setAddress(String Address){
        //this.address = Address;
    }
    // public void setANum(int aNum){
    // }
    // public void setFormID(int formID){
    // }
    public void setDocName(String docName){
        //this.docName = docName;
    }
    public void setStatus(String status){
        //this.status = status;
    }

    // I changed createForm, getForm, and Validate to static methods because it doesn't make much sense
    // for these methods to require an instance of DocumentRequestForm to be called
    // ie needing a DocumentRequestForm already created in order to call createForm  - William O'Brien
    public static DocumentRequestForm createForm(String name, String dob, String address,int formID, int aNum, String docName, String status){
        return null;
        //return new DocumentRequestForm(name, dob, address, formID, aNum, docName, status);
    }
    public static DocumentRequestForm getForm(int formID){
        return null; 
    }
    /**
     * Validates that the database entries are complete.
     */
    public static String validate(DocumentRequestForm form){
        return null;
    }
    /**
     * Save the current form to the database 
     * @return
     */
    public String saveToDatabase(){
        return null;
    }
    /**
     * Will try to find the address and document in the database and then send a signal to
     * ship the document to the address.
     */
    public String shipDocument(){
        return null;
    }
    /**
     * A string representation of the form
     * @return String the string containing the form information.
     */
    public String toString(){
        //return "FormID: " + this.getFormID() + "\nStatus: " + this.getStatus() + "\nName: " + this.getName()
        //+ "\nANumber: " + this.getANum() + "\nDOB: " + this.getDob() + "\nAddress: " + this.getAddress()
        //+ "\nDocument: " + this.getDocName();
        return null;
    }
}
