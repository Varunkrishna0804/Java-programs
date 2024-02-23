package com.jspiders.storyapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mystory extends HttpServlet  
{
      protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException
       {
    	   resp.setContentType("text/Html");
    	   PrintWriter out=resp.getWriter();
    	   
    	   out.println("After flying a long distance, a thirsty crow wandered the forest searching for water.\r\n"
    	   		+ "     Finally, he saw a pot half-filled with water.\r\n"
    	   		+ "      He tried to drink from it, but his beak wasn’t long enough to reach the water inside.\r\n"
    	   		+ "       He then saw pebbles on the ground, and one by one, he put them in the pot until the water rose to the brim.\r\n"
    	   		+ "        The crow then hastily drank from it and quenched his thirst.");
    	   
    	   
       }
}
