package com.jspiders.ums;

public class user 
{
   private int id;
   private String name;
   private String password;
   private String email;
   private String country;
@Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", country=" + country
			+ "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
}
