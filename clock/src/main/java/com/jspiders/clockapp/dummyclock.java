package com.jspiders.clockapp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dummyclock extends HttpServlet
{
	@Override
    protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException 
    {
    	resp.setContentType("text/Html");
    	PrintWriter out=resp.getWriter();
    	Date date=new Date();
    	out.println("Welcome to Digital Clock");
    	out.println(date);
    	System.out.println("Welcome to Digital Clock");
    	System.out.println(date);
    	
    	
    	
    	//for refresh
    	resp.setHeader("refresh","1");
    }
    
    
}
