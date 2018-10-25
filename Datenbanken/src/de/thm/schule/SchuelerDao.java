package de.thm.schule;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import de.thm.schule.Schueler;

public class SchuelerDao extends JpaDao<Schueler, Integer> implements ISchuelerDAO
{
	public List<Schueler> sucheNachname(String param)
	{
		TypedQuery<Schueler> query = eM.createQuery("select s from schueler s where s.nachname = :name", Schueler.class );
		query.setParameter("name", param);
		List<Schueler> aList = query.getResultList();
		
		return aList;
	}
	
	public List<Schueler> sucheNachKlasse(String param)
	{
		CriteriaBuilder cb = eM.getCriteriaBuilder();
		CriteriaQuery<Schueler> cq = cb.createQuery(Schueler.class);
		CriteriaQuery<Klasse> cq2 = cb.createQuery(Klasse.class);
		Root<Schueler> s = cq.from(Schueler.class);
		Root<Klasse> k = cq2.from(Klasse.class);
		//Path<Klasse> pk = s.get(Schueler_.klasse);
		Path<String> pkbez = k.get(Klasse_.bezeichnung);
		cq.select(s).where(cb.equal(pkbez, param));
		
		TypedQuery<Schueler> query = eM.createQuery(cq);
		List<Schueler> result = query.getResultList();
		
		return result;
	}
}
