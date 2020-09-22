package pl.coderslab.dao_workbench;

import java.sql.*;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

    private static final String READ_USER_QUERY = "SELECT * FROM users";

    private static final String UPDATE_USER_QUERY = "UPDATE users SET (?) WHERE (?)";

    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE (?)";

    private void connection() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8", "root", "coderslab");
                PreparedStatement preStmt =
                        conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = preStmt.getGeneratedKeys();

            if (rs.next()) {
                long id = rs.getLong(1);
                System.out.println("Inserted ID: " + id);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));


        if (BCrypt.checkpw(candidate, hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");

        return BCrypt.hashpw(password, BCrypt.gensalt());

    }
}