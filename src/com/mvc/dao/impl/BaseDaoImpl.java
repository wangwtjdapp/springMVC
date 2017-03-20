package com.mvc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.dao.BaseDao;
import com.mvc.until.User;

@Repository
public class BaseDaoImpl implements BaseDao{

//	private static String url="jdbc:mysql://localhost:3306/db_search";
//	private static String username="root";
//	private static String password="123456";
//	private static Connection conn;
//	private static Statement stmt;
//	static{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public List<User> getUserList() {
//		String sql="select * from t_user";
//		List<User> userList = null;
//		try {
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql.toString());
//			userList = new ArrayList<User>();
//			while(rs.next()){
//				User user = new User();
//				user.setId(rs.getInt("id"));
//				user.setUserName(rs.getString("userName"));
//				user.setPassword(rs.getString("password"));
//				
//				userList.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return userList;
		return null;
	}

}
