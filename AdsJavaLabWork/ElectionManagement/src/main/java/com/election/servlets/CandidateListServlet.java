package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.pojos.Candidate;
import com.election.pojos.User;

@WebServlet("/candidateList")
public class CandidateListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(CandidateDao cd = new CandidateDaoImpl();) {
			List<Candidate> list = cd.findAll();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("user");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Candidates</title>");
			out.println("<style>");
			out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;}");
			out.println(".container {width: 80%; margin: 0 auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1);}");
			out.println("h3 {color: #333;}");
			out.println(".candidate {padding: 10px 0;}");
			out.println(".candidate input {margin-right: 10px;}");
			out.println("form {margin-top: 20px;}");
			out.println("input[type='submit'] {background-color: #4CAF50; color: white; border: none; padding: 10px 20px; text-decoration: none; cursor: pointer;}");
			out.println("input[type='submit']:hover {background-color: #45a049;}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class='container'>");
			ServletContext app = this.getServletContext();
			String appTitle = app.getInitParameter("AppTitle");
			out.printf("<h3>%s</h3>", appTitle);
			//out.println("<h3>Online Voting</h3>");
			out.printf("<h3> Name Of Voter is %s </h3>", user.getFirst_name());
			String message = (String) app.getAttribute("announcement");
			if(message.length() !=0)
				out.printf("Announcement: %s<br/><br/>\n", message);
			out.println("<form method='post' action='vote'>");
			for (Candidate c : list) {
				out.printf("<div class='candidate'><input type='radio' name='candidate' value='%d'/> %s (%s)</div>\n", 
						c.getId(), c.getName(), c.getParty());
			}
			out.println("<input type='submit' value='Vote'/>");
			out.println("</form>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			System.out.println("error in candidate list servlets");
		}
	}
}

//package com.election.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
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
//import com.election.pojos.Candidate;
//import com.election.pojos.User;
//
//@WebServlet("/candidateList")
//public class CandidateListServlet extends HttpServlet{
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try(CandidateDao cd = new CandidateDaoImpl();) {
//			  List<Candidate> list = cd.findAll();
//			  resp.setContentType("text/html");
//			  PrintWriter out = resp.getWriter();
//			  HttpSession session = req.getSession();
//			  User user = (User)session.getAttribute("user");
//			  out.println("<html>");
//				out.println("<head>");
//				out.println("<title>Candidates</title>");
//				out.println("</head>");
//				out.println("<body>");
//				out.println("<h3>Online Voting</h3>");
//				out.printf("<h3> Name Of Voter is %s </h3>", user.getFirst_name());
//				out.println("<form method='post' action='vote'>");
//				for (Candidate c : list) {
//					out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n", 
//							c.getId(), c.getName(), c.getParty());
//				}
//				out.println("<input type='submit' value='Vote'/>");
//				out.println("</form>");
//				out.println("</body>");
//				out.println("</html>");
//			 
//		} catch (Exception e) {
//			System.out.println("error in candidate list servlets");
//		}
//	}
//}
