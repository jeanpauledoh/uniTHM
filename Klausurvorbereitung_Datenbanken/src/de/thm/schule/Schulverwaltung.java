/**
 * 
 */
package de.thm.schule;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * @author jean-
 *
 */
public class Schulverwaltung 
{
	private EntityManagerFactory eMF = null;
	private EntityManager eM = null;
	private EntityTransaction eTx = null;
	
	public Schulverwaltung() 
	{
		eMF = Persistence.createEntityManagerFactory("THM");
		eM = eMF.createEntityManager();
		eTx = eM.getTransaction();
	}
	
	public void testLehrerPersistWithOutPnr() 
	{
		Lehrer phil = new Lehrer();
		phil.setTitel("Dr.");
		phil.setVorname("William");
		phil.setNachname("Phil");
		
		eTx.begin();
		
		eM.persist(phil);
		
		eTx.commit();
	}
	
	public void testLehrerPersistWithOutPnr2() 
	{
		Lehrer wrong = new Lehrer();
		wrong.setTitel("Dr.");
		wrong.setVorname("Wrong");
		wrong.setNachname("Number");
		
		eTx.begin();
		
		eM.persist(wrong);
		
		eTx.commit();
	}
	
	public void testLehrerPersist() 
	{
		Lehrer hermann = new Lehrer();
		hermann.setTitel("Dr.");
		hermann.setVorname("Paul");
		hermann.setNachname("Hermann");
		hermann.setPnr(999);
		
		eTx.begin();
		
		eM.persist(hermann);
		
		eTx.commit();
		
	}
	
	public void testfindLehrerbyPnr(int pnr) 
	{
		eTx.begin();
		Lehrer lFound = eM.find(Lehrer.class, pnr);
		System.out.println(lFound.getTitel()+", "+lFound.getVorname()+", "+lFound.getNachname());
		eTx.commit();
		
	}
	
	public void testUpdateLehrerLastname(String newLastname) 
	{
		eTx.begin();
		
		Lehrer lToUpdate = eM.find(Lehrer.class, 999);
		lToUpdate.setNachname(newLastname);
		eM.merge(lToUpdate);
		eTx.commit();
		
	}
	
	public void testDeleteLehrerbyPnr(int pnr) 
	{
		eTx.begin();
		Lehrer lToDelete = eM.find(Lehrer.class, pnr);
		if(lToDelete != null) 
		{
			eM.remove(lToDelete);
		}
		eTx.commit();
		
		
	}
	
	public void closeConnection() 
	{
		eM.close();
		eMF.close();
	}
	
	public void createDataKlasse() 
	{
		eTx.begin();
		
		Klasse klasse1 = DummyFactory.createKlasse();
		Klasse klasse2 = DummyFactory.createKlasse();
		Klasse klasse3 = DummyFactory.createKlasse();
		Klasse klasse4 = DummyFactory.createKlasse();
		Klasse klasse5 = DummyFactory.createKlasse();
		Klasse klasse6 = DummyFactory.createKlasse();
		Klasse klasse7 = DummyFactory.createKlasse();
		Klasse klasse8 = DummyFactory.createKlasse();
		
		eM.persist(klasse1);
		eM.persist(klasse2);
		eM.persist(klasse3);
		eM.persist(klasse4);
		eM.persist(klasse5);
		eM.persist(klasse6);
		eM.persist(klasse7);
		eM.persist(klasse8);
		
		eTx.commit();
	}	
	
	public void createDataLehrer() 
	{
		eTx.begin();
		
		Lehrer lehrer1 = DummyFactory.createLehrer();
		Lehrer lehrer2 = DummyFactory.createLehrer();
		Lehrer lehrer3 = DummyFactory.createLehrer();
		Lehrer lehrer4 = DummyFactory.createLehrer();
		Lehrer lehrer5 = DummyFactory.createLehrer();
		Lehrer lehrer6 = DummyFactory.createLehrer();
		Lehrer lehrer7 = DummyFactory.createLehrer();
		Lehrer lehrer8 = DummyFactory.createLehrer();
		Lehrer lehrer9 = DummyFactory.createLehrer();
		Lehrer lehrer10 = DummyFactory.createLehrer();
		
		eM.persist(lehrer1);
		eM.persist(lehrer2);
		eM.persist(lehrer3);
		eM.persist(lehrer4);
		eM.persist(lehrer5);
		eM.persist(lehrer6);
		eM.persist(lehrer7);
		eM.persist(lehrer8);
		eM.persist(lehrer9);
		eM.persist(lehrer10);
		
		eTx.commit();
	}
	
