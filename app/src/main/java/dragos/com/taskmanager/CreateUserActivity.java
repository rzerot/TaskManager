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
    HashMap<String, User> allUsers;
    private static final String PATH = "data/data/dragos.com.taskmanager/json.txt";
    JsonService jsonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_user);

        init();
        jsonService.readFile();
        setListener();


    }


    private void init() {
        jsonService = new JsonService(this);

        submit = (Button) findViewById(R.id.submit);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        age = (EditText) findViewById(R.id.age);
        jobTitle = (EditText) findViewById(R.id.jobtitle);
        profileImage = (EditText) findViewById(R.id.profileimage);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        retypePassword = (EditText) findViewById(R.id.retype_password);
//        allUsers = new JsonService().readJson(PATH);
    }

    private void setListener() {
        submit.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          UserInfo userInfo = new UserInfo(firstName.getText().toString(), lastName.getText().toString(), Integer.parseInt(age.getText().toString()), jobTitle.getText().toString(), profileImage.getText().toString());
                                          User newUser = new User(email.getText().toString(), password.getText().toString(), userInfo);

                                          if (userInfo.getFirstName() == null || userInfo.getLastName() == null || newUser.getEmail() != null || newUser.getPassword() != null) {
                                              if (allUsers == null) {

                                              } else if (allUsers.containsKey(newUser.getEmail())) {
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

        );


    }


}
