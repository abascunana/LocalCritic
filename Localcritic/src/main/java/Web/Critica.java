package Web;

public class Critica {
	private int valCritica;
	private String textoCritica;
	private int upvote;
	private int downvote;
	
	
	public int getValCritica() {
		return valCritica;
	}
	public void setValCritica(int valCritica) {
		this.valCritica = valCritica;
	}
	public String getTextoCritica() {
		return textoCritica;
	}
	public void setTextoCritica(String textoCritica) {
		this.textoCritica = textoCritica;
	}
	public int getUpvote() {
		return upvote;
	}
	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}
	public int getDownvote() {
		return downvote;
	}
	public void setDownvote(int downvote) {
		this.downvote = downvote;
	}
	
	public int calcularDownvotes() {
		return 0;
	}
	
	public int calcularUpvotes() {
		return 0;
	}
	
	public static String anadirCritica() {
	
		return("Hola");
		
	}
	
	public void eliminarCritica() {
		
	}
}
