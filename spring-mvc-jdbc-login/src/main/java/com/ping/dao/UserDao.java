package com.ping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ping.dto.UserDto;



@Repository
public class UserDao {
	
	@Autowired
	private DataSource dataSource;
	
	public UserDto getUserByUsernameAndPassword(String username, String password){
		System.out.println(username);
		Connection connection = null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db", "ping58972", "58972");
			
			connection = dataSource.getConnection();
			System.out.println(connection);
			PreparedStatement statement = connection.prepareStatement("select * from clinic_db.clinic_user where user_name = ? and pass_word = ?");
			//PreparedStatement statement = connection.prepareStatement("select * from clinic_user");
			statement.setString(1,  username);
			statement.setString(2,  password);
			ResultSet resultSet = statement.executeQuery();
			
			UserDto user = new UserDto();
			
			
			while(resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("pass_word"));
				
			}
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
