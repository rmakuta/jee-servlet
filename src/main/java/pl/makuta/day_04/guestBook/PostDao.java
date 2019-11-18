package pl.makuta.day_04.guestBook;

import java.sql.*;
import java.util.Arrays;

public class PostDao {
    private final String URL = "jdbc:mysql://localhost:3306/guest_book?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
//    private final String USER = "root";
//    private final String PASSWORD = "coderslab";

    private static final String CREATE_POST_QUERY = "INSERT INTO posts(title, description) VALUES (?, ?)";
    private static final String FIND_ALL_POSTS_QUERY = "SELECT * FROM posts";

    public Post create(Post post, String USER, String PASSWORD) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        }
//        catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_POST_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                post.setId(resultSet.getInt(1));
            }
            return post;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Post[] findAll(String USER, String PASSWORD) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Post[] posts = new Post[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_POSTS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setDescription(resultSet.getString("description"));
                posts = addToArray(post, posts);
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace(); return null;
        }
    }

    private Post[] addToArray(Post p, Post[] posts) {
        Post[] tmpPosts = Arrays.copyOf(posts, posts.length + 1);
        tmpPosts[posts.length] = p;
        return tmpPosts;
    }
}
