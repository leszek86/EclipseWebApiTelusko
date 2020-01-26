package com.tomek;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		//TODO - find out how getParameter method works
		//in this example it identifies parameters based on name attribute
		//how can we get parameters based on e.g id ?
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		res.getWriter().println("Numbers are: " + i + " and " + j);
	}
}
