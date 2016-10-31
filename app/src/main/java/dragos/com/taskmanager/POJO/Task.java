package dragos.com.taskmanager.POJO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by java2 on 10/27/2016.
 */

public class Task implements Serializable{
   private ArrayList<SubTask> subTasks = new ArrayList<>();

    private String name;
    private boolean completed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

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
