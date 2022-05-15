package Web;


import java.io.Serializable;

public class Usuario{
/**LoginBean= Usuario
 * LoginDao= Base
 * LoginServlet= Login**/
	


		private String nombreDeUsuario;
	    private String contrasenaDeUsuario;
	    private String tipoUsuario;
	    private String emailUsuario;
		public String getNombreDeUsuario() {
			return nombreDeUsuario;
		}
		public void setNombreDeUsuario(String nombreDeUsuario) {
			this.nombreDeUsuario = nombreDeUsuario;
		}
		public String getContrasenaDeUsuario() {
			return contrasenaDeUsuario;
		}
		public void setContrasenaDeUsuario(String contrasenaDeUsuario) {
			this.contrasenaDeUsuario = contrasenaDeUsuario;
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
	
	
	return nombreDeUsuario;}

}


