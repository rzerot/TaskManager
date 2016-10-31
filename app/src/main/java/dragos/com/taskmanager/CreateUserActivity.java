package dragos.com.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import dragos.com.taskmanager.POJO.User;
import dragos.com.taskmanager.POJO.UserInfo;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_user);

        init();
        setListener();


    }


    private void init() {
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
                UserInfo userInfo = new UserInfo(firstName.getText().toString(), lastName.getText().toString(), Integer.parseInt(age.getText().toString()), jobTitle.getText().toString(), profileImage.getText().toString());
                User newUser = new User(email.getText().toString(), password.getText().toString(), userInfo);

                if (userInfo.getFirstName() == null || userInfo.getLastName() == null || newUser.getEmail() != null || newUser.getPassword() != null) {


                    Gson gson = new Gson();

                    String json = gson.toJson(newUser);
                    System.out.println(json);
               //     String asset = getAssets();
           //         System.out.println(asset);
                    try {

                        FileWriter writer = new FileWriter(getAssets()+"/try.txt");
                        writer.write(json);
                        writer.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                } else {


                }


                finish();
            }
        });


    }


}
