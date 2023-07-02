package com.algonquin.chaletrentals.servlets;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.dao.UserDao;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao userDao = new UserDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user != null) {
			request.setAttribute("update_profile", true);			
		}
		request.getRequestDispatcher("WEB-INF/html/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephone = null;
		boolean isChaletOwner = false;
		String chaletowner = request.getParameter("isowner");
		System.out.println("checkbox:"+chaletowner);
		if(chaletowner != null) {
			isChaletOwner = true;
			telephone = request.getParameter("telephone");
		}
		User user = new User(username, password, email, isChaletOwner, telephone);
		//save to database
		boolean res = userDao.create(user);
		if(res) {
		//send a confirmation message to user's email		
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
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			msg.setSubject("Account creation confirmation - ChaletRentals");
			msg.setText("You have created an account with ChaletRentals successfully. ");
			Transport.send(msg);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/login");
		}else {
			request.setAttribute("message", "Email already exists!");
			request.setAttribute("status", "failed");
			request.getRequestDispatcher("WEB-INF/html/register.jsp").forward(request, response);
		}
	}

}
