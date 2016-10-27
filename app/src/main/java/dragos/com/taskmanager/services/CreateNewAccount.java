package dragos.com.taskmanager.services;

import dragos.com.taskmanager.POJO.User;
import dragos.com.taskmanager.POJO.UserInfo;

/**
 * Created by java2 on 10/27/2016.
 */

public class CreateNewAccount {


    static User createUser(String username, String password,UserInfo userInfo ) {

        User user = new User("rzerot","pass",createUserInfo());


        return user;
    }

    static UserInfo createUserInfo(){
        UserInfo userInfo = new UserInfo();
        return userInfo;
    }


}
