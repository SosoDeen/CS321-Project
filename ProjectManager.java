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
            if (currentTask.moduleID == moduleID){
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
        taskList.add(new WorkFlowItem(formID, moduleID));
        return "";
    }

    public static int getTasklistSize(){
        return taskList.size();
    }
}
