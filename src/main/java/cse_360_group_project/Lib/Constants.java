package cse_360_group_project.Lib;

public final class Constants {
    private Constants() {}
    public static final double X_AXIS = 500;
    public static final double Y_AXIS = 700;
    public static final String DB_PATH = "src/main/java/cse_360_group_project/database";
    public static final String USER_DB_PATH = DB_PATH + "/users";
    public static final String MESSAGES_DB_PATH = DB_PATH + "/messages";
    public static final String APPOINTMENTS_DB_PATH = DB_PATH + "/appointments";
    public static final String[] DB_PREFIXES = {"patient#", "nurse#", "doctor#"};

}
