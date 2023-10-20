import java.util.Queue;

public class ProjectManager {
    public Queue<Integer> formIDQueue;
    int size;
    /**
     * Constructor for Project manager
     */
    public ProjectManager(){
        size = 0;
    }
    /**
     * Finds and removes the next task for the role.
     * @param moduleID the type of role
     * @return int the formID, returns 0 if none
     */
    public int nextTask(String moduleID){
        //return formIDQueue.poll();
        return 0;
    }
    /**
     * Adds a task back into the queue.
     * @param moduleID the id of the next job for the form.
     * @param formID the formID
     * @return String success on succes and an error message on failure
     */
    public String addTask(String moduleID, int formID){
        //formIDQueue.add(formID);
        return "error Message";
    }
}
