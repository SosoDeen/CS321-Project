import java.util.Queue;

public class ProjectManager {
    public Queue<Integer> formIDQueue;

    public int nextTask(String moduleID){
        return formIDQueue.poll();
    }
}
