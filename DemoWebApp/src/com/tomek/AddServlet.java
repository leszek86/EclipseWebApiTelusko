package com.tomek;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		//TODO - find out how getParameter method works
		//in this example it identifies parameters based on name attribute
		//how can we get parameters based on e.g id ?
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int result = i + j;
		res.getWriter().println("Result is: " + result);
		System.out.println("The result is: " + result);
	}
	
	public void doGetWithDispatcher(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		//TODO - find out how getParameter method works
		//in this example it identifies parameters based on name attribute
		//how can we get parameters based on e.g id ?
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int sum = i + j; 
		
//		res.getWriter().println("Numbers are: " + i + " and " + j);
		
		// we are adding attribute to the same Request because with Dispatcher we are using the same Request and Response Objects
		// later we are just forwarding them to different Servlet (Sq) which will reuse them
		req.setAttribute("sum", sum);
		
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, res);
	}
	
	public void doGetWithSession(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		//TODO - find out how getParameter method works
		//in this example it identifies parameters based on name attribute
		//how can we get parameters based on e.g id ?
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int sum = i + j; 
		
		HttpSession session = req.getSession();
		session.setAttribute("sum", sum);
		
		
		res.sendRedirect("sq");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int sum = i + j; 
		
		Cookie cookie = new Cookie("sum", String.valueOf(sum));
		res.addCookie(cookie);
		
		
		res.sendRedirect("sq");
	}
}
