package de.thm.schule;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.selectItem_return;
import org.eclipse.persistence.jpa.jpql.parser.NewValueBNF;

public class Schulverwaltung 
{
	//public DummyFactory DF = new DummyFactory();
	
	public void runEnt()
	{
		/*
		 * META-INF muss unter dem src-ordner angelegt werden
		 */
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction tx = eM.getTransaction();
		
		Lehrer hans = new Lehrer();
		//neuen lehrer einfügen
		//hans.setVorname("Hans");
		//hans.setNachname("Wurst");
		//hans.setPNr(75);
		
		tx.begin();
		//eM.persist(hans);
		Lehrer lehrer = eM.find(Lehrer.class, 75);
		/* update eines objekts:
		lehrer.setNachname("Anders");
		eM.merge(lehrer);
		*/
		tx.commit();
		
		eM.close();
		eMF.close();
		lehrer.getInfo();
		
	
	}
	
	public void loadNewEntityLehrer(String nachname, String vorname)
	{
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction tx = eM.getTransaction();
		
		Lehrer neuerLehrer = new Lehrer();
		//neuerLehrer.setVorname(vorname);
		//neuerLehrer.setNachname(nachname);
		
		tx.begin();
		eM.persist(neuerLehrer);
		tx.commit();
		
		eM.close();
		eMF.close();
	}
	public void loadNewEntityKlasse(String bezeichnung, ArrayList<Schueler> schuelerList)
	{ 
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction tx = eM.getTransaction();
		
		Klasse neueklasse = new Klasse();
		neueklasse.setBezeichnung(bezeichnung);
		if(!schuelerList.isEmpty())
		{
			neueklasse.setSchueler(schuelerList);
		}
		
		tx.begin();
		eM.persist(neueklasse);
		tx.commit();
		
		eM.close();
		eMF.close();
	}
	
	public void loadNewEntitySchueler(String nachname, String vorname)
	{

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction tx = eM.getTransaction();
		
		Schueler neuerSchueler = new Schueler();
		neuerSchueler.setVorname(vorname);
		neuerSchueler.setNachname(nachname);
		
		tx.begin();
		eM.persist(neuerSchueler);
		tx.commit();
		
		eM.close();
		eMF.close();
	}
	
	/*
	public void dummy()
	{
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction tx = eM.getTransaction();
		
		Lehrer neuerLehrer = DF.createLehrer();
		Lehrer neuerLehrer2 = DF.createLehrer();
		Lehrer neuerLehrer3 = DF.createLehrer();
		
		Schueler neuerSchueler = DF.createSchueler();
		Schueler neuerSchueler2 = DF.createSchueler();
		Schueler neuerSchueler3 = DF.createSchueler();
		
		
		Klasse neueklasse = DF.createKlasse();
		Klasse neueklasse2 = DF.createKlasse();
		Klasse neueklasse3 = DF.createKlasse();
		
		AG neueAG = DF.createAG();
		AG neueAG2 = DF.createAG();
		AG neueAG3 = DF.createAG();
		
	
		tx.begin();
		eM.persist(neuerLehrer);
		eM.persist(neuerLehrer2);
		eM.persist(neuerLehrer3);
		
		eM.persist(neuerSchueler);
		eM.persist(neuerSchueler2);
		eM.persist(neuerSchueler3);
		
		eM.persist(neueklasse);
		eM.persist(neueklasse2);
		eM.persist(neueklasse3);
		
		eM.persist(neueAG);
		eM.persist(neueAG2);
		eM.persist(neueAG3);

		
		tx.commit();
		
		eM.close();
		eMF.close();
	}
	*/
	
	public void execQuerySchueler(String stm)
	{
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
		EntityManager eM = eMF.createEntityManager();
		
		TypedQuery<Schueler> query = eM.createQuery(stm, Schueler.class );
		List<Schueler> aList = query.getResultList();
		
		for( Schueler s : aList)
		{
			System.out.println(s.getNachname()+"; "+s.getVorname());
		}
		
	}
	
	public void execQuerySchueler2 (String param)
	{
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
		EntityManager eM = eMF.createEntityManager();
		
		TypedQuery<Schueler> query = eM.createQuery("select s from Schueler s where s.nachname = :name", Schueler.class );
		//entpsricht select stern
		query.setParameter("name", param);
		List<Schueler> aList = query.getResultList();
		
		for( Schueler s : aList)
		{
			System.out.println(s.getNachname()+"; "+s.getVorname());
		}
		
	}
	
	public void testDAO()
	{
		
		Schueler s = new Schueler();
		s.setVorname("Mark");
		s.setNachname("Tester");
		SchuelerDao sdao = new SchuelerDao();
		sdao.persist(s);
	}
	
	public void testDAO2()
	{
		
		SchuelerDao sdao = new SchuelerDao();
		Schueler s = sdao.findById(4);
		s.getInfo();
	}
	
	public void testDAO3()
	{
		Lehrer l = new Lehrer();
		l.setVorname("Herr");
		l.setNachname("Lehrer");
		LehrerDao ldao = new LehrerDao();
		ldao.persist(l);
	}
	
	public void lehrerDAO()
	{
		LehrerDao ldao = new LehrerDao();
			
		for( Lehrer s : ldao.sucheNachname("Lehrer"))
		{
			System.out.println(s.getNachname()+"; "+s.getVorname());
		}
	}
	
	public void lehrerCB() 
	{
		LehrerDao ldao = new LehrerDao();
		
		for( Lehrer s : ldao.sucheNachname2("Lehrer"))
		{
			System.out.println(s.getNachname()+"; "+s.getVorname());
		}
	}
	
	public void klasseCB(String param)
	{
		/*
		KlasseDao kdao = new KlasseDao();
			
		for( Klasse s : kdao.sucheKlasse("10c"))
		{
			System.out.println(s.getKNr()+"; "+s.getBezeichnung());
		}
		*/
		/*
		KlasseDao kdao = new KlasseDao();
		
		for( Klasse s : kdao.sucheKlasse2("10c"))
		{
			System.out.println(s.getKNr()+"; "+s.getBezeichnung());
		}
		*/
		KlasseDao kdao = new KlasseDao();
		
		for( Klasse s : kdao.sucheKlasse3(param))
		{
			System.out.println(s.getKNr()+"; "+s.getBezeichnung());
		}
		
	}
	
	public void testSchueler(String param) 
	{
		SchuelerDao sdao = new SchuelerDao();
		
		for( Schueler s : sdao.sucheNachKlasse(param))
		{
			System.out.println(s.getVorname()+"; "+s.getNachname());
		}
	}
	
}
