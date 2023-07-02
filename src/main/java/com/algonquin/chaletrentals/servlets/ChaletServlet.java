package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.chaletrentals.dao.ChaletDao;

/**
 * Servlet implementation class ChaletServlet
 */
@WebServlet("/home")
public class ChaletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChaletDao chaletDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaletServlet() {
        chaletDao = new ChaletDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/html/home.jsp").forward(request, response);
	}

}
