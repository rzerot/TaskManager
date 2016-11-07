package dragos.com.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import dragos.com.taskmanager.POJO.User;
import dragos.com.taskmanager.POJO.UserInfo;
import dragos.com.taskmanager.Util.Checkers;
import dragos.com.taskmanager.services.JsonService;

public class CreateUserActivity extends AppCompatActivity {
    Button submit;
    EditText firstName;
    EditText lastName;
    EditText age;
    EditText jobTitle;
    EditText profileImage;
    EditText email;
    EditText password;
    EditText retypePassword;
    HashMap<String, User> allUsers = new HashMap<>();

    JsonService jsonService = new JsonService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_user);
//        jsonService.readFile();


        init();
        setUI();

        setListener();


    }


    private void init() {
try{
        allUsers = jsonService.readJson(jsonService.readFile());}
catch (NullPointerException e){
   allUsers = new HashMap<>();
}
    }
    void setUI(){


        submit = (Button) findViewById(R.id.submit);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        age = (EditText) findViewById(R.id.age);
        jobTitle = (EditText) findViewById(R.id.jobtitle);
        profileImage = (EditText) findViewById(R.id.profileimage);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        retypePassword = (EditText) findViewById(R.id.retype_password);


    }

    private void setListener() {
        submit.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Checkers checkers = new Checkers();
                                                checkers.textChange(firstName);
                                          if((checkers.stringChecker(firstName)&& checkers.stringChecker(lastName))==true){

                                          }else {

                                          UserInfo userInfo = new UserInfo(firstName.getText().toString(), lastName.getText().toString(), Integer.parseInt(age.getText().toString()), jobTitle.getText().toString(), profileImage.getText().toString());
                                          User newUser = new User(email.getText().toString(), password.getText().toString(), userInfo);



                                          if (userInfo.getFirstName() != null || userInfo.getLastName() != null || newUser.getEmail() != null || newUser.getPassword() != null) {
                                              if (allUsers == null) {
                                                  allUsers.put(newUser.getEmail(), newUser);
                                                  jsonService.writeFile(jsonService.writeJson(allUsers));
                                                  jsonService.readFile();
                                              } else if (allUsers.containsKey(newUser.getEmail().trim())) {
//                            Toast.makeText("wrong",3);
                                              } else {
                                                  allUsers.put(newUser.getEmail(), newUser);
                                                  jsonService.writeFile(jsonService.writeJson(allUsers));

                                              }


                                          } else

                                          {


                                          }


                                          finish();
                                          }
                                      }
                                  }

        );


    }


}
