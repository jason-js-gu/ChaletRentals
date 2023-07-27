package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.chaletrentals.beans.Reservation;
import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.beans.Chalet;
import com.algonquin.chaletrentals.dao.*;
/**
 * Servlet implementation class MyReservation
 */
@WebServlet("/reservation")
public class MyReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReservationDao reservationDao = new ReservationDao();  
    ChaletDao chaletDao = new ChaletDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
    	if(user == null) {
    		response.sendRedirect("/login");    		
    	}else {
    		List<Reservation> reservations = reservationDao.filterUser(user.getUserID());
    		List<Chalet> chalets = new ArrayList<>();
    		for(Reservation r: reservations) {
    			UUID chaletID = r.getChaletID();
    			Chalet chalet = chaletDao.select(chaletID);
    			chalets.add(chalet);
    		}
    		
    		List reservations_chalets = new ArrayList<>();
    		for(int i=0; i<reservations.size(); i++) {
    			Object[] temp = new Object[2];
    			temp[0] = reservations.get(i);
    			temp[1] = chalets.get(i);
    			reservations_chalets.add(temp);
    		}
    		
    		request.setAttribute("reservations_chalets", reservations_chalets);
    		
    		request.getRequestDispatcher("myreservation.jsp").forward(request, response);
    	}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
