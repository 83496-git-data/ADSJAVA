package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.dao.UserDao;
import com.election.dao.UserDaoImpl;
import com.election.pojos.User;

public class RegisterForm extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int result = 0;
		try (UserDao ud = new UserDaoImpl()) {
			result = ud.save(new User(req.getParameter("fname"), req.getParameter("lname"), req.getParameter("email"),
					req.getParameter("password"), sdf.parse(req.getParameter("dob")), "voter"));
		} catch (Exception e) {
			System.out.println("in RegisterForm");
		}
		if (result > 0) {
			resp.setContentType("text/html");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Register</title>");
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
			out.println("<h1>Register Successful</h1>");
			out.println("<p>Registration is done!!</p>");
			out.println("<br/><br/>");
			out.println("<a href='index.html'>Login</a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}

//package com.election.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.election.dao.UserDao;
//import com.election.dao.UserDaoImpl;
//import com.election.pojos.User;
//
//public class RegisterForm extends HttpServlet {
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter out = resp.getWriter();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		int result = 0;
//		try (UserDao ud = new UserDaoImpl()) {
//			result = ud.save(new User(req.getParameter("fname"), req.getParameter("lname"), req.getParameter("email"),
//					req.getParameter("password"), sdf.parse(req.getParameter("dob")), "voter"));
//		} catch (Exception e) {
//			System.out.println("in RegisterForm");
//		}
//		if (result > 0) {
//			resp.setContentType("text/html");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>Register</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("Register is done!!. <br/><br/>");
//			out.println("<a href='index.html'>Login</a>");
//			out.println("</body>");
//			out.println("</html>");
//		}
//	}
//}
