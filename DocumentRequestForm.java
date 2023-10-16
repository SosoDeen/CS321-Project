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
    public DocumentRequestForm createForm(String name, String dob, String address,int formID, int aNum, String docName, String status){
        return null;
        //return new DocumentRequestForm(name, dob, address, formID, aNum, docName, status);
    }
    public DocumentRequestForm getForm(int formID){
        return this; //FIXME ask database for form
    }
    public String validate(DocumentRequestForm form){
        return null;
    }
}
