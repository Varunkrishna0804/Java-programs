package com.jspiders.ums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet
{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
  {
	  resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.print("<a href='index.html'> Add New User</a>");
	out.print("<h2> User List </h2>");
	
	List<user> list =UserDao.getUsers();
	
	out.print("<table border='1' width='100%'");
	out.print("<tr>"
			        +"<th>Id</th>"
			        + "<th>Name</th>"
			        + "<th>Password</th>"
			        + "<th>Email</th>"
			        + "<th>Country</th>"
			        +"<th>edit</th>"
			        + "<th>delete</th>"
			       +"</tr>");
	
	for(user u :list) {
		out.print("<tr>"
				   +"<td>"+u.getId()+"</td>"
				   +"<td>"+u.getName()+"</td>"
				   +"<td>"+u.getPassword()+"</td>"
				   +"<td>"+u.getEmail()+"</td>"
				   +"<td>"+u.getCountry()+"</td>"
				   +"<td>"
				      +"<a href='editservlet?id='"+u.getId()+">edit</a>"
				   +"</td>"
				   +"<td>"
				   +"<a href='deleteservlet?id='"+u.getId()+">delete</a>"
				   +"</td>"
				+"</tr>");
		
	}
	out.print("</table>");
	
	out.close();
   }
}

