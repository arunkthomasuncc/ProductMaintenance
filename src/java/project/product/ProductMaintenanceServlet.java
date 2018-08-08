/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.product;

//import com.sun.xml.internal.fastinfoset.stax.events.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import project.business.Product;
//import project.business.UserPass;
import project.data.DBUtil;
import project.data.ProductDB;
import project.data.ProductIO;
//import project.data.UserDB;

/**
 *
 * @author Arun
 */
public class ProductMaintenanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //code to handle add product , update product
        ServletContext sc = getServletContext();
        String action = req.getParameter("action");

        String url = "";
        String message = "";
        if (action.equals("Add Product")) {
            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
            double price = 0.0;
            String code = req.getParameter("code").trim();
            String description = req.getParameter("description").trim();
            String strPrice = req.getParameter("price");

            if (code == null || code.equals("")) {
                message = "Product Code can not be blank!!";
            } else if (description == null || description.equals("")) {
                message = "Description can not be blank!!";
            } else if (strPrice == null || strPrice.equals("")) {
                message = "Price can not be blank!!";
            } else if (ProductDB.productExists(code)) {
                message = "Code already exists";
            } else {
                try {
                    price = Double.parseDouble(strPrice);
                    Product product = new Product();
                    product.setCode(code);
                    product.setDescription(description);
                    product.setPrice(price);
                    ProductDB.insert(product);

                } catch (Exception e) {
                    message = "Please enter valid price. For example:  12.50";
                }
            }
            //set the product object
            //check product code exists or not. If its exist set a message and return to create page
            //if its not exist, then call insertProduct
            if (message.length() > 0) {
                req.setAttribute("code", code);
                req.setAttribute("description", description);
                req.setAttribute("price", strPrice);

                url = "/addProduct.jsp";
                req.setAttribute("message", message);
            } else {
                List<Product> products = ProductDB.selectProducts();
                req.setAttribute("products", products);
                url = "/displayProducts.jsp";
            }

        } else if (action.equals("Update Product")) {
            //set the product object
            //check product code exists or not. If its exist set a message and return to edit page
            //if its not exist, then call insertProduct
            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
            String strProductId = req.getParameter("productId");
            String oldCode = req.getParameter("oldCode").trim();
            String code = req.getParameter("code").trim();
            String description = req.getParameter("description").trim();
            String strPrice = req.getParameter("price");

            if (code == null || code.equals("")) {
                message = "Product Code can not be blank!!";
            } else if (description == null || description.equals("")) {
                message = "Description can not be blank!!";
            } else if (strPrice == null || strPrice.equals("")) {
                message = "Price can not be blank!!";
            } else {
                try {
                    Product product = new Product();

                    product.setProductId(Long.parseLong(strProductId));
                    product.setDescription(description);
                    product.setPrice(Double.parseDouble(strPrice));
                    //we have set productID, description and price above 
                    //and we would set the product code based on different scenarios

                    if (oldCode.equals(code)) {
                        product.setCode(oldCode);  //set old code into product object
                        ProductDB.update(product);
                        List<Product> products = ProductDB.selectProducts();
                        req.setAttribute("products", products);
                        url = "/displayProducts.jsp";
                    } else { //old product code and new product code are different. So we need to check if the new product code already exists in the system or not.
                        boolean isExists = ProductDB.productExists(code);
                        if (isExists) {
                            message = "The Product Code already Exist. Please enter a different product code";
                        } else { //if new product code does not exists, go ahead and update the details
                            product.setCode(code);   //New Code
                            ProductDB.update(product);
                            List<Product> products = ProductDB.selectProducts();
                            req.setAttribute("products", products);
                            url = "/displayProducts.jsp";
                        }

                    }
                } catch (Exception e) {

                    //strProductId
                    message = "Please enter valid price. For example:  12.50";
                }

            }
            if (message.length() > 0) {
                req.setAttribute("productId", strProductId);
                req.setAttribute("oldCode", oldCode);
                req.setAttribute("code", code);
                req.setAttribute("description", description);
                req.setAttribute("price", strPrice);
                url = "/editProduct.jsp";
            }

        } else if (action.equals("View Products")) {

            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
            List<Product> products = ProductDB.selectProducts();
            req.setAttribute("products", products);
            url = "/displayProducts.jsp";

        } else if (action.equals("Yes")) {
            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
            String strProductId = req.getParameter("productId");
            Long productId = Long.parseLong(strProductId);
            ProductDB.delete(productId);
            List<Product> products = ProductDB.selectProducts();
            req.setAttribute("products", products);
            url = "/displayProducts.jsp";
        

    }

    else if (action.equals ( 
        "No")) {
                        /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
            List<Product> products = ProductDB.selectProducts();
            req.setAttribute("products", products);
            url = "/displayProducts.jsp";
        
    }

    /*
        else if (action.equals ( 
        "Login")) {

            String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserPass userPass = UserDB.selectUser(username, password);
        if (userPass == null) {
            //go to login page
            url = "/login.jsp";
            message = "Incorrect Username or Password!!";

        } else {
            //check role
            if (UserDB.checkUserRole(userPass.getUserId())) {
                HttpSession session = req.getSession();
                session.setAttribute("username", userPass.getUsername());
                session.setAttribute("isRoleAuthenticated", true);
                List<Product> products = ProductDB.selectProducts();
                req.setAttribute("products", products);
                url = "/displayProducts.jsp";

            } else {
                url = "/login.jsp";
                message = "User is valid but you dont have Programmer and Customer Service role to perform the action";

            }

        }
    }*/

    req.setAttribute (

    "message", message);
    sc.getRequestDispatcher (url)

.forward(req, resp);

    }

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Hello");
        ServletContext sc = getServletContext();
        // String filePath=sc.getRealPath("/WEB-INF/products.txt");
        String action = "";
        String url = "";
        String message = "";
        //used from doPost method
        if (action.equals("")) {
            action = "displayProducts";
        }

        action = req.getParameter("action");
        //  ProductIO.init(filePath);
        if (action.equals("displayProducts")) {
            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
                List<Product> products = ProductDB.selectProducts();
                req.setAttribute("products", products);
                url = "/displayProducts.jsp";
            
        } else if (action.equals("editProduct")) {
            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
                String code = req.getParameter("code");
                Product p = ProductDB.selectProductUsingCode(code);
                //req.setAttribute("product", p);
                req.setAttribute("productId", p.getProductId());
                req.setAttribute("code", p.getCode());
                req.setAttribute("oldCode", p.getCode());
                req.setAttribute("description", p.getDescription());
                req.setAttribute("price", p.getPrice());
                url = "/editProduct.jsp";
            
        } else if (action.equals("deleteProduct")) {
            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
                String code = req.getParameter("code");
                Product p = ProductDB.selectProductUsingCode(code);
                //req.setAttribute("product", p);
                req.setAttribute("productId", p.getProductId());
                req.setAttribute("code", p.getCode());
                req.setAttribute("description", p.getDescription());
                req.setAttribute("price", p.getPrice());
                url = "/deleteProduct.jsp";
            
        } else if (action.equals("addProduct")) {
            /*if (!validateuser(req, resp)) {
                url = "/login.jsp";
                message = "Please login first";
            } else {*/
                url = "/addProduct.jsp";
            
        }
        req.setAttribute("message", message);
        sc.getRequestDispatcher(url)
                .forward(req, resp);
    }

    /*
    public boolean validateuser(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();

        if (session.getAttribute("username") != null && (boolean) session.getAttribute("isRoleAuthenticated") == true) {
            return true;
        }
        return false;
    }
*/
}
