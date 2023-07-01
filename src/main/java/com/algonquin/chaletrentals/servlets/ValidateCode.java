package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCode
 */
@WebServlet("/validate-code")
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCode() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int originalCode = (int) request.getSession().getAttribute("originalCode");
		if(code == originalCode) {
			request.setAttribute("email", request.getSession().getAttribute("email"));
			request.getRequestDispatcher("WEB-INF/html/reset_password.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Invalid code, please check it again.");
			request.setAttribute("status", "failed");
			request.getRequestDispatcher("WEB-INF/html/enter_code.jsp").forward(request, response);
		}
	}
}
