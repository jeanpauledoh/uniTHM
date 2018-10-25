package de.thm.schule;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.thm.schule.Lehrer;

public class LehrerDao extends JpaDao<Lehrer, Integer> implements ILehrerDAO
{
	public List<Lehrer> sucheNachname(String param)
	{
		TypedQuery<Lehrer> query = eM.createQuery("select l from Lehrer l where l.nachname = :name", Lehrer.class );
		query.setParameter("name", param);
		List<Lehrer> aList = query.getResultList();
		
		return aList;
	}
	
	public List<Lehrer> sucheNachname2(String param)
	{
		CriteriaBuilder cb = eM.getCriteriaBuilder();
		CriteriaQuery<Lehrer> cq = cb.createQuery(Lehrer.class);
		Root<Lehrer> l = cq.from(Lehrer.class);
		cq.select(l);
		cq.where(cb.equal(l.get(Lehrer_.nachname), "Lehrer"));
		TypedQuery<Lehrer> query = eM.createQuery(cq);
		List<Lehrer> result = query.getResultList();
		
		return result;
	}
	
} 