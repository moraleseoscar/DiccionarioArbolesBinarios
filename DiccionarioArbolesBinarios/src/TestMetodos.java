import junit.framework.TestCase;

/**
 * @author Oscar Estrada 20565
 *
 */
public class TestMetodos extends TestCase{
	private DictionaryController dic;
	private Traduccion tra;
	
	public void escenario() {
		dic = new DictionaryController("test");
		tra = new Traduccion();
	}
	
	/**
	 * Prueba para ver si agrega
	 *
	 */
	public void testAgregar() {
		escenario();
		
		dic.crearNodo("yes,si,oui", "en");
		tra.setEnglish("yes");
		tra.setSpanish("si");
		tra.setFrench("oui");
		assertEquals(dic.treeEnglish.root.principal, "yes");
		assertEquals(dic.treeEnglish.root.getValue().getFrench(), "oui");
	}
	
	/**
	 * @author Prueba para traducir
	 *
	 */
	public void testTraducir() {
		escenario();
		dic.crearNodo("yes,si,oui", "en");
		tra.setEnglish("yes");
		tra.setSpanish("si");
		tra.setFrench("oui");
		assertEquals(dic.traducir("yes", 1, 2), "si");
	}
}
