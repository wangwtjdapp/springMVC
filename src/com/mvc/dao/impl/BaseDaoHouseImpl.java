package com.mvc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.dao.BaseDaoHouse;
import com.mvc.until.TcUser;
import com.mvc.until.Tcplrck;


@Repository
public class BaseDaoHouseImpl implements BaseDaoHouse{
	
	private static String url="jdbc:sqlserver://172.18.130.132:1433;DatabaseName=kcgl8-2";
	private static String username="sa";
	private static String password="911126";
	private static Connection conn;
	private static Statement stmt;
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Tcplrck> getTcList() {
		String sql="select top 500 * from tcplrck";
//		String sql="select * from tcplrck";
		List<Tcplrck> tcList = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			tcList = new ArrayList<Tcplrck>();
			while(rs.next()){
				Tcplrck tc = new Tcplrck();
				tc.setId(rs.getInt("id"));
				tc.setCz1(rs.getString("cz1"));
				tc.setCz2(rs.getString("cz2"));
				tc.setGg(rs.getString("gg"));
				tc.setDw(rs.getString("dw"));
				tc.setGcd(rs.getString("gcd"));
				tc.setDj(rs.getInt("dj"));
				tc.setRq(rs.getString("rq"));
				tc.setCrkz(rs.getInt("crkz"));
				tc.setJbr(rs.getString("jbr"));
				tc.setClbj(rs.getString("clbj"));
				
				tcList.add(tc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tcList;
	}


	@Override
	public List<TcUser> getTcUsers() {
		String sql="select * from users";
		List<TcUser> tc_users = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			tc_users = new ArrayList<TcUser>();
			while(rs.next()){
				TcUser tcUser = new TcUser();
				tcUser.setUno(rs.getString("uno").trim());
				tcUser.setUserName(rs.getString("uname").trim());
				tcUser.setPassWord(rs.getString("upassword").trim());
				tcUser.setUclass(rs.getString("uclass").trim());
				
				tc_users.add(tcUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tc_users;
	}

}
