package dao;

import bean.User;

import java.sql.*;

public class UserDAO {


    public User getUser(String name, String password) {
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
                    "root", "admin");
            String sql = "select * from user where name = ? and password = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet s = ps.executeQuery();
            while (s.next()) {
                user.setId(s.getInt(1));
                user.setName(s.getString("name"));
                user.setPassword(s.getString("password"));
            }
            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
