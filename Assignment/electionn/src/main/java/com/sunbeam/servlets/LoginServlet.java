package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
		
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("eamil");
		String passwd = req.getParameter("passwd");
		
		try (UserDao userDao = new UserDaoImpl()){
			User user = (User) userDao.findByEmail(email);
			if(user != null && user.getPassword().equals(passwd)){
				
				//login successfull
				
				System.out.println("Login Successful:" +user);
				if(user.getRole().equals("voter")) {
					resp.sendRedirect("canlist");
					
//					RequestDispatcher rd = req.getRequestDispatcher("canlist");
//					rd.forward(req, resp);
				}
				else {
					resp.sendRedirect("result");
				}
			}
			else{
				//login failed
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("<body>");
				out.printf("Invalid email or password. <br/> <br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</head>");
				out.println("</html>");
			}
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}