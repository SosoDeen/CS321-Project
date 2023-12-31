package org.OriginalDocReqFormPkg;
import java.util.ArrayList;

public class ProjectManager {
    private static ArrayList<WorkFlowItem> taskList = new ArrayList<WorkFlowItem>();

    /**
     * Finds and removes the next task for the role.
     * @param moduleID the type of role
     * @return int the formID, returns -1 if none
     */
    public static int nextTask(String moduleID){
        for (WorkFlowItem currentTask : taskList){
            if (currentTask.moduleID.equals(moduleID)){
                taskList.remove(currentTask);
                return currentTask.formID;
            }
        }
        // Means no more items for that module
        return -1;
    }


    /**
     * Adds a task into the queue.
     * @param moduleID the id of the next job for the form.
     * @param formID the formID
     * @return String success on succes and an error message on failure
     */
    public static String addTask(String moduleID, int formID){
        try{
            DocumentRequestForm form =DocumentRequestForm.getForm(formID);
            if(form.getDocName() == null){
                return "Invaild index!";
            }

            taskList.add(new WorkFlowItem(formID, moduleID)); 
        }
        catch(IndexOutOfBoundsException e){
             return "Invaild index!";
        }
        catch(Exception e){
            //System.out.println(e.getMessage());
            return "Form unable to be found " +  e.getMessage()+ " occured";
           //return "Form could not be found.";
        }    
        return "Successful";
    }

    public static int getTasklistSize(){
        return taskList.size();
    }

    public static int getModuleTaskListSize(String moduleID){
        int taskCount = 0;

        for (WorkFlowItem currentTask : taskList){
            if (currentTask.moduleID.equals(moduleID)){
                taskCount++;
            }
        }

        return taskCount;
    }
    public static void clearList(){
        taskList.clear();
    }
}
