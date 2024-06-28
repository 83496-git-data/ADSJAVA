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

import com.election.pojos.User;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("<style>");
		out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;}");
		out.println(".container {width: 80%; margin: 50px auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1); text-align: center;}");
		out.println("h1 {color: #333;}");
		out.println("a {color: #4CAF50; text-decoration: none;}");
		out.println("a:hover {text-decoration: underline;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("AppTitle");
		out.printf("<h3>%s</h3>", appTitle);
		out.printf("<h1>Goodbye, %s</h1><hr/>\n", user.getFirst_name());
		session.invalidate();
		out.println("<p>Thank you.</p>");
		out.println("<br/><br/>");
		out.println("<a href='index.html'>Login Again</a>");
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
//import com.election.pojos.User;
//
//@WebServlet("/logout")
//public class LogOutServlet extends HttpServlet {
// 
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		HttpSession session = req.getSession();
//		  User user = (User)session.getAttribute("user");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Logout</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.printf("Goodbye, %s<hr/>\n", user.getFirst_name());
//		session.invalidate();
//		
//		out.println("Thank you. <br/><br/>");
//		out.println("<a href='index.html'>Login Again</a>");
//		out.println("</body>");
//		out.println("</html>");
//	}
//}
