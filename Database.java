import java.util.ArrayList;

public class Database {
    ArrayList<String> DocNameList;
    ArrayList<DocumentRequestForm> Forms;

    public DocumentRequestForm getFormData(int FormID){
        return Forms.get(FormID);
    }

    public void saveFormData(DocumentRequestForm form){
        Forms.add(form.getFormID(), form);
    }

}
