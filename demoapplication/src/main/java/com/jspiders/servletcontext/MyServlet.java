package com.jspiders.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/super")
public class MyServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
	    resp.setContentType("text/Html");
	    PrintWriter out=resp.getWriter();	 
	    ServletContext context=req.getServletContext();
	    String name=context.getInitParameter("movie");
	    out.print("<h2> Movie Name is : "+name+" </h2>");
	    String hero=context.getInitParameter("hero");
	    out.print("<h2> Hero Name is : "+hero+" </h2>");
	    String heroine=context.getInitParameter("heroine");
	    out.print("<h2> Heroine Name is : "+heroine+" </h2>");
    }
}
