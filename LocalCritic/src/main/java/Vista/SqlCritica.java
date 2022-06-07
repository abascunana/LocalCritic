package Vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlCritica extends Conexion{
	
	public boolean registrarCritica(Critica cri){
		//Inserta la obra en la base de datos
		PreparedStatement ps = null;
		Connection pepe = getConexion();		
		String sql = "INSERT INTO criticas (valCritica,textoCritica,upvotes,downvotes,usuarioID,obraID) VALUES(?,?,?,?,?,?)";
		
		try {
			ps = pepe.prepareStatement(sql);
			ps.setLong(1,cri.getValCritica());
			ps.setString(2,cri.getTextoCritica());
			ps.setLong(3,0);
			ps.setLong(4,0);
			ps.setLong(5,cri.getUsuarioID());
			ps.setLong(6,cri.getObraID());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		//Consigue el id de la obra
		}
	public static int BuscarID(String obra) throws SQLException {
	    PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select obraID from obras where tituloObra = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setString(1,obra);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getInt(1);}
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return 1;
	    }
	    return 0;

	    //Consigue el nombre de la obra con su id
	}
	public static String conseguirNombre(int id){
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select tituloObra from obras where obraID= ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getString(1);}
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return "nada";
	    }
	    return "nada";

	    //Consigue el usuario con su id 
	}
	public static String conseguirUsuario(int id) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select nombreUsuario from usuarios where usuarioID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getString(1);}
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return "nada";
	    }
	    return "nada";

	    //Cosigue el id del usuario con el Nombre
	}
	public static int conseguirIdUsuario(String Nombre) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select usuarioID from usuarios where nombreUsuario = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setString(1,Nombre);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getInt(1);}
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return 0;
	    }
	    return 0;

	    //Actualiza los upvotes en la base de datos
	}
	public static void calcularUpvotes(int id) throws SQLException {
	    PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    String sql = "update criticas set upvotes = upvotes +1 where criticaID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        ps.execute();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	  //Actualiza los downvotes en la base de datos
	}
	public static void calcularDownvotes(int id) throws SQLException {
	    PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    String sql = "update criticas set downvotes = downvotes +1 where criticaID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        ps.execute();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    //Calcula la nota media de la obra
	}
	public static int calcularMediaObra(int id) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select sum(valCritica)/(select count(*) from criticas where obraID ="+id+")from criticas where obraID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getInt(1);
	            }
	        return 999;
	    }catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		        return 999;
		    }
	    //Actualiza la media de la obra
	    }
	public static void updateMedia(int nota,int peli) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    String sql = "update peliculas set mediaValPelicula = "+nota+" where peliculaID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,peli);
	        ps.execute();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	   //Selecciona el número de críticas que tiene cada usuario
	}
	public static int numCriticas(int id) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select count(*) from criticas where usuarioID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getInt(1);
	            }
	        return 999;
	    }catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		        return 999;
		    }
	    //Actualiza el número de críticas de un usuario
	    }
	public static void UpdateNumCriticas(int id,int criticas) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    String sql = "update usuarios set reviewNum = "+criticas+" where usuarioID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        ps.execute();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	   //Calcula el Karma del usuario
		}
	public static int karma(int id) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    ResultSet rs = null;
	    String sql = "Select sum(upvotes)-sum(downvotes) from criticas where usuarioID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            return rs.getInt(1);
	            }
	        return 999;
	    }catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		        return 999;
		    }
	    //Actualiza el karma del usuario
	    }
	public static void UpdateKarma(int id,int karma) {
		PreparedStatement ps = null;
	    Connection pepe = Conexion.getConexion();
	    String sql = "update usuarios set karma = "+karma+" where usuarioID = ?";

	    try {
	        ps = pepe.prepareStatement(sql);
	        ps.setInt(1,id);
	        ps.execute();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    //Calcula la media de valoración del usuario
	}
	 public static int MediaValUsuario(int obraid,int UsuarioID) {
		 PreparedStatement ps = null;
		    Connection pepe = Conexion.getConexion();
		    ResultSet rs = null;
		    String sql = "Select sum(valCritica)/(select count(*) from criticas where UsuarioID ="+UsuarioID+")from criticas where UsuarioID = ?";

		    try {
		        ps = pepe.prepareStatement(sql);
		        ps.setInt(1,UsuarioID);
		        rs = ps.executeQuery();
		        if(rs.next()) {
		            return rs.getInt(1);
		            }
		        return 999;
		    }catch (SQLException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			        return 999;
			    }
		    //Actualiza la media de valoración del usuario
		}
	 public static void UpdateMediaValUsuario(int id,int media) {
			PreparedStatement ps = null;
		    Connection pepe = Conexion.getConexion();
		    String sql = "update usuarios set mediaValUsuario = "+media+" where usuarioID = ?";

		    try {
		        ps = pepe.prepareStatement(sql);
		        ps.setInt(1,id);
		        ps.execute();
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		}
	}
	
	

	


