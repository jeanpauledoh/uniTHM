/**
 * 
 */
package de.thm.schule;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;


/**
 * @author jean-
 *
 */
public class JDBC_Statementhandler 
{
	private Connection conn;
	private ResultSet rs = null;
	private Statement stm = null;
	
	public JDBC_Statementhandler(Connection actualconn) 
	{
		conn=actualconn;
	}

	public void testStatement(String strQuery) 
	{
		try 
		{
			stm = conn.createStatement();
			rs = stm.executeQuery(strQuery);
			while(rs.next()) 
			{
				System.out.println(rs.getString(2)+", "+rs.getString(3));
			}
			
		}
		catch(SQLException e) 
		{
			System.out.println("CRASHED");
			e.printStackTrace();
		}
	}
	
	public ResultSet easyStatementAufagbe1(String strQuery) 
	{
		try 
		{
			stm = conn.createStatement();
			rs = stm.executeQuery(strQuery);
		}
		catch(SQLException e) 
		{
			System.out.println("CRASHED");
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet preparedStatement(String strTitel, int iYeear) 
	{
		try 
		{
		String query = "select * from lehrer where titel = ? and year(gebdatum) > ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, strTitel);
		ps.setInt(2, iYeear);
		rs = ps.executeQuery();
		}
		catch(SQLException e) 
		{
			System.out.println("CRASHED");
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void preparedStatementSchueler() 
	{
		String input = "";
		while(!input.equals("ENDE")) 
		{
			input = liesString();
			try 
			{
			String query = "select vorname, nachname, gebdatum  from schueler where nachname like ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, input);
			rs = ps.executeQuery();
			
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
	
	public String liesString() 
	{
		BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			System.out.println("Eingabe:>");
			return B.readLine();
		} catch (Exception e) 
		{
			return "ENDE";
		}
	}

}

