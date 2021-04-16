/**
 * @author Oscar Estrada 20565
 *
 */
public class BinaryTree {

    Nodo root;//Para ubicar la raiz
    //word es el key y trans la traduccion

    /**
     *
     * @param word la palabra para agregar
     * @param trans la traduccion de esa palabra
     */
    public void addNodo(String word, Traduccion tr){
        Nodo newNodo = new Nodo(word, tr);

        if(root == null){
            root = newNodo;//si esta vacio se crea denomina root a la primera palabra
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
     * @param focusNodo se ingresa el nodo raiz del arbol
     *                  Imprime las palabras en orden alfabetico
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
     * @param word la palabra que estamos buscando
     * @return la traduccion de esa palabra
     */
    public Traduccion findNodo(String word){
        Nodo focusNodo = root;

        while(!focusNodo.principal.equals(word)){
            int compare = word.compareTo(focusNodo.principal);
            if(compare < 0){
                focusNodo = focusNodo.left;
            }
            else{
                focusNodo = focusNodo.right;
            }
            if(focusNodo == null){
                return null;
            }
        }
        return focusNodo.getValue();
    }

}
