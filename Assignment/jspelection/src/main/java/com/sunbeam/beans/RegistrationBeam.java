package com.sunbeam.beans;

import java.util.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBeam {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String date;
	private String Role="voter";
	private int status=0;
	private User user;
	
	
	public RegistrationBeam() {
		
	}


	


	public String getFirstname() {
		return firstname;
	}





	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}





	public String getLastname() {
		return lastname;
	}





	public void setLastname(String lastname) {
		this.lastname = lastname;
	}





	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public void newRegister() {
		try (UserDao userDao = new UserDaoImpl()){
			 user = new User();
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setEmail(email);
			user.setPassword(password);
			user.setStatus(status);
			user.setRole(Role);
			user.setBirth(java.sql.Date.valueOf(date));
			int saved = userDao.save(user);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
