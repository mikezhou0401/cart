package dao;

import bean.Order;

import java.sql.*;

public class OrderDAO {
    public void insert(Order o) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
                    "root", "admin");
            String sql = "insert into order_ values (null,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, o.getUser().getId());
            ps.execute();

            ResultSet r = ps.getGeneratedKeys();
            if (r.next()) {
                int id = r.getInt(1);
                o.setId(id);
            }

            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
