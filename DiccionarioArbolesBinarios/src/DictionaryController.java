import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
* @author Oscar Estrada 20565
*
*/
public class DictionaryController {
	
	BinaryTree<HashMap<String, Traduccion>> treeSpanish;
	
	public DictionaryController() {
	}
	
	public void createBinaryTree(String language) {
		// TODO Auto-generated method stub
		
		String texto = new String();
		
		try {
			FileReader fr = new FileReader("./docs/words.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;
			
			while((s = entrada.readLine()) != null) {
				HashMap <String, Traduccion> cratedValueNode = crearNodo(s, language);
				treeSpanish = new BinaryTree(cratedValueNode);
			}
			
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);}
		catch(java.io.IOException ioex) {}
	}
	
	public HashMap<String, Traduccion> crearNodo(String s, String language) {
		String[] temp = s.split(",");
		HashMap <String, Traduccion> Nodo = new HashMap <String, Traduccion>();
		Traduccion t = new Traduccion();
		t.setEnglish(temp[0]);
		t.setSpanish(temp[1]);
		t.setFrench(temp[2]);
		switch(language) {
		case "es":
			Nodo.put(temp[1], t);
			break;
		case "en":
			Nodo.put(temp[0], t);
			break;
		case "fr":
			Nodo.put(temp[2], t);
			break;
		}
		return Nodo;
	}
	
	
}
