package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.model.Voto;

public class LibrettoDAO {
	
	//contiene metodi CRUD (Create Read Update Delete) (Delete ci fa un po' schifo)
	
	public boolean creaVoto(Voto v) {
		//faccio insert
		//il model non ha la minima idea del database e della sua composizione
		try {
			Connection conn = DBConnect.getConnection();
			
			String sql = "INSERT INTO voti (nome, punteggio) VALUES (?, ?);"; //creo query
			PreparedStatement st = conn.prepareStatement(sql); //creo statement
			st.setString(1, v.getNome());
			st.setInt(2, v.getPunteggio());
			
			int res = st.executeUpdate();
			st.close();
			conn.close();
			return(res==1); //true se res = 1
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Voto> readAllVoto() {
		
		try {
			Connection conn = DBConnect.getConnection();
			String sql = "SELECT * FROM voti"; //creo query
			PreparedStatement st = conn.prepareStatement(sql); //creo statement
			ResultSet res = st.executeQuery(); //estraggo risultato
			
			List<Voto> result = new ArrayList<>();
			
			while(res.next()) {//finche' next e' vero
				String nome = res.getString("nome");
				int punteggio = res.getInt("punteggio");
				result.add(new Voto(nome, punteggio));
			}
			
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			System.out.print(e);
			e.printStackTrace();
			return null;
		}
	}
	
/*	public Voto readVotoByNome(String nome) {
		
		return ;
	} */

}
