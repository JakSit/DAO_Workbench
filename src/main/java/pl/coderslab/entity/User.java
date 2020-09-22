package pl.coderslab.entity;

public class User {

    private static int id;

    private static String userName;

    private static String email;

    private static String password;

    private void setId(int id) {
        this.id = id;
    }

    private int getId() {
        return id;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private String getUserName() {
        return userName;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private String getEmail() {
        return email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getPassword() {
        return password;
    }


}
