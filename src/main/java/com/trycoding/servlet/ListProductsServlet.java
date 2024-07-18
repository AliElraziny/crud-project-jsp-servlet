package com.trycoding.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trycoding.repository.ProductDAO;


@WebServlet("/listProducts")
public class ListProductsServlet extends HttpServlet{

	
	    private static final long serialVersionUID = 1L;
	    private ProductDAO productDAO;
	    
	    @Override
	    public void init() {
	        productDAO = ProductDAO.getProductDAO();
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setAttribute("products", productDAO.getAllProducts());
	        request.getRequestDispatcher("listProducts.jsp").forward(request, response);
	    }
}
