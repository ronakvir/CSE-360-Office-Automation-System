package cse_360_group_project;

import java.util.HashMap;

public class UserMockDB {

    HashMap<String, String> login = new HashMap<String, String>();

    public void testPut(String username, String password) {
        login.put(username, password);
    }

    public void testGet(String username) {
        System.out.println(login.get(username));
    }
}
