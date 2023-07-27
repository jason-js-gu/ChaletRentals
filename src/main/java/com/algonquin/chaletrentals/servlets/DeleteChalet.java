package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.algonquin.chaletrentals.dao.ChaletDao;
/**
 * Servlet implementation class DeleteChalet
 */
@WebServlet("/DeleteChalet")
public class DeleteChalet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChaletDao chaletDao = new ChaletDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteChalet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UUID chaletID = UUID.fromString(request.getParameter("chaletID")) ;
		if(chaletID != null) {
			boolean res = chaletDao.delete(chaletID);
			if(res) {
				response.sendRedirect("/");				
			}
		}		
	}
}
