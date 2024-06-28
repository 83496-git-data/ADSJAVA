package com.election.javabeans;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.dao.UserDao;
import com.election.dao.UserDaoImpl;
import com.election.pojos.User;

public class VotesBeans {
	private int id;
	private int userId;
	private boolean flag=false ;

	public void giveVote() {
		try(UserDao ud = new UserDaoImpl();CandidateDao cd = new CandidateDaoImpl();) {
			 User u = ud.findById(userId);
			 if(!u.isStatus()) { 
					  cd.incrementVotes(id);
					  flag = true;
					  ud.updateStatus(userId, flag);
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
