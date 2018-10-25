/**
 * 
 */
package de.thm.schule;

import java.sql.*;


/**
 * @author jean-
 *
 */
public class OutputHandler 
{
	private ResultSet rs;
	
	public OutputHandler(ResultSet rs) 
	{
		this.rs = rs;
		testanalyzeResult();
	}
	
	public OutputHandler() 
	{
		
	}

	private void testanalyzeResult()
	{
		try 
		{
			ResultSetMetaData md = rs.getMetaData();
			while(rs.next()) 
			{
				System.out.println(rs.getString(2)+", "+rs.getString(3)+","+rs.getString(4)+","+rs.getDate(5));
			}
			
			System.out.println("Information Metadata: - Coloumns: "+md.getColumnCount()+"Types: "+md.getColumnType(2)+", "
			+md.getColumnType(3)+", "+md.getColumnType(4)+", "+md.getColumnType(5)+", Names: "+md.getColumnName(2)+", "+md.getColumnName(3)+", "
			+md.getColumnName(4)+", "+md.getColumnName(5));
			
		}
		catch(SQLException e) 
		{
			System.out.println("CRASHED");
			e.printStackTrace();
		}
	}
	
	public void handlmanualySchueler(ResultSet rs) 
	{
		try 
		{
			while(rs.next()) 
			{
				System.out.println(rs.getString(1)+", "+rs.getString(2)+","+rs.getDate(3));
			}
		}
		catch(SQLException e) 
		{
			System.out.println("CRASHED");
			e.printStackTrace();
		}
	}
	
}


