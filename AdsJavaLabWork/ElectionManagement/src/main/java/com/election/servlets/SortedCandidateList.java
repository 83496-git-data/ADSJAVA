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

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.pojos.Candidate;

@WebServlet("/list")
public class SortedCandidateList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try(CandidateDao cd = new CandidateDaoImpl()) {
    		List<Candidate> list = cd.findAllOrderByVotesDesc();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Announcement</title>");
			out.println("<style>");
			out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;}");
			out.println(".container {width: 80%; margin: 50px auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1);}");
			out.println("h1,h3 {text-align: center; color: #333;}");
			out.println("table {width: 100%; border-collapse: collapse; margin: 20px 0;}");
			out.println("table, th, td {border: 1px solid #ddd;}");
			out.println("th, td {padding: 8px; text-align: center;}");
			out.println("th {background-color: #f2f2f2;}");
			out.println("a {color: #4CAF50; text-decoration: none;}");
			out.println("a:hover {text-decoration: underline;}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class='container'>");
			ServletContext app = this.getServletContext();
			String appTitle = app.getInitParameter("AppTitle");
			out.printf("<h3>%s</h3>", appTitle);
			out.println("<h1>Candidate Winner Information</h1>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Votes</th>");
			out.println("<th>Name</th>");
			out.println("<th>Party</th>");
			out.println("</tr>");
			int count=0;
			for (Candidate candidate : list) {
				out.println("<tr>");
				out.println("<td>" + ++count + "</td>");
				out.println("<td>" + candidate.getVotes() + "</td>");
				out.println("<td>" + candidate.getName() + "</td>");
				out.println("<td>" + candidate.getParty() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<div style='text-align: center; margin-top: 20px;'>");
			out.println("<a href='result'>Admin Home</a> ");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
