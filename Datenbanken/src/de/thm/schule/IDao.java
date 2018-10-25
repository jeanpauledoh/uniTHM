package de.thm.schule;
import java.io.*;

public interface IDao <E, PK extends Serializable>
{
	public void persist (E entity);
	public void remove (E entity);
	public E findById (PK id);
}
