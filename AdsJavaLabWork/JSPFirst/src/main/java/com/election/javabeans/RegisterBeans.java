package com.election.javabeans;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.election.dao.UserDao;
import com.election.dao.UserDaoImpl;
import com.election.pojos.User;

public class RegisterBeans {
	private String firstName, lastName, email, password, dob;

	public int registerUser() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int result = -1;
		try (UserDao ud = new UserDaoImpl()) {
			result = ud.save(new User(firstName,lastName,email,password,sdf.parse(dob), "voter"));
		} catch (Exception e) {
			System.out.println("in RegisterForm");
		}
		return result;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
