package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.election.dao.UserDao;
import com.election.dao.UserDaoImpl;
import com.election.pojos.User;

public class LoginServlets extends HttpServlet {
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try(UserDao userdao = new UserDaoImpl();) {
			User user = userdao.findByEmail(email);
			
			if (user != null && user.getPassword().equals(password) && user.getRole().equals("admin")) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect("result");
			} else if (user != null && user.getPassword().equals(password) && user.getRole().equals("voter")) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect("candidateList");
			} else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
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
				out.println("<h1>Login Failed</h1>");
				out.println("Invalid email or password. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}

//package com.election.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.election.dao.UserDao;
//import com.election.dao.UserDaoImpl;
//import com.election.pojos.User;
//
//public class LoginServlets extends HttpServlet {
// 
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		
//		try(UserDao userdao = new UserDaoImpl();) {
//			   User user= userdao.findByEmail(email);
//			   
//			   if(user != null && user.getPassword().equals(password) && user.getRole().equals("admin"))
//			   {
//				   HttpSession session = req.getSession();
//					session.setAttribute("user", user);
//				   resp.sendRedirect("resultservlet");
//			   }
//			   else if(user != null && user.getPassword().equals(password) && user.getRole().equals("voter"))
//			   {
//				   HttpSession session = req.getSession();
//					session.setAttribute("user", user);
//				   resp.sendRedirect("candidateList");
//			   }
//			   else
//			   {
//				   resp.setContentType("text/html");
//					PrintWriter out = resp.getWriter();
//					out.println("<html>");
//					out.println("<head>");
//					out.println("<title>Login Failed</title>");
//					out.println("</head>");
//					out.println("<body>");
//					out.println("Invalid email or password. <br/><br/>");
//					out.println("<a href='index.html'>Login Again</a>");
//					out.println("</body>");
//					out.println("</html>");
//			   }
//		} catch (Exception e) {
//			throw new ServletException(e);
//		}
//	}
//}
