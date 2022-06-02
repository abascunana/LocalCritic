package Web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlPelicula extends Base {
public boolean registrarPelicula(Pelicula peli){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO peliculas (tituloPelicula,sinopsisPelicula,generoPelicula,actor,anoLanzamientoPelicula,duracionPelicula,director,productoraPelicula,mediaValPelicula) VALUES(?,?,?,?,?,?,?,?,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setString(1,peli.getTituloPelicula());
			ps.setString(2,peli.getSinopsisPelicula());
			ps.setString(3,peli.getGeneroPelicula());
			ps.setString(4,peli.getActor());
			ps.setInt(5,peli.getAnoLanzamientoPelicula());
			ps.setInt(6,peli.getDuracionPelicula());
			ps.setString(7,peli.getDirector());
			ps.setString(8,peli.getProductoraPelicula());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
public int existePelicula(String pelicula ) {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConexion();
	
	String sql = "Select count(peliculaID) from peliculas where tituloPelicula = ?";
	
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,pelicula);
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
public static int BuscarID(Pelicula peli) throws SQLException {
    PreparedStatement ps = null;
    Connection pepe = getConexion();
    ResultSet rs = null;
    String sql = "Select peliculaID from peliculas where tituloPelicula = ?";

    try {
        ps = pepe.prepareStatement(sql);
        ps.setString(1,peli.getTituloPelicula());
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

public boolean InsertarEnObra(Pelicula peli) throws SQLException {

    PreparedStatement ps = null;
    Connection pepe = getConexion();
    int id = BuscarID(peli);
    String sql  = "INSERT INTO obras (obraID,tituloObra,tipoObra) VALUES(?,?,?)";
    try {
        ps = pepe.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,peli.getTituloPelicula());
        ps.setString(3,"Pelicula");
        ps.execute();
        return true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
    }


    }
}
