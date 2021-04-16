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

		BinaryTree myTree = new BinaryTree();
		Traduccion tr = new Traduccion();
		
		tr.setEnglish("Hi");
		tr.setSpanish("Hola");
		tr.setFrench("Oui");

        Scanner scanner = new Scanner(System.in);
        int input;

        while(true){
        	System.out.println("");
        	System.out.println("+----------------------------+");
            System.out.println("|          Escalafon         |");
            System.out.println("+----------------------------+");
            System.out.println("");
            System.out.println("1. Ingresar una nueva palabra.");
            System.out.println("2. Probar si promedio de desvinculados de secundaria es mayor a valor dado.");
            System.out.println("3. Mostrar si 50% de los aspirantes es mayor a 80 puntos.");
            System.out.println("4. Salir.");
            input = getSeleccion("Ingrese el numero de su seleccion: ", 1, 4);
            System.out.println("");
            
            if(input == 1){
                System.out.println("Enter a new string: ");
                String word = scanner.next().toUpperCase();
	            myTree.addNodo(word, tr);
	            System.out.println("Inserted " + "'" + word + "'" + " into tree");
            }else if(input == 2){
            	System.out.println("Enter a string to search: ");  
            }else if(input == 3){
	            System.out.println("Display Tree: ");
	            myTree.inOrder(myTree.root);
	
            }else if(input == 4){
                System.exit(0);//exit program
            }
            	System.out.println("\nEnter another option");
            }           
       }
	
	/** 
     * @param texto
     * @param min
     * @param max
     * @return int
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
