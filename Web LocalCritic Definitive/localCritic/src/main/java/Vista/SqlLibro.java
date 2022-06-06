package Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlLibro extends Conexion {
public boolean registrarLibro(Libro libro){
		
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO libros (ISBN,tituloLibro,sinopsisLibro,generoLibro,escritor,editorial,anoLanzamientoLibro,numPag,ultimaEdicion,mediaValLibro) VALUES(?,?,?,?,?,?,?,?,?,0)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setInt(1,libro.getIsbn());	
			ps.setString(2,libro.getTituloLibro());
			ps.setString(3,libro.getSinopsisLibro());
			ps.setString(4,libro.getGeneroLibro());
			ps.setString(5,libro.getEscritor());
			ps.setString(6,libro.getEditorial());
			ps.setInt(7,libro.getAnoLanzamientoLibro());
			ps.setInt(8,libro.getNumPag());
			ps.setInt(9,libro.getUltimaEdicion());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
			
		}
public int existeLibro(String libro ) {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConexion();
	
	String sql = "Select count(ISBN) from libros where tituloLibro = ?";
	
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1,libro);
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
public int BuscarID(Libro libro) throws SQLException {
    PreparedStatement ps = null;
    Connection pepe = getConexion();
    ResultSet rs = null;
    String sql = "Select ISBN from libros where tituloLibro = ?";

    try {
        ps = pepe.prepareStatement(sql);
        ps.setString(1,libro.getTituloLibro());
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

public boolean InsertarEnObra(Libro libro) throws SQLException {

    PreparedStatement ps = null;
    Connection pepe = getConexion();
    int id = BuscarID(libro);
    String sql  = "INSERT INTO obras (obraID,tituloObra,tipoObra) VALUES(?,?,?)";
    try {
        ps = pepe.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,libro.getTituloLibro());
        ps.setString(3,"libro");
        ps.execute();
        return true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
    }


    }
}