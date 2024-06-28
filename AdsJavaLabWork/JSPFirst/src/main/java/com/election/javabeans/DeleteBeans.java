package com.election.javabeans;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;

public class DeleteBeans {
 private int id;
 
 public int deleteCandidate() {
	 try(CandidateDao cd = new CandidateDaoImpl()) {
		  return cd.deleteById(id);
	} catch (Exception e) {
		// TODO: handle exception
	}
	 return -1;
 }
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
 
 
}
