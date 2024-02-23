package com.jspiders.ums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao 
{
   public static Connection getConnection()   //logic for create connections
   {   
	   Connection con=null;
	   try {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   String dburl="jdbc:mysql://localhost:3306/db?user=root&password=root";
	   con=DriverManager.getConnection(dburl);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	return con;
   }
   //logic for save the user details
   
   public static int save(user u)
   {
	   int count=0;
	   try {
	    Connection con=UserDao.getConnection();
	    
	    PreparedStatement psmt=con.prepareStatement("insert into user(name,password,email,country)values(?,?,?,?)");
	    psmt.setString(1,u.getName());      //getting name from user bean class to set name placeholder
	    psmt.setString(2,u.getPassword());  //getting password from user bean class to set password placeholder
	    psmt.setString(3,u.getEmail());     //getting email from user bean class to set email placeholder
	    psmt.setString(4,u.getCountry());   //getting country from user bean class to set country placeholder
	    count=psmt.executeUpdate();
	    con.close();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return count;
   }
   //logic for update the user details
   public static int update(user u) 
   {
	   int count=0;
	   try {
		   Connection con=UserDao.getConnection();
		   String query="update user set name=?,password=?,email=?,country=?where id=?";
		   PreparedStatement psmt=con.prepareStatement(query);
		   psmt.setString(1,u.getName());     //getting name from user bean class to set name placeholder
		   psmt.setString(2,u.getPassword()); //getting password from user bean class to set password placeholder 
		   psmt.setString(3,u.getEmail());    //getting email from user bean class to set email placeholder
		   psmt.setString(4,u.getCountry());  //getting country from user bean class to set country placeholder
		   psmt.setInt(5,u.getId());          //getting id and set id placeholder
		   count=psmt.executeUpdate();
		   con.close();
		}
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }   
	   return count;
   }
   //logic for delete the user
   public static int delete(int id) 
   {
	   int count=0;
	   try {
		   Connection con=UserDao.getConnection();
		   String query="delete from user where id=?";
		   PreparedStatement psmt=con.prepareStatement(query);
		   psmt.setInt(1,id);
		   count=psmt.executeUpdate();
		   con.close();
	      } 
	   catch (Exception e) {
	
		e.printStackTrace();
	}
	   return count;
   }
   //logic for read the data by using id
   public static user getUserById(int id) {
	   user u=new user();
	   try 
	   {
	   Connection con=UserDao.getConnection();
	   String query="select * from user where id=?";
	   PreparedStatement psmt=con.prepareStatement(query);
	   psmt.setInt(1, id);
	   ResultSet rs=psmt.executeQuery();
	   //read from rs
	   if(rs.next()) {
		   u.setId(rs.getInt(1));
		   u.setName(rs.getString(2));
		   u.setPassword(rs.getString(3));
		   u.setEmail(rs.getString(4));
		   u.setCountry(rs.getString(5));
	   }
	   con.close();
	   psmt.close();
	   rs.close();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return u;
	   
   }
   //logic for reading all the data
   public static List<user> getUsers()
   {
	   List<user> list=new ArrayList<user>(); //this homogeneous collection will store data present in user
	   try {
	   Connection con=UserDao.getConnection();
	   String query="select * from user";
	   PreparedStatement psmt=con.prepareStatement(query);
	   ResultSet rs=psmt.executeQuery();
	   while(rs.next()) {
		   user u=new user();
		   u.setId(rs.getInt(1));
		   u.setName(rs.getString(2));
		   u.setPassword(rs.getString(3));
		   u.setEmail(rs.getString(4));
		   u.setCountry(rs.getString(4));
		   list.add(u);
	      }
	     con.close();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return list;
   }
   
}
