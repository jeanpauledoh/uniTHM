/**
 * 
 */
package de.thm.schule;

import java.sql.*;

/**
 * @author jean-
 *
 */
public class JDBC_Connector 
{
	private String strServer;
	private String strPort;
	private String strDatabase;
	private Connection conn;
	
	public JDBC_Connector(String str1, String str2, String str3) 
	{	
		strServer = str1;
		strPort = str2;
		strDatabase = str3;
		conn = null;
		startconnection();
	}
	
	public void startconnection() 
	{
		try
		{
			//get the driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//establish connection
			String connection = "jdbc:mysql://"+strServer+":"+strPort+"/"+strDatabase;
			conn = DriverManager.getConnection(connection, "root", "root");
		}
		catch(SQLException e)
		{
			System.out.println("CRASHED");
			e.printStackTrace();
		}
	}
	
	public Connection getconnection() 
	{
		return conn;
	}
}
