package com.election.dao;
import com.election.dao.CandidateDao;
import com.election.entity.Candidate;
import com.election.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.election.DbUtil.DBUtil;

public class CandidateDaoImpl implements CandidateDao, AutoCloseable {

	private Connection connection;
	private Candidate candidate;
	 public List<Candidate> findAll() {
	        List<Candidate> candidates = new ArrayList<>();
	            String sql = "SELECT * FROM candidates";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        int id = resultSet.getInt("id");
	                        String name = resultSet.getString("name");
	                        String party = resultSet.getString("party");
	                        int votes = resultSet.getInt("votes");
	                        Candidate candidate = new Candidate(id, name, party, votes);
	                        candidates.add(candidate);
	                    }
	                
	                }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return candidates;
	    }
	 
	 
	 public List<Candidate> findByParty(String party) {
	        List<Candidate> candidates = new ArrayList<>();
	            String sql = "SELECT * FROM candidates WHERE party = ?";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, party);
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        int id = resultSet.getInt("id");
	                        String name = resultSet.getString("name");
	                        int votes = resultSet.getInt("votes");
	                        Candidate candidate = new Candidate(id, name, party, votes);
	                        candidates.add(candidate);
	                    }
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return candidates;
	    }
	 
	 public List<Candidate> findAllOrderByVotesDesc() {
	        List<Candidate> candidates = new ArrayList<>();
	            String sql = "SELECT * FROM candidates ORDER BY votes DESC";
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        int id = resultSet.getInt("id");
	                        String name = resultSet.getString("name");
	                        String party = resultSet.getString("party");
	                        int votes = resultSet.getInt("votes");
	                        Candidate candidate = new Candidate(id, name, party, votes);
	                        candidates.add(candidate);
	                    }
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return candidates;
	    }
	
	@Override
	public void close() throws Exception {
		if(connection != null)	
			connection.close();		
	}

}
