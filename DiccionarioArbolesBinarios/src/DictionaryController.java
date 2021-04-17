import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Oscar Estrada 20565
 *
 */
public class DictionaryController {
	BinaryTree treeSpanish = new BinaryTree();
	BinaryTree treeEnglish = new BinaryTree();
	BinaryTree treeFrench = new BinaryTree();
	
	//Constructor
	public DictionaryController() {
		createBinaryTree();
	}
	
	//Constructor to tests
	public DictionaryController(String test) {}
	
	/**
	 * Lee el documento y crea los arboles desde el inicio.
	 *
	 */
	public void createBinaryTree() {
		// TODO Auto-generated method stub

		String texto = new String();

		try {
			FileReader fr = new FileReader("./docs/words.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;

			while((s = entrada.readLine()) != null) {
				s= s.toLowerCase();
				crearNodo(s, "es");
				crearNodo(s, "en");
				crearNodo(s, "fr");
			}
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);}
		catch(java.io.IOException ioex) {}
	}

	/**
	 * @param s Es la linea a hacer split con todas las traducciones
	 * @param language es el lenguaje key con el que se guardara en el arbol
	 *
	 */
	public void crearNodo(String s, String language) {
		String[] temp = s.split(",");
		Traduccion t = new Traduccion();
		
		t.setEnglish(temp[0]);
		t.setSpanish(temp[1]);
		t.setFrench(temp[2]);
		switch(language) {
		case "es":
			treeSpanish.addNodo(temp[1], t);
			break;
		case "en":
			treeEnglish.addNodo(temp[0], t);
			break;
		case "fr":
			treeFrench.addNodo(temp[2], t);
			break;
		}
	}
	
	/**
	 * @param language Es el lenguaje del arbol que se desea visualizar.
	 *
	 */
	public void viewTree(int language) {
		
		switch(language) {
		case 2:
			treeSpanish.inOrder(treeSpanish.root);
			break;
		case 1:
			treeEnglish.inOrder(treeEnglish.root);
			break;
		case 3:
			treeFrench.inOrder(treeFrench.root);
			break;
		}
	}
	
	/**
	 * @param word Palabra a traducir
	 * @param from Lenguaje de donde se traducira.
	 * @param to Lenguaje en el que se requiere traducido.
	 * @return traducida Devuelve la palabra traducida
	 *
	 */
	public String traducir(String word, int from, int to) {
		String traducida = "";
		if(from != to) {
			switch(from) {
			case 2:
				traducida = treeSpanish.findNodo(word, to);
				break;
			case 1:
				traducida = treeEnglish.findNodo(word, to);
				break;
			case 3:
				traducida = treeFrench.findNodo(word, to);
				break;
			}  
		}else {
			traducida = "Intentalo de nuevo, parece que seleccionaste la misma opcion en ambas.";
		}
		return traducida;
	}
	
	/**
	 * @param from Lenguaje de donde se traducira.
	 * @param to Lenguaje en el que se requiere traducido.
	 * @return traducida Devuelve la linea del archivo traducido
	 *
	 */
	public String traducirArchivo(int from, int to) {
		String traducida = "";
		// TODO Auto-generated method stub

		if(from!= to) {
			try {
				FileReader fr = new FileReader("./docs/oracion.txt");
				BufferedReader entrada = new BufferedReader(fr); 
				String s, tempTra;

				while((s = entrada.readLine()) != null) {
					String[] temp = s.split(" ");
					for(int i = 0; i< temp.length; i++) {
						tempTra = traducir(temp[i], from, to);
						if(tempTra != null) {
							traducida = traducida + tempTra + " ";
						}else {
							traducida = traducida + "*" + temp[i] + "* ";
						}
						
					}
				}

			}
			catch(java.io.FileNotFoundException fnfex) {
				System.out.println("Archivo no encontrado: " + fnfex);}
			catch(java.io.IOException ioex) {}
		}else {
			traducida = "Intentalo de nuevo, parece que seleccionaste la misma opcion en ambas.";
		}
		return traducida;
	}
}