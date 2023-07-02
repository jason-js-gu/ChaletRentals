package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.Random;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.dao.UserDao;
/**
 * Servlet implementation class PwdRecoveryServlet
 */
@WebServlet("/reset-password")
public class PwdRecoveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdRecoveryServlet() {
    	userDao = new UserDao(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	User user = (User)request.getSession().getAttribute("user");
    	if(user != null) {
    		response.sendRedirect("/home");
    	}else {
    		request.getRequestDispatcher("WEB-INF/html/pwd_recovery.jsp").forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		User user = null;
		int code = 0;
		String status = "failed";
		HttpSession httpSession = request.getSession();
		String email = request.getParameter("email");
		if(email != null || !email.equals("")) {
			user = userDao.select(email);			
		}		

		if(email == null || user == null) {
			message = "Invalid email, please try again.";
			request.setAttribute("message", message);
			request.setAttribute("status", status);
			response.sendRedirect("/reset-password");
		}else {	
			//send code
			Random rand = new Random();
			code = rand.nextInt(1255650);
			String mailTo = email;
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("cst8288g10@gmail.com","hdhqvszzxlcnrtdj");
				}
			});
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(email));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
				msg.setSubject("Code for resetting your password - ChaletRentals");
				msg.setText("Your code for resetting your password is: " + code);
				Transport.send(msg);
			}catch(MessagingException e) {
				e.printStackTrace();
			}
			httpSession.setAttribute("originalCode", code);
			httpSession.setAttribute("email", email);
			request.getRequestDispatcher("WEB-INF/html/pwd_recovery_code.jsp").forward(request, response);
		}
	}
}
