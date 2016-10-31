package dragos.com.taskmanager.POJO;

import java.io.Serializable;

/**
 * Created by java2 on 10/27/2016.
 */

public class User implements Serializable{
    private String email;
    private String password;
    private UserInfo userInfo;


    public User(String email, String password, UserInfo userInfo) {
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
    }


    public User() {
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


}
