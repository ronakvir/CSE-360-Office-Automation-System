package cse_360_group_project.Users;

public class Doctor extends User {

    public Doctor(String username, String password) {
        super(username, password);
    }

    @Override
    public String getDBPrefix() {
        return "doctor#";
    }

}
