package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.dao.UserDao;
import com.election.dao.UserDaoImpl;
import com.election.pojos.User;

@WebServlet("/vote")
public class VoteServlets extends HttpServlet {
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println(user);
		String message = "";
		try(UserDao ud = new UserDaoImpl(); CandidateDao cd = new CandidateDaoImpl();) {
			if(!user.isStatus()) {
				int id = Integer.parseInt(req.getParameter("candidate"));
				cd.incrementVotes(id);
				ud.updateStatus(user.getId(), true);
				message = "Your vote is registered successfully. <br/><br/>";
			} else {
				message = "Your vote is already registered successfully. <br/><br/>";
			}
		} catch (Exception e) {
			System.out.println("in VoteServlets");
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("<style>");
		out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;}");
		out.println(".container {width: 80%; margin: 50px auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1); text-align: center;}");
		out.println("h1,h3 {color: #333;}");
		out.println("a {color: #4CAF50; text-decoration: none;}");
		out.println("a:hover {text-decoration: underline;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("AppTitle");
		out.printf("<h3>%s</h3>", appTitle);
		out.printf("Hello, %s<hr/>\n", user.getFirst_name());
		out.println(message);
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}

//package com.election.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.election.dao.CandidateDao;
//import com.election.dao.CandidateDaoImpl;
//import com.election.dao.UserDao;
//import com.election.dao.UserDaoImpl;
//import com.election.pojos.User;
//
//@WebServlet("/vote")
//public class VoteServlets extends HttpServlet {
//    
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		   
//		HttpSession session = req.getSession();
//		  User user = (User)session.getAttribute("user");
//	    System.out.println(user);
//	    String message = "";
//		try(UserDao ud = new UserDaoImpl(); CandidateDao cd = new CandidateDaoImpl();){
//			if(!user.isStatus()) {
//				int id = Integer.parseInt(req.getParameter("candidate"));
//				cd.incrementVotes(id);
//				ud.updateStatus(user.getId(), true);
//				message = "Your vote is registerd successfully. <br/><br/>";
//			}
//			else {
//				message = "Your vote is all ready registerd successfully. <br/><br/>";
//			}
//		} catch (Exception e) {
//			System.out.println("in VoteServlets");
//		}
//		
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Voted</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h3>Online Voting</h3>");
//		
//		out.printf("Hello, %s<hr/>\n", user.getFirst_name());
//		out.println(message);
//		out.println("<a href='logout'>Sign Out</a>");
//		out.println("</body>");
//		out.println("</html>");
//	}
//}
