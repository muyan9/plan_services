package com.zcy.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zcy.common.Base64;

/**
 * @author zcy
 * webservice for any sql to execute
 */
public class db_opration {
	private static Connection dbconn;
	
	static {
		String strDriver = null;
		String strURL = null;
		String strUserName = null;
		String strPassword = null;

		try {
			strDriver 	= "com.mysql.jdbc.Driver";
			strURL 		= "jdbc:mysql://127.0.0.1:3306/geo";
			strUserName = "root";
			strPassword = "///123";
			
			// 载入数据库驱动
			Class.forName(strDriver);

			dbconn = DriverManager.getConnection(strURL, strUserName, strPassword);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ResultSet getResultSet(String sql) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = dbconn.createStatement();
			//ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
			rs = stmt.executeQuery(Base64.decode(sql));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
	
	public int ExecuteSQL(String sql) throws SQLException {
		Statement stmt = null;
		stmt = dbconn.createStatement();
		return stmt.executeUpdate(Base64.decode(sql));
	}
	
//	public static void main(String[] args) throws SQLException {
//		db_opration db = new db_opration();
//		db.ExecuteSQL(Base64.encode("insert into geo_record(lat, lng) values(1,1)"));
//	}
}
