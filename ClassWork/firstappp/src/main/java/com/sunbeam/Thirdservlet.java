package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class Thirdservlet extends HttpServlet{
	private String color= "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Third Servlet init() Called");
		color = config.getInitParameter("color");
	}
	
	@Override
	public void destroy() {
		System.out.println("Third Servlet init() Called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		System.out.println("Third Servlet init() Called");
		processrequest(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("Third Servlet init() Called");
	processrequest(req, resp);
	
	}
	
	protected void processrequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("head");
		out.println("<title>Third</title>");
		out.printf("<body bgcolor='%s'>\n", color);
		out.println("<h1>Hello, ThirdServlet</h1>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		
		}
		
	
	

}
