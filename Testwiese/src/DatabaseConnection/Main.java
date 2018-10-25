package DatabaseConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;



import ownExceptions.NotInitializedException;

public class Main 
{
	
	public static void main(String args[])
	{
		Connection conn = null;
		try
		{	
		
		System.out.println("Nothing to see here");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		
		String str = "jdbc:mysql://localhost:3306/jped86";
		conn = DriverManager.getConnection(str, "root", "root");
		Statement stm = conn.createStatement();
		//ResultSet res = stm.executeQuery(" select vorname, nachname, gebdatum from schueler");
		ResultSet res = stm.executeQuery("select bezeichnung, count(*) as anzahl from klasse k natural join schueler s group by bezeichnung");
		
		
		
		while(res.next())
		{
			/*String strVorname = res.getString(1);
			String strNachname = res.getString(2);
			Date dateGedatum = res.getDate(3);
			System.out.println(strVorname+";"+strNachname+";"+dateGedatum);*/
			String strBezeichnung = res.getString(1);
			Integer iAnzahl = res.getInt(2);
			
			System.out.println(strBezeichnung+";"+iAnzahl);
			test(conn);
		}
		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null)
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void test (Connection conn ) throws SQLException 
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