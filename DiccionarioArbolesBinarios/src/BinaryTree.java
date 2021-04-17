/**
 * @author Oscar Estrada 20565
 * Codigo basado en video de Derek Banas: https://www.youtube.com/watch?v=M6lYob8STMI&t=10s
 * Codigo basado tambien en https://www.daniweb.com/programming/software-development/threads/450817/binary-tree-using-strings-and-recursion
 */
public class BinaryTree {

    Nodo root;

    //Constructor
    public BinaryTree() {
    	root = null;
    }

    /**
     *
     * @param word la palabra para agregar
     * @param tr es el objeto con las traducciones de dicha palabra
     */
    public void addNodo(String word, Traduccion tr){
        Nodo newNodo = new Nodo(word, tr);

        if(root == null){
            root = newNodo;
        }
        else{
            Nodo auxiliar = root;
            Nodo padre;
            while (true){
                padre = auxiliar;
                int compare = word.compareTo(auxiliar.principal);
                if(compare < 0){									//CompareTo puede devolver 3 valores:
                	auxiliar = auxiliar.left;						// 							-1 si va antes alfabeticamente (Van a la izquierda del arbol)
                    if(auxiliar == null){							// 							1 si va despues alfabeticamente (Van derecha del arbol)
                        padre.left = newNodo;						// 							0 si es igual (Van derecha del arbol)
                        return;
                    }
                }
                else{
                	auxiliar = auxiliar.right;
                    if(auxiliar == null){
                        padre.right = newNodo;
                        return;
                    }
                }
            }
        }
    }
    /**
     *
     * @param auxiliar que es el nodo del arbol a leer
     * Devuelve los datos en orden alfabetico por la lectura inOrder.
     *                  
     */
    public void inOrder(Nodo auxiliar){
        if(auxiliar != null){
            inOrder(auxiliar.left);
            System.out.println(auxiliar);
            inOrder(auxiliar.right);
        }
    }

    /**
     *
     * @param word La palabra que se busca su traduccion.
     * @param to Es al lenguaje que se desea traducir.
     * @return La palabra traducida al lenguaje que se pide.
     */
    public String findNodo(String word, int to){
        String traducida = "";
    	Nodo auxiliar = root;

        while(!auxiliar.principal.equals(word)){
            int compare = word.compareTo(auxiliar.principal);
            if(compare < 0){
            	auxiliar = auxiliar.left;
            }
            else{
            	auxiliar = auxiliar.right;
            }
            if(auxiliar == null){										
                return null;
            }
        }
        
        switch(to) {
		case 2:
			traducida = auxiliar.traduccion.getSpanish();
			break;
		case 1:
			traducida = auxiliar.traduccion.getEnglish();
			break;
		case 3:
			traducida = auxiliar.traduccion.getFrench();
			break;
		} 
        
        return traducida;
    }

}
