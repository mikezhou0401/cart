package dao;

import bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    public Product getProduct(int id) {
        Product p = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
                    "root", "admin");
            String sql = "select * from product where id = ? ;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                p = new Product();
                p.setId(r.getInt("id"));
                p.setName(r.getString("name"));
                p.setPrice(r.getFloat("price"));
            }
            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }


    public List<Product> ListProduct() {
        List<Product> products = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
                    "root", "admin");
            String sql = "select * from product order by id desc;";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                Product p = new Product();
                p.setId(r.getInt("id"));
                p.setName(r.getString("name"));
                p.setPrice(r.getFloat("price"));
                products.add(p);
            }
            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


}

