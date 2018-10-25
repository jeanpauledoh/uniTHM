package de.thm.schule;

import java.util.List;

import javax.persistence.TypedQuery;

public class PersonDao extends JpaDao<Person, Integer> implements IPersonDAO 
{
	public List<Person> sucheNachname(String param) 
	{
		TypedQuery<Person> query = eM.createQuery("select p from Person p where p.nachname = :name", Person.class );
		query.setParameter("name", param);
		List<Person> aList = query.getResultList();
		
		return aList;
	}
}
