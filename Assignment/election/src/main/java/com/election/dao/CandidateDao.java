package com.election.dao;

public class CandidateDao {

	private int id;
	private String name;
	private String party;
	private int votes;
	
	
	
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



	@Override
	public String toString() {
		return "CandidateDao [id=" + id + ", name=" + name + ", party=" + party + ", votes=" + votes + "]";
	}
	
}
