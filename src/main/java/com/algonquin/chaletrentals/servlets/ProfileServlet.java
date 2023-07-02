package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.dao.UserDao;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
    	if(user == null) {
    		response.sendRedirect("/login");    		
    	}else {
    		request.getRequestDispatcher("WEB-INF/html/profile.jsp").forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UUID userID = UUID.fromString(request.getParameter("userid"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephone = null;
		boolean isChaletOwner = false;
		String chaletowner = request.getParameter("isowner");		
		if(chaletowner != null) {
			isChaletOwner = true;
			telephone = request.getParameter("telephone");
		}
		User nuser = new User(userID, username, password, email, isChaletOwner, telephone);
		//save to database
		boolean res = userDao.update(nuser);
		String message = null;
		String status = null;
		if(res) {
			//delete previous user saved in the session
			request.getSession().removeAttribute("user"); 
			message = "Profile updated successfully.";
			status = "success";
			request.setAttribute("message", message);
			request.setAttribute("status", status);
			//put new user into session
			request.getSession().setAttribute("user", nuser);
			request.getRequestDispatcher("WEB-INF/html/profile.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Email already exists!");
			request.setAttribute("status", "failed");
			request.setAttribute("update_profile", true);
			request.getRequestDispatcher("WEB-INF/html/register.jsp").forward(request, response);
		}
	}

}
