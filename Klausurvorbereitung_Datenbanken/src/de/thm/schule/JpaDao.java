package de.thm.schule;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.*;

public abstract class JpaDao<E, PK extends Serializable> implements IDao<E, PK>
{
	protected Class<E> entityClass;
	protected EntityManager eM;
	protected EntityManagerFactory eMF = null;
	protected EntityTransaction eTx = null;
	
	@SuppressWarnings("unchecked")
	public JpaDao() 
	{
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		eMF = Persistence.createEntityManagerFactory("THM");
		eM = eMF.createEntityManager();
		eTx = eM.getTransaction();
	}
	
	public void persist(E entity) 
	{
		eTx.begin();
		eM.persist(entity);
		
		eTx.commit();
		
		eM.close();
		eMF.close();
	}
	
	public void remove(E entity) 
	{
		eTx.begin();
		eM.remove(entity);
		
		eTx.commit();
		eM.close();
		eMF.close();
	}
	
	public E findById(PK id) 
	{
		
		E entity = eM.find(entityClass, id);
		
		return entity;
	}
}
