package it.polito.tdp.librettovoti.model;

public class Voto {
	
	private String nome;
	private int punteggio;
	
	public Voto(String nome, int punti) {
		this.nome = nome;
		this.punteggio = punti;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	
	public void setPunteggio (int punti) {
		this.punteggio = punti;
	}

	@Override
	public String toString() {
		return nome + " " + punteggio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + punteggio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (punteggio != other.punteggio)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
