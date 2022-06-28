package it.polito.tdp.librettovoti.model;

import java.util.List;

import it.polito.tdp.librettovoti.db.LibrettoDAO;

public class Libretto {
	
	public Libretto() {
		
	}
	
	public boolean add(Voto voto) {
		LibrettoDAO dao = new LibrettoDAO();
		boolean result = dao.creaVoto(voto);
		return result;
	}
	
	
	
	public List<Voto> getVoti(){
		LibrettoDAO dao = new LibrettoDAO();
		return dao.readAllVoto();
		
	}

	@Override
	public String toString() {
		return "Libretto [getVoti()=" + getVoti() + "]";
	}
	
	
	

}
