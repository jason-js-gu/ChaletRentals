package com.algonquin.chaletrentals.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.algonquin.chaletrentals.beans.User;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import com.algonquin.chaletrentals.beans.Chalet;
import com.algonquin.chaletrentals.dao.ChaletDao;

@MultipartConfig
@WebServlet("/add_chalet")
public class AddChaletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChaletDao chaletDao = new ChaletDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChaletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		String id = request.getParameter("chaletID");
		UUID chaletID = null;
		if(id != null) {
			chaletID = UUID.fromString(id);
		}
    	if(user == null) {
    		response.sendRedirect("/login");    		
    	} else if(chaletID != null) {
    		Chalet chalet = chaletDao.select(chaletID);
    		request.setAttribute("chalet", chalet);
    		request.setAttribute("update_chalet", true);
    		request.getRequestDispatcher("add_chalet.jsp").forward(request, response);
    	} else {
    		request.getRequestDispatcher("add_chalet.jsp").forward(request, response);
    	}    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve user
		User user = (User)request.getSession().getAttribute("user");
		
		//handle photos
		String uploadPath = getServletContext().getRealPath("") + File.separator + "img";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
		    uploadDir.mkdir();
		}
		List<String> photo_urls = new ArrayList<String>();
		for(Part part: request.getParts()) {
			String filename = part.getSubmittedFileName();
			if(filename != null) {
				//for deployment
				String img_deployment_path = uploadPath + File.separator + part.getSubmittedFileName();
				
				//for local testing
				String img_path = "C:\\Users\\Jason\\ChaletRentals\\src\\main\\webapp\\img"
									+ File.separator + part.getSubmittedFileName();
				//get list of photo-names
				photo_urls.add(part.getSubmittedFileName());
				//save the photo to the server
				part.write(img_path);
			}
		}
		//handle other attributes
		String id = request.getParameter("chaletid");
		UUID chaletID = null;
		if(id != null) {
			chaletID = UUID.fromString(id) ;
		}
		
		String name = request.getParameter("chaletname");
		System.out.println("chaletname:"+name);
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		double price = Double.valueOf(request.getParameter("price"));
		
		Chalet chalet = null;
		String chalet_message = "";
		boolean chalet_status = false;
		boolean update_chalet = false;
		UUID userID = user.getUserID();
		
		if(chaletID == null) {
			chalet = new Chalet(name, address, description, photo_urls, price, userID);
			boolean res_creation = chaletDao.create(chalet);			

			if(res_creation) {
				chalet_message = "Add a new chalet successfully.";
				chalet_status = true;
				List<Chalet> chalets = chaletDao.getAll();
				request.setAttribute("chalet_message", chalet_message);
				request.setAttribute("chalet_status", chalet_status);
				request.setAttribute("chalet_userID", userID);
				request.setAttribute("chalets", chalets);
				response.sendRedirect("/"); 
			}else {
				chalet_message = "Something went wrong, please try again.";				
				request.setAttribute("chalet_message", chalet_message);
				request.setAttribute("chalet_status", chalet_status);
				response.sendRedirect("add_chalet");
			}
		}else if(chaletID != null && user != null) {
			chalet = new Chalet(chaletID, name, address, description, photo_urls, price, userID);
			boolean res_update = chaletDao.update(chalet);
			if(res_update) {
				chalet_message = "Update the chalet successfully.";
				chalet_status = true;
				List<Chalet> chalets = chaletDao.getAll();
				request.setAttribute("chalet_message", chalet_message);
				request.setAttribute("chalet_status", chalet_status);
				request.setAttribute("chalet_userID", userID);
				request.setAttribute("chalets", chalets);
				response.sendRedirect("/"); 
			}else {
				chalet_message = "Something went wrong, please try again.";
				update_chalet = true;
				request.setAttribute("chalet_message", chalet_message);
				request.setAttribute("chalet_status", chalet_status);				
				chalet = chaletDao.select(chaletID);
				response.sendRedirect("add_chalet");
			}
		}
	}
}
