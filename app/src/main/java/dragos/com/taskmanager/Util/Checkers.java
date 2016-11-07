package dragos.com.taskmanager.Util;

/**
 * Created by L on 11/6/2016.
 */

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Checkers {
    Pattern p;
    Matcher m;

    void stringPattern(String string) {


    }


    public boolean stringChecker( EditText editText) {
        if (editText.getText().toString() == null || editText.getText().toString().trim().isEmpty()) {
           editText.setError("Empty Field");
            return true;
        }
        p = Pattern.compile("[^A-Za-z0-9]");
        m = p.matcher(editText.getText().toString());
        if (m.find()) {
            editText.setError("Invalid Characters");
            return true;
        }
        return false;

    }

    public void emailChecker(String email, EditText editText){
        if (email == null || email.trim().isEmpty()) {
           editText.setError("Empty Email");

        }
        p = Pattern.compile("[^A-Za-z0-9]");
        m = p.matcher(email);
        if (m.find()) {

        }




    }
    public void textChange(final EditText edittext){
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringChecker(edittext);
            }

            @Override
            public void afterTextChanged(Editable s) {
                stringChecker(edittext);
            }
        });
    }

}