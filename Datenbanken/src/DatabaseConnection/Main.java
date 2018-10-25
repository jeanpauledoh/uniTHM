package DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;

import ownExceptions.PotentialOverflowException;

public class Main 
{
	private static DBConnection DBC = new DBConnection("localhost", "3306", "jped86", "root", "root");
	private static StatementHandler STH = null;
	
	public static void main(String args[])
	{
		System.out.println("Nohting to see here..");
		runDBC();
		//output is handeled in main
		testSelect("select vorname, nachname from lehrer");
		testSelect("select bezeichnung,count(*) as anzahl from klasse k natural join schueler s group by bezeichnung");
		testSelect("select * from lehrer");  // Exception test to see if it gets caught
		
		closeConnection();
	}
	
	public static void runDBC()
	{
		DBC.startConnection();
	}
	
	public static void testSelect(String select)
	{
		ArrayList<String> lstResult = null;
		
		try
		{
			STH = new StatementHandler(DBC.getConnection());
			lstResult = STH.selectResultSet(select);
			//STH.inPlaceSearch();
			System.out.println(lstResult);
		}
		catch (PotentialOverflowException e) 
		{
			System.out.println("STOP!");
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			System.out.println("STOP!");
			e.printStackTrace();
		}
	
	}
	
	public static void closeConnection()
	{
		DBC.closeConnection();
	}

}
