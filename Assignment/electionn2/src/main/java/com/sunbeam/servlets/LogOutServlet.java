package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processReq(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processReq(req, resp);
	
	}
	
	protected void processReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("<body>");
		
		//header name change
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("AppTitle");
		out.printf("<h3>%s</h3>", appTitle);
		
		out.println("<center>");
		
		String userName ="";
		Cookie[] arr= req.getCookies();
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"));
						userName= c.getValue();
						break;
			}
		}
		out.printf("Goodbye, %s<hr/>\n", userName);
		
		Cookie c = new Cookie("uname","");
		c.setMaxAge(-1);
		resp.addCookie(c);
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		out.println("Thank You saving democracy. <br/> <br/>");
		out.println("<a href='index.html'>Login Again</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}
}
