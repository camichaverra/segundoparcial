package segundoparcial;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;


    
    public class Menu {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Stack<objcomputador> pilaComputadores = new Stack<>();
            Queue<objtablet> colaTablets = new LinkedList<>();
            MetodosGenerales metodos = new MetodosGenerales();
            boolean bandera = true;
            int opt = 0;
    
            while (bandera) {
                System.out.println("\nBienvenidos al Departamento de Sistemas");
                System.out.println("Seleccione qué desea hacer:");
                System.out.println("1. Ingresar Computador");
                System.out.println("2. Ingresar Tablet");
                System.out.println("3. Prestar Computador");
                System.out.println("4. Prestar Tablet");
                System.out.println("5. Devolver Computador");
                System.out.println("6. Devolver Tablet");
                System.out.println("7. Modificar Computador");
                System.out.println("8. Modificar Tablet");
                System.out.println("9. Salir");
                System.out.print("Ingrese una opción: ");
    
                while (!sc.hasNextInt()) {
                    System.out.println("Error: Ingrese un valor numérico válido.");
                    sc.next();
                    System.out.print("Ingrese una opción: ");
                }
                opt = sc.nextInt();
                sc.nextLine();
    
                switch (opt) {
                    case 1:
                        metodos.ingresarComputador(sc, pilaComputadores);
                        break;
                    case 2:
                        metodos.ingresarTablet(sc, colaTablets);
                        break;
                    case 3:
                        metodos.prestarComputador(sc, pilaComputadores);
                        break;
                    case 4:
                        metodos.prestarTablet(sc, colaTablets);
                        break;
                    case 5:
                        metodos.devolverComputador(sc, pilaComputadores);
                        break;
                    case 6:
                        metodos.devolverTablet(sc, colaTablets);
                        break;
                        case 7:
                        metodos.modificarComputador(sc, pilaComputadores);
                        break;
                    case 8:
                        metodos.modificarTablet(sc, colaTablets);
                        break;
                    case 9:
                        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");                    
                        bandera = false;
                        break;
                    default:
                        System.out.println("Opción inválida, intente nuevamente.");
                }
            }
            sc.close();
        }
    }