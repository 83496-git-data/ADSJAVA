package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet({"/login", "/canlist"})
//@WebServlet("/*")
public class LoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("Loggingfilter.init() called");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("LoggingFilter.destroy() called");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) req;
		System.out.println("Log BEFOR: " + rq.getRequestURI());
		chain.doFilter(rq, resp);
		System.out.println("LOG AFTER: " +rq.getRequestURI());
	}

}
