package pl.makuta.day_04;

import java.sql.*;

public class UserDao {
    private final String URL = "jdbc:mysql://localhost:3306/newsletter?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "coderslab";

    private static final String CREATE_USER_QUERY = "INSERT INTO users(email, name) VALUES (?, ?)";

    public User create(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
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
}
