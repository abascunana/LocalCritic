package Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlCancion extends Conexion {
public boolean registrarCancion(Cancion cancion){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO canciones (tituloCancion,generoCancion,artista,anoLanzamientoCancion,duracionCancion,productoraCancion,mediaValCancion) VALUES(?,?,?,?,?,?,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setString(1,cancion.getTituloCancion());
			ps.setString(2,cancion.getGeneroCancion());
			ps.setString(3,cancion.getArtista());
			ps.setInt(4,cancion.getAnoLanzamientoCancion());
			ps.setInt(5,cancion.getDuracionCancion());
			ps.setString(6,cancion.getProductoraCancion());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
public int existeCancion(String cancion) {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConexion();
	
	String sql = "Select count(cancionID) from canciones where tituloCancion = ?";
	
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,cancion);
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
public int BuscarID(Cancion cancion) throws SQLException {
    PreparedStatement ps = null;
    Connection pepe = getConexion();
    ResultSet rs = null;
    String sql = "Select cancionID from canciones where tituloCancion = ?";

    try {
        ps = pepe.prepareStatement(sql);
        ps.setString(1,cancion.getTituloCancion());
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

public boolean InsertarEnObra(Cancion cancion) throws SQLException {

    PreparedStatement ps = null;
    Connection pepe = getConexion();
    int id = BuscarID(cancion);
    String sql  = "INSERT INTO obras (obraID,tituloObra,tipoObra) VALUES(?,?,?)";
    try {
        ps = pepe.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,cancion.getTituloCancion());
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