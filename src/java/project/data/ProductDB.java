package project.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import project.business.Product;

public class ProductDB {

 /*   public static int insert(Product product) {
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
    }*/
    
     public static void insert(Product product) {
         
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
     
    }
    

    public static void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Long productId) {
        
        Product product= selectProductUsingId(productId);
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static boolean productExists(String code) {
        Product product = selectProductUsingCode(code);   
        return product != null;
    }
    public static Product selectProductUsingCode(String code) {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Product u " +
                "WHERE u.code = :code";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("code", code);
        try {
            Product product = q.getSingleResult();
            return product;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Product selectProductUsingId(Long productId) {
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Product u " +
                "WHERE u.productId = :productId";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("productId", productId);
        try {
            Product product = q.getSingleResult();
            return product;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
  /*  public static ArrayList<Product> selectProducts() {
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
                product.setProductId((long)rs.getInt("productId"));
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
          //  DBUtil.closeResultSet(rs);
          //  DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }   
*/
    public static List<Product> selectProducts() {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Product u ";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        try {
            List<Product> products = q.getResultList();
            return products;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
        
        
    }
    
    
}