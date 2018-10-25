package de.thm.schule;

import java.util.ArrayList;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel (Schueler.class)
public class Schueler_ 
{ 
	public static volatile SingularAttribute<Schueler, Integer> SNr;
	public static volatile SingularAttribute<Schueler, String> vorname;
	public static volatile SingularAttribute<Schueler, String> nachname;
	public static volatile SingularAttribute<Schueler, Klasse> klasse;
	public static volatile SingularAttribute<Schueler, ArrayList<AG>> ags;
}
