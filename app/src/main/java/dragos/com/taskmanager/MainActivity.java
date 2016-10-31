package dragos.com.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import dragos.com.taskmanager.jsoncreate.JsonGenerate;

public class MainActivity extends AppCompatActivity {
    TextView createAccount;
LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setlistener();

    }


    void init() {
        createAccount = (TextView) findViewById(R.id.create_account);


    }

    void setlistener() {
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CreateUserActivity.class);
                startActivity(intent);
            }
        });

    }


}
