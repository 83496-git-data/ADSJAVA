package com.sunbeam.servlets;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/announce")
public class AnnoucementServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	processReq(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		processReq(req, resp);
	}
	
	protected void processReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = req.getParameter("ann");
		
		ServletContext ctx = this.getServletContext();
		ctx.setAttribute("announcement", message);
		resp.sendRedirect("result");
		
	}
}
