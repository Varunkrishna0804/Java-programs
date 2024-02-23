package com.jspiders.ums;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/saveservlet")
public class saveservlet extends HttpServlet
{
  @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	//query string
	String name=req.getParameter("name");
	String password=req.getParameter("password");
	String email=req.getParameter("email");
	String country=req.getParameter("country");
	
	user u=new user();
	u.setName(name);
	u.setPassword(password);
	u.setEmail(email);
	u.setCountry(country);
	int count=UserDao.save(u);
	if(count>0) {
		out.print("<h3> Record saved successfull </h3>");
		req.getRequestDispatcher("index.html").include(req, resp);
	   }
	else {
		out.print("sorry,unable to save the records");
	    }
	out.close();
	}
}
