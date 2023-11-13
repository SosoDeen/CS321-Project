import java.util.ArrayList;
import java.util.Queue;

public class ProjectManager {
    private ArrayList<WorkflowItem> taskList;

    private class WorkflowItem{
        public int formID;
        public String moduleID;

        public WorkflowItem(int formID, String moduleID){
            this.formID = formID;
            this.moduleID = moduleID;
        }
    }


    /**
     * Finds and removes the next task for the role.
     * @param moduleID the type of role
     * @return int the formID, returns -1 if none
     */
    public int nextTask(String moduleID){
        for (WorkflowItem currentTask : taskList){
            if (currentTask.moduleID == moduleID){
                return currentTask.formID;
            }
        }

        // Means that no more items for that module
        return -1;
    }

    /**
     * Adds a task back into the queue.
     * @param moduleID the id of the next job for the form.
     * @param formID the formID
     * @return String success on succes and an error message on failure
     */
    public String addTask(String moduleID, int formID){
        taskList.add(new WorkflowItem(formID, moduleID));
        return "";
    }

    public String sendEmail(String text){
        return null;
    }
}
