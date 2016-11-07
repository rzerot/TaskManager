package dragos.com.taskmanager.services;

import android.content.Context;
import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import dragos.com.taskmanager.POJO.User;

/**
 * Created by java2 on 11/3/2016.
 */

public class JsonService {
    private Context context;

    public JsonService(Context context) {
        this.context = context;


    }

    private static final String FILENAME = "jsonFile";


    public void writeFile(String string) {

//        String [] files =        context.fileList();
//
//        for(String file :files) {
//            context.deleteFile(file);
//        }

        try {


            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);

//            /data/user/0/dragos.com.taskmanager/files
//            FileOutputStream fos = new FileOutputStream("/data/user/0/dragos.com.taskmanager/files/"+FILENAME,false);
            System.out.println(context.getFilesDir());
            fos.write(string.getBytes());
            fos.flush();
            fos.close();
//            String[] zalist = context.fileList();
//            for (String list : zalist) {
//                System.out.println(list);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String readFile() {
//        System.out.println(context.getFilesDir());
        StringBuilder stringBuilder = new StringBuilder();
        int i;

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            while ((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }
            fis.close();
        } catch (Exception e) {

            writeFile("");
            e.printStackTrace();
        }

        System.out.println("YESSS?" + stringBuilder);

        return stringBuilder.toString();
    }
//void deleteFile(){
//    File filesDir = context.getFilesDir();
//   	successfully = context.deleteFile(file.getName());
//
//}

    //JSON
    public HashMap<String, User> readJson(String path) {
        Gson gson = new Gson();
        HashMap<String, User> allUsers = new HashMap<>();
        ArrayList<User> jsonContent;
        Type type = new TypeToken<ArrayList<User>>() {
        }.getType();
        jsonContent = gson.fromJson(path, type);
        for (int i = 0; i < jsonContent.size(); i++) {
            allUsers.put(jsonContent.get(i).getEmail(), jsonContent.get(i));
        }

        return allUsers;
    }


    public String writeJson(HashMap<String, User> allUsers) {
        ArrayList<User> users = new ArrayList<>();
        for (User user : allUsers.values()) {
            users.add(user);
        }

        Gson gson = new Gson();
        String output = gson.toJson(users);
        return output;
    }

}
