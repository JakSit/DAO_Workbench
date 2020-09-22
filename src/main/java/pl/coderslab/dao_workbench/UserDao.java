package pl.coderslab.dao_workbench;

import pl.coderslab.entity.User;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id=(?)";

    private static final String UPDATE_USER_QUERY = "UPDATE users SET (?) WHERE (?)";

    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE (?)";

    public String hashPassword(String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        if (BCrypt.checkpw(candidate, hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User create(User user) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, User.getUserName());
            statement.setString(2, User.getEmail());
            statement.setString(3, hashPassword(User.getPassword()));
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int userId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(READ_USER_QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, User.getId());
            statement.executeQuery();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                User.setId(resultSet.getInt(1));
            }
            return User;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(User user) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(UPDATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(int userId) {}

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }

}