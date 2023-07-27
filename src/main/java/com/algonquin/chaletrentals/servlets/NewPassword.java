package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.algonquin.chaletrentals.dao.UserDao;
import com.algonquin.chaletrentals.beans.User;
/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/new-password")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPassword() {
        userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	User user = (User)request.getSession().getAttribute("user");
    	if(user == null) {
    		response.sendRedirect("/login");
    	}else {
    		response.sendRedirect("/");
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("pwd");		
		String email = (String)request.getSession().getAttribute("email");
		System.out.println("session-email:"+email);
		try {
			userDao.update(email, pwd);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		request.setAttribute("message", "Password reset successfully, please use your new password to login.");
		request.setAttribute("status", "success");
		request.getRequestDispatcher("WEB-INF/html/login.jsp").forward(request, response);
	}
	
}
