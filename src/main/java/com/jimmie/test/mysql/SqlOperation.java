package com.jimmie.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

import com.jimmie.test.utils.DatabaseUtils;

public class SqlOperation {

	private static final String DBDRIVER = "com.mysql.jdbc.Driver"; // 驱动类类名
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/oms_book";// 连接URL
	private static final String DBUSER = "root"; // 数据库用户名
	private static final String DBPASSWORD = "123456"; // 数据库密码

	private Connection conn = null;
	
	static {
		try {
			// 注册驱动
			System.out.println("获取数据库驱动");
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Before
	public void getconnection() {
		System.out.println("获取coon");
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // 获得连接对象
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void duplicateTest(){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String strSql=null;
		try {
			strSql = "INSERT INTO USER (id,name,age) VALUES (?,?,?) ON DUPLICATE KEY UPDATE age=?";
			pstmt = conn.prepareStatement(strSql);
			pstmt.setLong(1, 5);
			pstmt.setString(2, "jimmie");
			pstmt.setInt(3, 23);
			pstmt.setInt(4, 521);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{		
			DatabaseUtils.release(conn, pstmt, rs);
		}
	}
	
}
