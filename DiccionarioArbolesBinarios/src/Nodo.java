import java.util.HashMap;

/**
 * @author ASUS
 *
 */
public class Nodo {
    protected String principal; // value associated with node
    protected Traduccion traduccion;
	protected Nodo left, right; // children of node
	
	public Nodo (String principal, Traduccion tr) {
		this.principal = principal;
		this.traduccion = tr;
		this.left = this.right = null;
	}
	
	public Traduccion getValue(){
	    return traduccion;
	}

	@Override
	public String toString() {
		return "Nodo [Palabra=" + principal + ", traducciones=" + traduccion.getEnglish() + " " + traduccion.getSpanish() + " " + traduccion.getFrench();
	}

}
