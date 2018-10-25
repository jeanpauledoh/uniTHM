package DatabaseConnection;

import java.sql.*;


public class DBConnection 
{
	private String server = "";
	private String port = "";
	private String database = "";
	private String user = "";
	private String pass ="";
	private boolean isConnected = false;
	//achtung Connection muss vorher mit null initialisiert werden!
	private Connection conn = null;
	
	public DBConnection(String server, String port, String database, String user, String pass)
	{
		this.server = server;
		this.port = port;
		this.database = database;
		this.user = user;
		this.pass = pass;
	}
	
	public void startConnection()
	{
		try
		{
			//treiber laden
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//verbindung herstellen
			String connect = "jdbc:mysql://"+server+":"+port+"/"+database;
			//conn --> actual connection
			conn = DriverManager.getConnection(connect, user, pass);
			isConnected = true;
		}
		catch(SQLException e)
		{
			System.out.println("STOP!");
			e.printStackTrace();
		}
		//finally block um die Connection sicher zu schließen --> gehört nicht hier hin. 
		//Connection am besten nach jedem Statement schließen?
		/*
		finally
		{
			if(conn!=null)
			{
				try 
				{
					conn.close();
					isConnected = false;
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}*/
	}
	
	public Connection getConnection() throws SQLException
	{
		if(isConnected)
		{
			return conn;
		}
		else
		{
			SQLException e = new SQLException("No Connection");
			throw e;
		}
	}
	
	public void closeConnection()
	{
		if(conn!=null)
		{
			try 
			{
				conn.close();
				isConnected = false;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
