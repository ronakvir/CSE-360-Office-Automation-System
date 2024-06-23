package cse_360_group_project.Lib;

import cse_360_group_project.Users.User;

import java.io.*;

import static cse_360_group_project.Lib.Constants.*;

public class UserMockDB {


    public static boolean write(User user) {
        try {
            File file = new File(DB_PATH + "/" + user.getDBPrefix() + user.getUsername() + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(user);
            oos.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static User read(String prefix, String username) {
        try {
            File file = new File(DB_PATH + "/" + prefix + username + ".txt");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            User user = (User) ois.readObject();
            ois.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // there's definitely a better way to do this

    public static String isAlreadyUser(String username) {
        for (String prefix : DB_PREFIXES) {
            try {
                File file = new File(DB_PATH + "/" + prefix + username + ".txt");
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

                ois.close();
                return prefix;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
