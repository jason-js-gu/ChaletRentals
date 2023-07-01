package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.algonquin.chaletrentals.dao.UserDao;
/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/new-password")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao userDao = new UserDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPassword() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("password");		
		String email = request.getParameter("email");
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
