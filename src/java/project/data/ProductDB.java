package project.data;

import java.sql.*;
import java.util.ArrayList;

import project.business.Product;

public class ProductDB {

    public static int insert(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Product (code, description, price) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE Product SET "
                + "code = ?, "
                + "description = ?,"
                + "price=?"  
                + "WHERE productId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setLong(4, product.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM Product "
                + "WHERE productId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, product.getId());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean productExists(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT code FROM Product "
                + "WHERE code = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Product selectProduct(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE code = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            Product product = null;
            if (rs.next()) {
                product = new Product();
                product.setId((long)rs.getInt("productId"));
                product.setCode(rs.getString("code"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
            }
            return product;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Product> selectProducts() {
        // add code that returns an ArrayList<Product> object of all products in the Product table
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Product> productList = new ArrayList<Product>();
            while (rs.next()) {
                Product product = new Product();
                product.setId((long)rs.getInt("productId"));
                product.setCode(rs.getString("code"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }    
}