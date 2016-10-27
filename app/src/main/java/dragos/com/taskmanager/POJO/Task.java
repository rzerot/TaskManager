package dragos.com.taskmanager.POJO;

import java.util.ArrayList;

/**
 * Created by java2 on 10/27/2016.
 */

public class Task {
   private ArrayList<SubTask> subTasks = new ArrayList<>();

    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public Task() {
    }

    public Task(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
}
