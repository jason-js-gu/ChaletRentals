package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.chaletrentals.beans.Chalet;
import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.beans.Reservation;
import com.algonquin.chaletrentals.dao.ChaletDao;
import com.algonquin.chaletrentals.dao.ReservationDao;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/booking")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChaletDao chaletDao = new ChaletDao(); 
    ReservationDao rDao = new ReservationDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
    	if(user == null) {
    		response.sendRedirect("/login");    		
    	}else {
			String id = request.getParameter("id");
			UUID reservationID = null;
			Reservation reservation = null;
			Chalet chalet = null;
			if(id != null) {
				reservationID = UUID.fromString(id);
				reservation = rDao.select(reservationID);
				UUID chaletID = reservation.getChaletID();
				chalet = chaletDao.select(chaletID);
			}else {
	    		UUID chaletID = UUID.fromString(request.getParameter("chaletID"));				
				if(chaletID != null) {
					chalet = chaletDao.select(chaletID);
				}
			}
			request.setAttribute("chalet", chalet);
						
			if(reservation != null) {
				request.setAttribute("reservation", reservation);
			}
			request.getRequestDispatcher("reservation.jsp").forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UUID chaletID = UUID.fromString(request.getParameter("chaletid"));
			double totalPrice = Double.valueOf(request.getParameter("totalprice"));
			User user = (User)request.getSession().getAttribute("user");
			Chalet chalet = chaletDao.select(chaletID);
			Instant checkin = Instant.parse(request.getParameter("checkin") + ":00.000Z");
			Instant checkout = Instant.parse(request.getParameter("checkout") + ":00.000Z");
			
			Reservation newReservation = null;
			List<Reservation> reservations = null;
					
			
			String message = "";			
			String status = "failed";
			
			String reservationid = request.getParameter("reservationid");
			UUID reservationID = null;
			if(reservationid != null) {
				reservationID = UUID.fromString(reservationid);
				newReservation = new Reservation(reservationID, checkin, checkout,totalPrice,user.getUserID(),chaletID);
				reservations = rDao.getAll(reservationID);				
			}else {
				newReservation = new Reservation(checkin, checkout,totalPrice,user.getUserID(),chaletID);
				reservations = rDao.filterChalet(chaletID); 
			}
			
			chalet.setReservations(reservations);
			boolean isAvailable = chalet.isAvailable(newReservation);
			
			if(reservationid != null && isAvailable) {
				boolean res = rDao.update(newReservation);
				if(!res) {
					message = "Something went wrong, please try again!";					
				}else {
					message = "The chalet was updated successfully";
					status = "success";
				}
				request.setAttribute("chalet", chalet);
				request.setAttribute("message", message);
				request.setAttribute("status", status);
				request.getRequestDispatcher("reservation.jsp").forward(request, response);
			}else if(isAvailable) {
				boolean res = rDao.create(newReservation);
				if(!res) {
					message = "Something went wrong, please try again!";					
				}else {
					message = "The chalet was booked successfully";
					status = "success";
				}
				request.setAttribute("chalet", chalet);
				request.setAttribute("message", message);
				request.setAttribute("status", status);
				request.getRequestDispatcher("reservation.jsp").forward(request, response);
			}else {
				message = "The chalet is not available during the period you have chosen.";
				request.setAttribute("chalet", chalet);
				request.setAttribute("message", message);
				request.setAttribute("status", status);
				if(reservationid != null) {
					request.setAttribute("reservation", rDao.select(reservationID));
				}
				request.getRequestDispatcher("reservation.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