	public void createDataSchueler() 
	{
		eTx.begin();
		
		Schueler schueler1 = DummyFactory.createSchueler();
		Schueler schueler2 = DummyFactory.createSchueler();
		Schueler schueler3 = DummyFactory.createSchueler();
		Schueler schueler4 = DummyFactory.createSchueler();
		Schueler schueler5 = DummyFactory.createSchueler();
		Schueler schueler6 = DummyFactory.createSchueler();
		Schueler schueler7 = DummyFactory.createSchueler();
		Schueler schueler8 = DummyFactory.createSchueler();
		Schueler schueler9 = DummyFactory.createSchueler();
		Schueler schueler10 = DummyFactory.createSchueler();
		Schueler schueler11 = DummyFactory.createSchueler();
		Schueler schueler12 = DummyFactory.createSchueler();
		Schueler schueler13 = DummyFactory.createSchueler();
		
		eM.persist(schueler1);
		eM.persist(schueler2);
		eM.persist(schueler3);
		eM.persist(schueler4);
		eM.persist(schueler5);
		eM.persist(schueler6);
		eM.persist(schueler7);
		eM.persist(schueler8);
		eM.persist(schueler9);
		eM.persist(schueler10);
		eM.persist(schueler11);
		eM.persist(schueler12);
		eM.persist(schueler13);
		
		eTx.commit();
	}
	
	public void createDataAG() 
	{	
		eTx.begin();
		
		AG ag1 = DummyFactory.createAG();
		AG ag2 = DummyFactory.createAG();
		AG ag3 = DummyFactory.createAG();
		AG ag4 = DummyFactory.createAG();
		AG ag5 = DummyFactory.createAG();
		AG ag6 = DummyFactory.createAG();
		
		eM.persist(ag1);
		eM.persist(ag2);
		eM.persist(ag3);
		eM.persist(ag4);
		eM.persist(ag5);
		eM.persist(ag6);
		
		eTx.commit();
	}	
	
	public void schuelerAgzuordnen(int anr, int snr) 
	{
		eTx.begin();
		
		AG ag = eM.find(AG.class, anr);
		Schueler schueler = eM.find(Schueler.class, snr);
		
		ag.addSchueler(schueler);
		
		eM.persist(schueler);
		eM.persist(ag);
		
		
		eTx.commit();
	}
	
	public void schuelerKlassezuordnen(int knr, int snr) 
	{
		eTx.begin();
		
		Klasse klasse = eM.find(Klasse.class, knr);
		Schueler schueler = eM.find(Schueler.class, snr);
		
		schueler.setKlasse(klasse);
		
		eM.persist(schueler);
		eM.persist(klasse);
		
		eTx.commit();
	}
	
	public void lehrerKlassezuordnen(int knr, int pnr) 
	{
		eTx.begin();
		
		Klasse klasse = eM.find(Klasse.class, knr);
		Lehrer lehrer = eM.find(Lehrer.class, pnr);
		
		klasse.setLehrer(lehrer);
		
		eM.persist(klasse);
		eM.persist(lehrer);
		
		eTx.commit();
	}
	
	public void deleteSchueler(int snr) 
	{
		eTx.begin();
		Schueler sToDelete = eM.find(Schueler.class, snr);
		if(sToDelete != null) 
		{
			eM.remove(sToDelete);
		}
		eTx.commit();
	}
	
	public void updSchuelerAG(int snr, int anr)
	{
		eTx.begin();
		Schueler sfound = eM.find(Schueler.class, snr);
		AG ag = eM.find(AG.class, anr);
		
		ag.addSchueler(sfound);
		
		eM.merge(ag);
		
		eM.persist(sfound);
		eM.persist(ag);
		eTx.commit();
		
	}
	
	public void setLehrerDate(int pnr, Date gebdatum)	 
	{
		eTx.begin();
		
		Lehrer ltoManage = eM.find(Lehrer.class, pnr);
		
		ltoManage.setGebDatum(gebdatum);
		eM.merge(ltoManage);
		eM.persist(ltoManage);
		
		eTx.commit();
	}
	
	public void updLehrerTitel(int id, String Titel) 
	{
		eTx.begin();
		
		Lehrer ltoManage = eM.find(Lehrer.class, id);
		
		ltoManage.setTitel(Titel);
		eM.merge(ltoManage);
		eM.persist(ltoManage);
		
		eTx.commit();
	}
		
	public List<Object> nonTypedQuery(String stm) 
	{
		Query query = eM.createQuery(stm);
		List<Object> lstResult = query.getResultList();
		return lstResult;
	}
	
	public List<Schueler> TypedQuerySchueler(String stm)
	{
		TypedQuery<Schueler> tquery = eM.createQuery(stm, Schueler.class);
		List<Schueler> sList = tquery.getResultList();
		
		return sList;
	}
	
	
	public List<Schueler> tQsearchByNameSchueler(String name)
	{
		String stmt = "select s from Schueler s where s.nachname = :name";
		TypedQuery<Schueler> tquery = eM.createQuery(stmt, Schueler.class);
		tquery.setParameter("name", name);
		List<Schueler> sList = tquery.getResultList();
		
		return sList;
	}
	
	public List<Lehrer> namedQueryLehrerbyName(String name)
	{
		String stmt = "LEHRER_BY_NACHNAME";
		//Query query = eM.createQuery(stmt);
		Query query = eM.createNamedQuery(stmt);
		query.setParameter("name", name);
		List<Lehrer> lList = query.getResultList();
		
		return lList;
	}
	
	public List<Schueler> searchSchuelerInAg(int agname)
	{
		String stmt = "select s from Schueler s join Klasse k where k.knr = :agname";
		Query query = eM.createQuery(stmt);
		query.setParameter("agname", agname);
		
		List<Schueler> sList = query.getResultList();
		
		return sList;
	}
	
}
