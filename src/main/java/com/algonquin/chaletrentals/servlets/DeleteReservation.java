package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.algonquin.chaletrentals.beans.Reservation;
import com.algonquin.chaletrentals.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteReservation
 */
@WebServlet("/delete_reservation")
public class DeleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReservationDao reservationDao = new ReservationDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UUID rid = UUID.fromString(request.getParameter("id"));
		boolean res = reservationDao.delete(rid);
		String message = "";
		String status = "failed";
		if(res) {
			message = "Your reservation has been cancled.";
			status = "success";			
		}else {
			message = "Something went wrong, please try again.";
		}
		request.setAttribute("message", message);
		request.setAttribute("status", status);
		response.sendRedirect("/reservation");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
