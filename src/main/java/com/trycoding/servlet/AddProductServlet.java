package com.trycoding.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trycoding.model.Product;
import com.trycoding.repository.ProductDAO;



@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = ProductDAO.getProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        productDAO.addProduct(product);

        response.sendRedirect("listProducts");
    }
	
	

}
