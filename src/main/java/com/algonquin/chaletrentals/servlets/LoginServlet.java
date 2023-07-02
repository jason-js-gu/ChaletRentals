package com.algonquin.chaletrentals.servlets;
import com.algonquin.chaletrentals.dao.UserDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.chaletrentals.beans.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
    	if(user == null) {
    		request.getRequestDispatcher("WEB-INF/html/login.jsp").forward(request, response);   		
    	}else{
    		response.sendRedirect("/home"); 
    	}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user = userDao.select(email, password);
		String message = null;
		String status = "failed";
		if(user == null) {
			message = "Invalid email or password, please try again.";
			request.setAttribute("message", message);
			request.setAttribute("status", status);
			response.sendRedirect("/login");
		}else {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/home");
		}		
	}
}
