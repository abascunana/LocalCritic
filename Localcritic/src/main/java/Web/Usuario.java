package Web;


import java.io.Serializable;

public class Usuario{
/**LoginBean= Usuario
 * LoginDao= Base
 * LoginServlet= Login**/
	


		private String nombreUsuario;
	    private String contrasenaUsuario;
	    private String tipoUsuario;
	    private String emailUsuario;
		public String getNombreUsuario() {
			return nombreUsuario;
		}
		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}
		public String getContrasenaUsuario() {
			return contrasenaUsuario;
		}
		public void setContrasenaUsuario(String contrasenaUsuario) {
			this.contrasenaUsuario = contrasenaUsuario;
		}
		public String getTipoUsuario() {
			return tipoUsuario;
		}
		public void setTipoUsuario(String tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}
		public String getEmailUsuario() {
			return emailUsuario;
		}
		public void setEmailUsuario(String emailUsuario) {
			this.emailUsuario = emailUsuario;
		}


			
		
		
		
		public String buscarUsuario(String nombreDeUsuario) {
			
			
			return nombreDeUsuario;
			}
	
	

public String eliminarUsuario() {
	
	
	return nombreUsuario;}

}


