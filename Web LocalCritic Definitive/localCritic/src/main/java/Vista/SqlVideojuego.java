package Vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlVideojuego extends Conexion {
	
	public boolean registrarVideojuego(Videojuego juego){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO videojuegos (tituloJuego,descripcionJuego,generoJuego,plataformaJuego,anoLanzamientoJuego,desarrolladoraJuego,distribuidoraJuego,mediaValJuego) VALUES(?,?,?,?,?,?,?,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setString(1,juego.getTituloJuego());
			ps.setString(2,juego.getDescripcionJuego());
			ps.setString(3,juego.getGeneroJuego());
			ps.setString(4,juego.getPlataformaJuego());
			ps.setInt(5,juego.getAnoLanzamientoJuego());
			ps.setString(6,juego.getDesarrolladoraJuego());
			ps.setString(7,juego.getDistribuidoraJuego());



			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			}
		}	
	public int existeVidejuego(String videojuego ) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "Select count(juegoID) from videojuegos where tituloJuego = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,videojuego);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		
			
		}
	}
