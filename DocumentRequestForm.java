public class DocumentRequestForm {
    String name;
    String dob;
    String address;
    int formID;
    String docName;
    String status;

    DocumentRequestForm(String name, String dob, String address,int formID, String docName, String status){
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.formID = formID;
        this.docName = docName;
        this.status = status;
        
    }
    public DocumentRequestForm createForm(String name, String dob, String address,int formID, String docName, String status){
         
        return new DocumentRequestForm(name, dob, address, formID, docName, status);
    }
    public DocumentRequestForm getForm(int formID){
        return this; //FIXME ask database for form
    }
    public String validate(DocumentRequestForm form){
        return null;
    }
}
