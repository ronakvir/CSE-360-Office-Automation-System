package cse_360_group_project;

import cse_360_group_project.Users.Patient;

import java.io.*;
import java.util.HashMap;
import static cse_360_group_project.Constants.*;

public class UserMockDB {


    public void testPut(String username, String password) throws IOException {
        File file = new File(DB_PATH + "/" + username + ".txt");
        Patient p1 = new Patient("ronak", "mypassword");
        System.out.println(p1.getUsername());
        System.out.println(p1.getPassword());
        p1.setPassword("RAaah");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(p1);
        oos.close();
    }

    public void testGet(String username) throws IOException, ClassNotFoundException {
        File file = new File(DB_PATH + "/" + username + ".txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Patient p1 = (Patient)ois.readObject();
        ois.close();

        System.out.println(p1.getUsername());
        System.out.println(p1.getPassword());
    }
}
