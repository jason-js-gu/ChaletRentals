package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.chaletrentals.beans.Chalet;
import com.algonquin.chaletrentals.dao.ChaletDao;

/**
 * Servlet implementation class ChaletServlet
 */
@WebServlet("")
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
		List<Chalet> list_chalets = chaletDao.getAll();
		
		List<Chalet> heros = new ArrayList<Chalet>();
		List<Chalet> chalets = new ArrayList<Chalet>();
		for(int i=0; i<list_chalets.size(); i++) {
			if(i < 3) {
				heros.add(list_chalets.get(i));
			}else {
				chalets.add(list_chalets.get(i));
			}
		}
		
		request.setAttribute("heros", heros);
		request.setAttribute("chalets", chalets);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
