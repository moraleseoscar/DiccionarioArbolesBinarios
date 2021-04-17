import java.util.HashMap;

/**
 * @author Oscar Estrada 20565
 *
 */
public class Nodo {
    protected String principal; // value associated with node
    protected Traduccion traduccion;
	protected Nodo left, right; // children of node
	
	//Constructor
	public Nodo (String principal, Traduccion tr) {
		this.principal = principal;
		this.traduccion = tr;
		this.left = this.right = null;
	}
	
	/**
	 * @return traduccion
	 *
	 */
	public Traduccion getValue(){
	    return traduccion;
	}

	@Override
	public String toString() {
		return "Palabra=" + principal + ", Traducciones= " + traduccion.getEnglish() + " - " + traduccion.getSpanish() + " - " + traduccion.getFrench();
	}

}
