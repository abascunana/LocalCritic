package Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlJuego extends Conexion {
public boolean registrarJuego(Juego jgi){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO peliculas (tituloJuego,desarrolladoraJuego,descripcionJuego,distribuidoraJuego,generoJuego,plataformaJuego,anoLanzamientoJuego,mediaValJuego) VALUES(?,?,?,?,?,?,?,?,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setString(1,jgi.getTituloJuego());
			ps.setString(2,jgi.getDesarrolladoraJuego());
			ps.setString(3,jgi.getDescripcionJuego());
			ps.setString(4,jgi.getDistribuidoraJuego());
			ps.setString(5,jgi.getGeneroJuego());
			ps.setString(6,jgi.getPlataformaJuego());
			ps.setInt(7,jgi.getAnoLanzamientoJuego());
			ps.setInt(8,jgi.getMediaJuego());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
public int existeJuego(String jgi ) {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConexion();
	
	String sql = "Select count(juegoID) from videojuegos where tituloJuego = ?";
	
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,jgi);
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
public static int BuscarID(Juego jgi) throws SQLException {
    PreparedStatement ps = null;
    Connection pepe = getConexion();
    ResultSet rs = null;
    String sql = "Select juegoID from  videojuegos where tituloJuego = ?";

    try {
        ps = pepe.prepareStatement(sql);
        ps.setString(1,jgi.getTituloJuego());
        rs = ps.executeQuery();
        if(rs.next()) {
            return rs.getInt(1);}
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return 1;
    }
    return 0;


}

public boolean InsertarEnObra(Juego jgi) throws SQLException {

    PreparedStatement ps = null;
    Connection pepe = getConexion();
    int id = BuscarID(jgi);
    String sql  = "INSERT INTO obras (obraID,tituloObra,tipoObra) VALUES(?,?,?)";
    try {
        ps = pepe.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,jgi.getTituloJuego());
        ps.setString(3,"Juego");
        ps.execute();
        return true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
    }


    }
}
