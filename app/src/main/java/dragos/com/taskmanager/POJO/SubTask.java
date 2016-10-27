package dragos.com.taskmanager.POJO;

/**
 * Created by java2 on 10/27/2016.
 */

public class SubTask {
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

    public SubTask(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public SubTask() {
    }
}
