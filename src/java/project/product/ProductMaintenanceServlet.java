/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.product;

import com.sun.xml.internal.fastinfoset.stax.events.Util;
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
import project.data.ProductIO;

/**
 *
 * @author Arun
 */
public class ProductMaintenanceServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //code to handle add product , update product
        ServletContext sc = getServletContext();
        String action= req.getParameter("action");
        
        String url= "";
        if(action.equals("Add Product"))
        {
           String message="";
           double price=0.0;
           String code=req.getParameter("code").trim();
           String description=req.getParameter("description").trim();
            String strPrice=req.getParameter("price");
           if(code==null || code.equals("") ||description==null || description.equals("")||strPrice==null ||strPrice.equals("") )
               message="Please fill all the fields";
         
          
           if(strPrice!=null && !(strPrice.equals("")))
  
               price= Double.parseDouble(strPrice);
           
           if(message.length()==0&& ProductIO.exists(code))
           {
               message="Code already exists";
               
           }
           else
           {
               if(!(message.length()>0))
               {
               Product product = new Product();
               product.setCode(code);
               product.setDescription(description);
               product.setPrice(price);
               ProductIO.insertProduct(product);
               List<Product> products=ProductIO.selectProducts();
               req.setAttribute("products", products);
               }
               
           }
            //set the product object
            //check product code exists or not. If its exist set a message and return to create page
            //if its not exist, then call insertProduct
               if(message.length()>0)
               {
                  url="/addProduct.jsp";
                  req.setAttribute("message",message);
               }
               else
                   
                url="/displayProducts.jsp";
        }
        else if(action.equals("editProduct"))
        {
            //set the product object
            //check product code exists or not. If its exist set a message and return to edit page
            //if its not exist, then call insertProduct
        }
        else if(action.equals("deleteProduct"))
        {
            //read the product code
            //delete the product method is not avaialable
        }
        else if(action.equals("View Products"))
        {
            List<Product> products=ProductIO.selectProducts();
            req.setAttribute("products", products);
            url="/displayProducts.jsp";
            
        }
        
        sc.getRequestDispatcher(url).forward(req, resp);
         
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Hello");
        ServletContext sc = getServletContext();
        String filePath=sc.getRealPath("/WEB-INF/products.txt");
        String action= "";
        String url= "";
        //used from doPost method
        if(action.equals(""))
            action="displayProducts";
        
        action= req.getParameter("action");
        ProductIO.init(filePath);
        if(action.equals("displayProducts"))
        {
            List<Product> products=ProductIO.selectProducts();
            req.setAttribute("products", products);
            url="/displayProducts.jsp";
        }
        else if(action.equals("editPrdocut"))
        {
            //url="editProduct.jsp";
        }
        else if(action.equals("deleteProduct"))
        {
            //url="deleteProduct.jsp";
        }
        else if(action.equals("addProduct"))
        {
            url="/addProduct.jsp";
        }
        
        sc.getRequestDispatcher(url)
                .forward(req, resp);
    }
    
}
