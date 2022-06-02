package Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlCancion extends Conexion {
public boolean registrarCancion(Cancion cnc){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO cancion (tituloCancion,artista,generoCancion,actor,anoLanzamientoCancion,duracionCancion,productoraCancion,mediaValPelicula) VALUES(?,?,?,?,?,?,?,?,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setString(1,cnc.getTituloCancion());
			ps.setString(2,cnc.getArtistaCancion());
			ps.setString(3,cnc.getGeneroCancion());
			ps.setInt(4,cnc.getAnoLanzamientoCancion());
			ps.setInt(5,cnc.getDuracionCancion());
			ps.setString(6,cnc.getProductoraCancion());
			ps.setInt(7,cnc.getMediaCancion());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
public int existeJuego(String cnc ) {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConexion();
	
	String sql = "Select count(cancionID) from cancion where tituloCancion = ?";
	
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,cnc);
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
public static int BuscarID(Cancion cnc) throws SQLException {
    PreparedStatement ps = null;
    Connection pepe = getConexion();
    ResultSet rs = null;
    String sql = "Select cancionID from cancion where tituloCancion = ?";

    try {
        ps = pepe.prepareStatement(sql);
        ps.setString(1,cnc.getTituloCancion());
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

public boolean InsertarEnObra(Cancion cnc) throws SQLException {

    PreparedStatement ps = null;
    Connection pepe = getConexion();
    int id = BuscarID(cnc);
    String sql  = "INSERT INTO obras (obraID,tituloObra,tipoObra) VALUES(?,?,?)";
    try {
        ps = pepe.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,cnc.getTituloCancion());
        ps.setString(3,"Cancion");
        ps.execute();
        return true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
    }


    }
}
