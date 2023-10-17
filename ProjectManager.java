import java.util.Queue;

public class ProjectManager {
    public Queue<Integer> formIDQueue;

    public int nextTask(String moduleID){
        return formIDQueue.poll();
    }

    public String addTask(String sendeeModule, int formID){
        formIDQueue.add(formID);
        return "error Message";
    }
}
