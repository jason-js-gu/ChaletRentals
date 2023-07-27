package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.dao.UserDao;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        userDao = new UserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	User user = (User)request.getSession().getAttribute("user");
    	if(user == null) {
    		response.sendRedirect("/login");
    	}else if(user.getEmail().equals("cst8288g10@gmail.com")){
			List<User> users = userDao.getAll();
			request.setAttribute("users", users);
			request.getRequestDispatcher("WEB-INF/html/users.jsp").forward(request, response);
    	}else {
    		response.sendRedirect("/");
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UUID userID = UUID.fromString(request.getParameter("userid"));
		boolean res = userDao.delete(userID);
		String message = null;
		String status = null;
		if(res) {
			message = "User deleted successfully.";
			status = "success";
			
		}else {
			message = "Something went wrong, please check your data.";
			status = "failed";
		}
		List<User> users = userDao.getAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/html/users.jsp").forward(request, response);
	}
}
