package de.thm.schule;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import de.thm.schule.Klasse;

public class KlasseDao extends JpaDao<Klasse, Integer> implements IKlasseDAO
{
	public List<Klasse> sucheKlasse(String param)
	{
		TypedQuery<Klasse> query = eM.createQuery("select k from Klasse k where k.bezeichnung = :bezeichnung", Klasse.class );
		query.setParameter("bezeichnung", param);
		List<Klasse> aList = query.getResultList();
		
		return aList;
	}
	
	public List<Klasse> sucheKlasse2(String param)
	{
		CriteriaBuilder cb = eM.getCriteriaBuilder();
		CriteriaQuery<Klasse> cq = cb.createQuery(Klasse.class);
		Root<Klasse> k = cq.from(Klasse.class);
		cq.select(k);
		cq.where(cb.equal(k.get(Klasse_.bezeichnung), param));
		TypedQuery<Klasse> query = eM.createQuery(cq);
		List<Klasse> result = query.getResultList();
		
		return result;
	}
	
	public List<Klasse> sucheKlasse3(String param)
	{
		CriteriaBuilder cb = eM.getCriteriaBuilder();
		CriteriaQuery<Klasse> cq = cb.createQuery(Klasse.class);
		
		Root<Klasse> k = cq.from(Klasse.class);
		Path<String> bez = k.get(Klasse_.bezeichnung);
		cq.select(k);
		cq.where(cb.in(bez).value(param));
		TypedQuery<Klasse> query = eM.createQuery(cq);
		List<Klasse> result = query.getResultList();
		
		return result;
	}
	
	
}
 