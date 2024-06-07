package com.election.dao;

import com.election.entity.Users;

import java.sql.SQLException;

import com.election.dao.UserDaoImpl;

public interface UserDao {
	void addUser(Users user);
	Users findByEmail(String email);
	void save(Users users);

}
