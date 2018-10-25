package de.thm.schule;

import java.util.ArrayList;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel (Klasse.class)
public class Klasse_ 
{ 
	public static volatile SingularAttribute<Klasse, Integer> KNr;
	public static volatile SingularAttribute<Klasse, String> bezeichnung;
	public static volatile SingularAttribute<Klasse, Lehrer> lehrer;
	public static volatile SingularAttribute<Klasse, ArrayList<Schueler>> schueler;
}
