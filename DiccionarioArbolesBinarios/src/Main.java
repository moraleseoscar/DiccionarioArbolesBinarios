import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Oscar Estrada 20565
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DictionaryController dic = new DictionaryController();

        Scanner scanner = new Scanner(System.in);
        int input;

        while(true){
        	System.out.println("");
        	System.out.println("+----------------------------+");
            System.out.println("|          Escalafon         |");
            System.out.println("+----------------------------+");
            System.out.println("");
            System.out.println("1. Traducir palabra.");
            System.out.println("2. Ordenar arboles.");
            System.out.println("3. Traducir archivo con oracion.");
            System.out.println("4. Salir.");
            input = getSeleccion("Ingrese el numero de su seleccion: ", 1, 3);
            System.out.println("");
            
            if(input == 1){
            	System.out.println("Ingrese la palabra a traducir: ");
            	String word = scanner.nextLine();
            	System.out.print("\nLenguajes disponibles:\n1. English\n2. Spanish\n3. French\n");
                int from = getSeleccion("Seleccione el numero del lenguaje de la palabra escrita:\n ", 1, 3);
                int to = getSeleccion("Seleccione a que lenguaje la quiere traducir:\n ", 1, 3);
                String palTra = dic.traducir(word.toLowerCase(), from, to); 
                if(palTra != null) {
                	System.out.println("\nTraducida: " + palTra + "\n");
                }else {
                	System.out.println("\nLa palabra ingresada no se encuentra en el diccionario en la forma que desea traducirla.\n");
                }
            	
            }else if(input == 2){
            	System.out.print("\nLenguajes disponibles:\n1. English\n2. Spanish\n3. French\n");
                int language = getSeleccion("Seleccione el numero del arbol que desea ver: ", 1, 3);
                System.out.print("\nPalabras ordenadas		EN|ES|FR\n");
                System.out.print("=========================================\n");
	            dic.viewTree(language);
            }else if(input == 3){
            	System.out.print("\nLenguajes disponibles:\n1. English\n2. Spanish\n3. French\n");
                int from = getSeleccion("Seleccione el numero del lenguaje en que se encuentra escrito el archivo:\n ", 1, 3);
                int to = getSeleccion("Seleccione a que lenguaje al que se requiere traducir:\n ", 1, 3);
                String palTra = dic.traducirArchivo(from, to); 
                if(palTra != null) {
                	System.out.println("\nTraducida: " + palTra + "\n");
                }else {
                	System.out.println("\nLa palabra ingresada no se encuentra en el diccionario en la forma que desea traducirla.\n");
                }
            	
            }else if(input == 4){
                System.exit(0);
            }
            }           
       }
	
	/** 
     * @param texto Texto del print
     * @param min Minimo valor permitido de seleccion
     * @param max Maximo valor permitido de seleccion
     * @return int Devuelve el valor seleccionado.
     */
    private static int getSeleccion(String texto, int min, int max){
        Scanner teclado = new Scanner(System.in);
        String entrada="";
        
        int num = 0;
        boolean ok = true;
        
        do{
        	System.out.print(texto);
            entrada = teclado.nextLine();
            try{
                num = Integer.parseInt(entrada);
                if(num < min || num > max) {
                	System.out.println("Seleccione un numero dentro del rango. Intente de nuevo.");
                    ok = false;
                }else {
                	ok = true;
                }
            }
            catch(Exception e){
                System.out.println(entrada + " no es un numero. Intente de nuevo.");
                ok = false;
            }
        }while (!ok); 
        
        return num;
    }
}
