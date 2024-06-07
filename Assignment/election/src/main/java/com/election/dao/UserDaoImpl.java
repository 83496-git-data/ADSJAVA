package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.election.DbUtil.DBUtil;
import com.election.entity.Users;


public class UserDaoImpl implements UserDao, AutoCloseable {
	private Connection connection;
	private Users user;
	private static final String INSERT_CANDIDATE_SQL = "INSERT INTO USERS(fisrt_name, last_name, email, password, dob, status, role) VALUES (?,?,?,?,?,?,?)";
	
	public UserDaoImpl() {
		connection = DBUtil.getConnection();
	}
		@Override
		public void addUser(Users users) {
			try (PreparedStatement PreparedStatement = connection.prepareStatement(INSERT_CANDIDATE_SQL)){
			PreparedStatement.setString(1, users.getFirstName());
			PreparedStatement.setString(2, users.getLastName());
			PreparedStatement.setString(3, users.getEmail());
			PreparedStatement.setString(4, users.getPassword());
			PreparedStatement.setString(5, users.getDob());
			PreparedStatement.setString(6, users.getStatus());
			PreparedStatement.setString(7, users.getRole());
			PreparedStatement.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
			
	boolean UserLogin(String email,String password) throws SQLException{
		String SELECT_BY_EMAIL_AND_PASSWORD = "select * from users";
		List<Users> userList = new ArrayList<Users>();
		(PreparedStatement stmt = connection.prepareStatement(SELECT_BY_EMAIL_AND_PASSWORD)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Users u = new Users();
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setDob(rs.getString(6));
				u.setStatus(rs.getString(7));
				u.setRole(rs.getString(8));
				userList.add(u);
			}
				for(Users users : userList) {
					if(users.getEmail().equals(email) && users.getPassword().equals(password)) {
						return true;
					}
				}
			}
			return false;
		}
	
	public Users findUsersByEmail(String email, String password){
	        Users users = null;
	        String SELECT_SELLER_BY_EMAIL = "select email,password from users";
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SELLER_BY_EMAIL)) {
	            
	        	preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String firstname = resultSet.getString("firstname");
	                String lastname = resultSet.getString("lastname");
	                String dob = resultSet.getString("dob");
	                String status = resultSet.getString("status");
	                String role = resultSet.getString("role");
	                user = new Users(id, firstname, lastname, dob, status, role);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	
	public Users findUsersId(String email, String password){
	        Users users = null;
	        String SELECT_SELLER_BY_ID = "select id from users";
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SELLER_BY_ID)){
	            
	        	preparedStatement.setString(1, id);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String firstname = resultSet.getString("firstname");
	                String lastname = resultSet.getString("lastname");
	                String email = resultSet.getString("email");
		            String password = resultSet.getString("password");
	                String dob = resultSet.getString("dob");
	                String status = resultSet.getString("status");
	                String role = resultSet.getString("role");
	                user = new Users(id, firstname, lastname, email, password dob, status, role);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
	
	@Override
	public void save(Users users){
        try (PreparedStatement PreparedStatement = connection.prepareStatement(INSERT_CANDIDATE_SQL)){
            		PreparedStatement.setString(1, users.getFirstName());
        			PreparedStatement.setString(2, users.getLastName());
        			PreparedStatement.setString(3, users.getEmail());
        			PreparedStatement.setString(4, users.getPassword());
        			PreparedStatement.setString(5, users.getDob());
        			PreparedStatement.setString(6, users.getStatus());
        			PreparedStatement.setString(7, users.getRole());
        			PreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
	
	
	 public void updateStatus(int userId, String newStatus) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE users SET status = ? WHERE id = ?");
	            statement.setString(1, newStatus);
	            statement.setInt(2, userId);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	 
	    public void updatePassword(int userId, String newPassword) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ? WHERE id = ?");
	            statement.setString(1, newPassword);
	            statement.setInt(2, userId);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public void deleteById(int userId) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
	            statement.setInt(1, userId);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void update(Users user) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE users SET firstName = ?, lastName = ?, email = ?, password = ?, dob = ?, status = ?, role = ? WHERE id = ?");
	            statement.setString(1, user.getFirstName());
	            statement.setString(2, user.getLastName());
	            statement.setString(3, user.getEmail());
	            statement.setString(4, user.getPassword());
	            statement.setString(5, user.getDob());
	            statement.setString(6, user.getStatus());
	            statement.setString(7, user.getRole());
	            statement.setInt(8, user.getId());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
		@Override
		public void close() throws Exception {
			if(connection != null)	
				connection.close();
		}
		@Override
		public Users findByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}

}
