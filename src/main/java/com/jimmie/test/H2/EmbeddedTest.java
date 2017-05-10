package com.jimmie.test.H2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 嵌入模式
 * @author Administrator
 *
 */
public class EmbeddedTest {

	public static void main(String[] a)
		      throws Exception {
		   Class.forName("org.h2.Driver");
		   Connection conn = DriverManager.
		       getConnection("jdbc:h2:D:\\db\\test", "sa", "");
		   // add application code here
		   Statement stmt = conn.createStatement();
		   stmt.executeUpdate("DROP TABLE IF EXISTS `TEST_MEM`; CREATE TABLE TEST_MEM(ID INT PRIMARY KEY,NAME VARCHAR(255));");
		   stmt.executeUpdate("INSERT INTO TEST_MEM VALUES(1, 'Hello_Mem');");
		   ResultSet rs = stmt.executeQuery("SELECT * FROM TEST_MEM ");   
		      while(rs.next()) {   
		       System.out.println(rs.getInt("ID")+","+rs.getString("NAME"));
		      }
		   conn.close();
		 }
	
}
