package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class VoteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String candidateId = req.getParameter("candidate");
		int id = Integer.parseInt(candidateId);
		try(CandidateDao canDao = new CandidateDaoImpl()){
			canDao.incrementVote(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voted</title>");
		out.println("<body>");
		out.println("Your vote is registred successfully. <br/> <br/>");
		out.println("<a href='lagout'>Sign Out</a>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");

	}
}
