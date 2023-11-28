package org.OriginalDocReqFormPkg;
import java.util.ArrayList;

public class Database {
    private static ArrayList<DocumentRequestForm> Forms = new ArrayList<DocumentRequestForm>();

    public static DocumentRequestForm getFormData(int FormID){
        return Forms.get(FormID);
    }

    public static String saveFormData(DocumentRequestForm form){
        Forms.add(form.getFormID() - 1, form);
        return "Sucess";

    }

    public static int getNewFormID(){
        return Forms.size() + 1;
    }

    public static int getdatabaseSize(){
        return Forms.size();
    }

}
