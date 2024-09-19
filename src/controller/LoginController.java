package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import helpers.connect;
import model.User;

public class LoginController {
	public User CheckLogin(String email,String password)  throws Exception{
		String sql ="SELECT email,password from users where email =? and password =?";
		try(
			Connection con = connect.connect();
			PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			
			try(
					ResultSet rs = pstmt.executeQuery();
					){
			if(rs.next()){
				User user = new User();
				user.setEmail(email);
				return user;
			}
		}
		}
		
		return null;
	}

}

