package de.thm.schule;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class JpaDao <E, PK extends Serializable> implements IDao<E, PK>
{
	protected Class<E> entityClass;
	protected EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TEST");
	protected EntityManager eM = eMF.createEntityManager();
	protected EntityTransaction tx = eM.getTransaction();
	
	@SuppressWarnings ("unchecked")
	public JpaDao()
	{
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
		.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
		.getActualTypeArguments() [0];
	}
	
	public void persist (E entity)
	{
	
		tx.begin();
		eM.persist(entity);
		tx.commit();
		
		eM.close();
		eMF.close();
	}
	
	public void remove (E entity)
	{
		tx.begin();
		eM.remove(entity);
		tx.commit();
		
		eM.close();
		eMF.close();
	}
	
	public E findById (PK id)
	{
		return eM.find(entityClass , id);
	}
}
