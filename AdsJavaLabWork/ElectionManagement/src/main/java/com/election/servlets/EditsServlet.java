package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.pojos.Candidate;

@WebServlet("/edit")
public class EditsServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try(CandidateDao cd = new CandidateDaoImpl();) {
			  cd.update(new Candidate(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),req.getParameter("party") , Integer.parseInt(req.getParameter("votes"))));
			  resp.sendRedirect("result"); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try(CandidateDao cd = new CandidateDaoImpl()) {
            Candidate candidate = cd.findById(Integer.parseInt(req.getParameter("id")));
            resp.setContentType("text/html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit Candidate</title>");
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;}");
            out.println(".container {width: 50%; margin: 50px auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1);}");
            out.println("h1,h3 {text-align: center; color: #333;}");
            out.println("form {display: flex; flex-direction: column;}");
            out.println("label {margin-top: 10px;}");
            out.println("input[type='text'] {padding: 10px; margin-top: 5px;}");
            out.println("input[type='submit'] {padding: 10px; margin-top: 20px; background-color: #4CAF50; color: white; border: none; cursor: pointer;}");
            out.println("input[type='submit']:hover {background-color: #45a049;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            ServletContext app = this.getServletContext();
			String appTitle = app.getInitParameter("AppTitle");
			out.printf("<h3>%s</h3>", appTitle);
            out.println("<h1>Edit Candidate</h1>");
            out.println("<form method='post' action='edit'>");
            out.printf("<label for='id'>Id:</label> <input type='text' name='id' value='%d' readonly/><br/>\n", candidate.getId());
            out.printf("<label for='name'>Name:</label> <input type='text' name='name' value='%s'/><br/>\n", candidate.getName());
            out.printf("<label for='party'>Party:</label> <input type='text' name='party' value='%s'/><br/>\n", candidate.getParty());
            out.printf("<label for='votes'>Votes:</label> <input type='text' name='votes' value='%d' readonly/><br/>\n", candidate.getVotes());
            out.println("<input type='submit' value='Update Candidate'/>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println("EditServlet error!!");
        } 
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
//
//import com.election.dao.CandidateDao;
//import com.election.dao.CandidateDaoImpl;
//import com.election.pojos.Candidate;
//
//@WebServlet("/edit")
//public class EditsServlet extends HttpServlet {
//  @Override
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	  PrintWriter out = resp.getWriter();
//	  try(CandidateDao cd = new CandidateDaoImpl()) {
//		  	Candidate candidate = cd.findById(Integer.parseInt(req.getParameter("id")));
//		  	resp.setContentType("text/html");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>Edit Candidate</title>");
//			out.println("</head>");
//			out.println("<body>");
//			
////			ServletContext app = this.getServletContext();
////			String appTitle = app.getInitParameter("AppTitle");
////			out.printf("<h3>%s</h3>", appTitle);
//
//			out.println("<form method='post' action='editcand'>");
//			out.printf("Id: <input type='text' name='id' value='%d' readonly/><br/><br/>\n", candidate.getId());
//			//out.printf("<input type='hidden' name='id' value='%d'/>\n", candidate.getId());
//			out.printf("Name: <input type='text' name='name' value='%s'/><br/><br/>\n", candidate.getName());
//			out.printf("Party: <input type='text' name='party' value='%s'/><br/><br/>\n", candidate.getParty());
//			out.printf("Votes: <input type='text' name='votes' value='%d' readonly/><br/><br/>\n", candidate.getVotes());
//			out.println("<input type='submit' value='Update Candidate'/>");
//			out.println("</form>");
//			out.println("</body>");
//			out.println("</html>");
//	  }
//	 catch (Exception e) {
//		System.out.println("EditServlet error!!");
//	} 
//}   
//}
