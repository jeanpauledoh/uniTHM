package de.thm.schule;

import java.util.ArrayList;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel (Lehrer.class)
public class Lehrer_ 
{ 
	public static volatile SingularAttribute<Lehrer, Integer> PNr;
	public static volatile SingularAttribute<Lehrer, String> vorname;
	public static volatile SingularAttribute<Lehrer, String> nachname;
	public static volatile SingularAttribute<Lehrer, Klasse> klasse;
}
