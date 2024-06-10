package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;



import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

import com.sunbeam.pojos.Candidate;


public class CandidateBeans {
      private List <Candidate> list;
      
      public List<Candidate> getList(){
    	  return list;
      }

	public void candidateList(){
	  list = new ArrayList<Candidate>();
	try (CandidateDao candDao = new CandidateDaoImpl()){
		list=candDao.findAll();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
}
