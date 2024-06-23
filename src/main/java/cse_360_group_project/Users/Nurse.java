package cse_360_group_project.Users;

public class Nurse extends User {

    public Nurse(String username, String password) {
        super(username, password);
    }

    @Override
    public String getDBPrefix() {
        return "nurse#";
    }

}
