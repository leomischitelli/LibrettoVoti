package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaVoti {

	
	public void aggiungiVoto(String nome, int punteggio) {
		String uri = "jdbc:mysql://localhost:3306/libretto?user=root";
		try {
			Connection conn = DriverManager.getConnection(uri);
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		ProvaVoti pv = new ProvaVoti();
		pv.aggiungiVoto("Economia", 18);
		
		String uri = "jdbc:mysql://localhost:3306/libretto?user=root";
		
		try {
			Connection conn = DriverManager.getConnection(uri);
			
			Statement st = conn.createStatement(); //creo statement
			String sql = "SELECT * FROM voti"; //creo query
			st.executeQuery(sql); //eseguo query
			ResultSet res = st.executeQuery(sql); //estraggo risultato
			
			while(res.next()) {//finche' next e' vero
				String nome = res.getString("nome");
				int voto = res.getInt("punteggio");
				System.out.println(nome + " - " + voto);
			}
			
			st.close();//chiudo lo statement, libero memoria
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //connection e' una interfaccia

	}

}
