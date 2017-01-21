/**
 * 
 */
package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.model.UserBean;

/**
 * @author PREET
 *
 */
public class UserDAO {

	Connection con;

	public UserDAO() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/PREET","root","password");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int deleteUser(String id) {
		int x = 0;
		try{
			PreparedStatement ps = con.prepareStatement("delete from user2 where UserName=?");
			ps.setString(1, id);
			x = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public int insertUser(UserBean user) {
		int x = 0;
		try{
			PreparedStatement ps = con.prepareStatement("insert into user2 values(?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			x = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public int updateUser( UserBean user  ) {
		int x = 0;
		try {
			String query = "update user2 set UserName=?, Password=? where UserName=?";
			PreparedStatement preparedStatement = con.prepareStatement( query );
			preparedStatement.setString( 1, user.getUsername());
			preparedStatement.setString( 2, user.getPassword() );
			preparedStatement.setString( 3, user.getOldUsername() );
			
			x = preparedStatement.executeUpdate();
		
			preparedStatement.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return x;
	
	}
}
