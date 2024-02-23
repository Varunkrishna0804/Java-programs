package com.jspiders.ums;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class editservlet2 extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	  resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();
	  
	  //query string
	  String sid=req.getParameter("id");
	  int id=Integer.parseInt(sid);
	  
	  String name=req.getParameter("name");
	  String password=req.getParameter("password");
	  String email=req.getParameter("email");
	  String country=req.getParameter("country");
	  
	  user u=new user();
	  u.setId(id);
	  u.setName(name);
	  u.setPassword(password);
	  u.setEmail(email);
	  u.setCountry(country);
	  int count=UserDao.update(u);
	  if(count>0) {
		  resp.sendRedirect("ViewServlet");
	  }
	  else {
		  out.print("<h3> Sorry unable to update the record </h3>");
	  }
	  out.close();
	  
	  
   }
}
