package com.election.dao;

import java.util.List;

public interface CandidateDao {
	    List<Candidate> findAll();
	    List<Candidate> findByParty(String party);

}
