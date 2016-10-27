package dragos.com.taskmanager.POJO;

import java.util.ArrayList;

/**
 * Created by java2 on 10/27/2016.
 */

public class UserInfo {

    private ArrayList<Task> tasks = new ArrayList<>();
    private String firstName;
    private String lastName;
    private int age;
    private String jobTitle;
    private String imageProfile;
    private int taskCompleted;
    private int taskRemaining;

    public UserInfo() {
    }

    public UserInfo(ArrayList<Task> tasks, String firstName, String lastName, int age, String jobTitle, String imageProfile, int taskCompleted, int taskRemaining) {
        this.tasks = tasks;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.jobTitle = jobTitle;
        this.imageProfile = imageProfile;
        this.taskCompleted = taskCompleted;
        this.taskRemaining = taskRemaining;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public int getTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(int taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public int getTaskRemaining() {
        return taskRemaining;
    }

    public void setTaskRemaining(int taskRemaining) {
        this.taskRemaining = taskRemaining;
    }
}
