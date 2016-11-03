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
    private static Context context;

    public JsonService(Context context) {
        this.context = context;

        writeInternal();
//        write();
//        read();
    }

    private static final String PATH = "data/data/dragos.com.taskmanager/json.txt";


    public void writeFile(String string) {
        try {
            FileWriter file = new FileWriter(PATH);
            file.write(string);

            file.close();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    private void write() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/test.txt");
        try {
            file.createNewFile();
            FileOutputStream stream = new FileOutputStream(file);
            try {
                stream.write("text-to-write".getBytes());
            } finally {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("exists=" + file.exists());
    }

    private static void writeInternal() {
        String fileName = "MyFile";
        String content = "hello world";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/testt";
        File newFile = new File(path);
        FileOutputStream outputStream = null;
        try {
            outputStream = context.openFileOutput(newFile.getAbsolutePath(), Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/test.txt");
        int length = (int) file.length();

        byte[] bytes = new byte[length];

        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            try {
                in.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String contents = new String(bytes);
        System.out.println("read= " + contents);
    }

    public String readFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Reader fileReader = new FileReader(PATH);

            int data = fileReader.read();
            while (data != -1) {
                stringBuilder.append((char) data);

                data = fileReader.read();
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FUN " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public HashMap<String, User> readJson(String path) {
        Gson gson = new Gson();
        HashMap<String, User> allUsers = new HashMap<>();
        Type type = new TypeToken<ArrayList<User>>() {
        }.getType();
        ArrayList<User> jsonContent = gson.fromJson(path, type);
        for (int i = 0; i < jsonContent.size(); i++) {
            allUsers.put(jsonContent.get(i).getEmail(), jsonContent.get(i));
        }

        return allUsers;
    }


    public String writeJson(HashMap<String, User> allUsers) {
        ArrayList<User> users = new ArrayList<>();
        for (User user : allUsers.values()) {
            users.addAll(allUsers.values());
        }

        Gson gson = new Gson();
        String output = gson.toJson(users);
        return output;
    }

}
