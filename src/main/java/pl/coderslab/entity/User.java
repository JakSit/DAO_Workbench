package pl.coderslab.entity;

public class User {

    private int id;

    private String userName;

    private String email;

    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getPassword() {
        return password;
    }


}
