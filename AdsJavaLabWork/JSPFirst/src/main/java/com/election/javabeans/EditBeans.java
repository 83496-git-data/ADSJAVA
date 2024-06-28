package com.election.javabeans;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.pojos.Candidate;

public class EditBeans {
	private int id;
	private String name,party;
	private int votes;
	
	private int count;
   private Candidate candidate;

   public void fetchCandidate() {
	   try(CandidateDao cd = new CandidateDaoImpl()) {
		     candidate = cd.findById(id);
	} catch (Exception e) {
		// TODO: handle exception
	}
   }
   
   public void updateCandidate() {
	   try(CandidateDao cd = new CandidateDaoImpl()) {
		   candidate = new Candidate(id, name, party, votes);
		    count = cd.update(candidate);
	} catch (Exception e) {
		// TODO: handle exception
	}
 }
   
   
   
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getParty() {
	return party;
}

public void setParty(String party) {
	this.party = party;
}

public int getVotes() {
	return votes;
}

public void setVotes(int votes) {
	this.votes = votes;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Candidate getCandidate() {
	return candidate;
}

public void setCandidate(Candidate candidate) {
	this.candidate = candidate;
}
   
   
}
