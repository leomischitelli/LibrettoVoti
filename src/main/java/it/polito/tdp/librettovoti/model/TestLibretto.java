package it.polito.tdp.librettovoti.model;

public class TestLibretto {

	public static void main(String[] args) {

		Libretto libretto = new Libretto();
		libretto.add(new Voto("Analisi I", 30));
		libretto.add(new Voto("Fisica I", 18));
		libretto.add(new Voto("Informatica", 25));
		libretto.add(new Voto("Algebra", 25));

		
		System.out.println(libretto);
		
/*		System.out.println("Voti pari a 25");
		Libretto lib25 = libretto.filtraPunti(25);
		System.out.println(lib25); */
	}

}
