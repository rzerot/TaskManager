package dragos.com.taskmanager.Util;

/**
 * Created by L on 11/6/2016.
 */

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Checkers {
    Pattern p;
    Matcher m;
    public static final int IS_EMPTY = 0;
    public static final int INVALID_CHARECTER = 1;

    void stringPattern(String string) {


    }

    //        void fieldListeners(EditText editText){
//            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                @Override
//                public void onFocusChange(View view, boolean b) {
//                    if (b){
//
//                        editText.setError("Empty Field");
//                    }else {
//
//                        editText.setError("Empty Field");
//
//                    }
//                }
//            });
//
//
//        }
    public int isValidField(String string) {
        if (isEmpty(string)) return IS_EMPTY;
        else {
            if (isInvalidChar(string)) return INVALID_CHARECTER;
        }
        return -1;
    }

    public boolean isEmpty(String string) {
        return TextUtils.isEmpty(string.trim());

    }

    public boolean isInvalidChar(String string) {
        p = Pattern.compile("[^A-Za-z0-9]");
        m = p.matcher(string);
        if (m.find()) {


            return true;
        }
        return false;
    }


    public boolean stringChecker(EditText editText) {


        if (editText.getText().toString() == null || editText.getText().toString().trim().isEmpty()) {

            editText.setError("Empty Field");
            return false;
        }
        p = Pattern.compile("[^A-Za-z0-9]");
        m = p.matcher(editText.getText().toString());
        if (m.find()) {
            editText.setError("Invalid Characters");

            return false;
        }
        return true;

    }

    public void emailChecker(String email, EditText editText) {
        if (email == null || email.trim().isEmpty()) {
            editText.setError("Empty Email");

        }
        p = Pattern.compile("[^A-Za-z0-9]");
        m = p.matcher(email);
        if (m.find()) {

        }


    }

    public void textChange(final EditText edittext) {
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