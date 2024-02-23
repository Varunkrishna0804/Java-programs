package com.jspiders.ums;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editservlet")
public class editservlet extends HttpServlet
{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.print("<h2> update the user </h2>");
	String sid=req.getParameter("id");
	int id=Integer.parseInt(sid);
	
	user u=UserDao.getUserById(id);
	out.print("<form action='editservlet2' method='post'>");
	out.print("<table>");
	
	out.print("<tr>"
            +"<td>Id :</td>"
            + "<td>"
            + "<input type='hidden' name='id'"+ u.getId()+"/>"
            +"</td>"
            +"</tr>");
	
	out.print("<tr>"
		            +"<td>Name :</td>"
		            + "<td>"
		            + "<input type='text' name='name'"+ u.getName()+"/>"
		            +"</td>"
		            +"</tr>");
	
	out.print("<tr>"
            +"<td>Password :</td>"
            + "<td>"
            + "<input type='password' name='password'"+ u.getPassword()+"/>"
            +"</td>"
            +"</tr>");
	
	out.print("<tr>"
            +"<td>Email :</td>"
            + "<td>"
            + "<input type='email' name='email'"+ u.getEmail()+"/>"
            +"</td>"
            +"</tr>");
	
	out.print("<tr>"
            +"<td>Country :</td><td>+\"<select name=\"country\" style=\"width:150px\">\"\r\n"
            + "            +\"<option>India</option>\"\r\n"
            + "            +\"<option>Australia</option>\"\r\n"
            + "            +\"<option>NewZealand</option>\"\r\n"
            + "            +\"<option>south Africa</option>\"\r\n"
            +"             +\"<option>others</option>\"\r\n"
            + "            +\"</select>\"</td>"
            +"</tr>");
	
	out.print("<tr>"
			        +"<td colspan='2'>"
			        +"<input type='submit' value='edit & save'/>"
			        +"</td>"
			         +"</tr>" );
	out.print("</table>");
	out.print("</form>");
	
	
	
	
	
	
	
	
	
	
   } 
}
