package com.election.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;

@WebServlet("/delete")
public class DeleteCandidate extends HttpServlet {
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try(CandidateDao cd = new CandidateDaoImpl()) {
			int result = cd.deleteById(Integer.parseInt(req.getParameter("id")));
			 resp.sendRedirect("result");
		} catch (Exception e) {
			System.out.println("in Delete Candidate error");
		}
	}
}
