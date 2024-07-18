package com.trycoding.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trycoding.model.Product;
import com.trycoding.repository.ProductDAO;



@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet{
	
	 private static final long serialVersionUID = 1L;
	    private ProductDAO productDAO;

	    public void init() {
	        productDAO = ProductDAO.getProductDAO();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Product product = productDAO.getProduct(id);
	        request.setAttribute("product", product);
	        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        double price = Double.parseDouble(request.getParameter("price"));

	        Product product = new Product(id, name, price);
	        productDAO.updateProduct(product);

	        response.sendRedirect("listProducts");
	    }

}

