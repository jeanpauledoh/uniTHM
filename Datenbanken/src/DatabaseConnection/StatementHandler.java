package DatabaseConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

import ownExceptions.PotentialOverflowException;

public class StatementHandler 
{
	private Connection conn = null;
	
	public  StatementHandler(Connection conn)
	{
		this.conn = conn;
	}
	
	public ArrayList<String> selectResultSet(String select) throws PotentialOverflowException
	{
		if(!potentialOverflow(select))
		{
			ArrayList<String> lstResultSet = new ArrayList<>();	
			try
			{
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(select);
				ResultSetMetaData rsMeta = rs.getMetaData();
				int iRsColumns = rsMeta.getColumnCount();
				
				while(rs.next())
				{
					/*
					 * Bei unbekannter anzahl an Columns mithilfe der metadaten variable der anzahl setzen,
					 * danach über ResultSet iterieren und String zusammenbauen.
					 */
					String currRow = "";
					if(iRsColumns > 1)
					{
						for (int i=1; i<= iRsColumns; i++)
						{
							currRow = currRow +rsMeta.getColumnLabel(i)+": "+rs.getString(i)+" ";
						}
					}
					else
					{
						for (int i=1; i<= iRsColumns; i++)
						{
							currRow = currRow + rs.getString(i);
						}
					}
					lstResultSet.add(currRow);
				}
				
			}
			catch (SQLException e)
			{
				System.out.println("STOP!");
				e.printStackTrace();
			}
			
			return lstResultSet;
		}
		else
		{
			PotentialOverflowException e = new PotentialOverflowException();
			throw e;
		}
	}
	
	private boolean potentialOverflow(String statement)
	{
		//check if '*' appeares in statement
		if(statement.indexOf(" * ")!=-1)
		{
		  return true; 
		}
		else
		{
		   return false;
		}
		
		/*
		 * Erklärung: Die Verwendung von .indexOf returned ein value größer 0,
		 * wenn der gesuchte character im string enthalten ist, ansonsten den value -1.
		 * D.h. ein positiver Wert bedeutet der character ist im String enthalten
		 * --> einfache möglichkeit der prüfung ohne die Verwendung einer loop-konstruktion
		 */
		
	}
	public void inPlaceSearch() throws SQLException 
	{
		ResultSet res = null;
		String query="select vorname, nachname, gebdatum from schueler where vorname like ?";
		PreparedStatement ps = conn.prepareStatement(query);
		String input = "";
		while(!("ENDE").equals(input))
		{
			input = liesString();
			ps.setString(1, input);
			res=ps.executeQuery();
			
			while(res.next())
			{
				String strVorname = res.getString(1);
				String strNachname = res.getString(2);
				Date dateGedatum = res.getDate(3);
				System.out.println(strVorname+";"+strNachname+";"+dateGedatum);
			}
		}
	}
	
	public static String liesString()
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("Eingabe:>");
			return input.readLine();
		}
		catch (Exception e)
		{
			return "ENDE";
		}
	}
	
	public static void getMetaData(ResultSet res) throws SQLException
	{
		ResultSetMetaData md = res.getMetaData();
		System.out.println("Colums: "+md.getColumnCount()+"; Names: "+md.getColumnName(1)+";"+md.getColumnName(2)+";"+md.getColumnName(3));
	}

}
