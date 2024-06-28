package com.election.javabeans;

import java.util.ArrayList;
import java.util.List;

import com.election.dao.CandidateDao;
import com.election.dao.CandidateDaoImpl;
import com.election.pojos.Candidate;

public class CandidateList {
    private List<Candidate> candidateList;

    
    public CandidateList() {
    	  candidateList = new ArrayList<Candidate>();
    }
    
    public void fetchCandidateList() {
    	try(CandidateDao cd = new CandidateDaoImpl();) {
			  this.candidateList = cd.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public List<Candidate> getCandidateList() {
		return candidateList;
	}
    
}
