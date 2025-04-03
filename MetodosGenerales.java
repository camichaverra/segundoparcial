package segundoparcial;

    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;
    import java.util.Stack;
    public class MetodosGenerales {
        public void ingresarComputador(Scanner sc, Stack<objcomputador> pila) {
            System.out.println("Ingrese los datos del Computador:");
            System.out.print("Serial: ");
            String serial = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Precio: ");
            double precio = validarDouble(sc);
            System.out.print("Memoria RAM (GB): ");
            int ram = validarInt(sc);
            System.out.print("Disco Duro (GB): ");
            int disco = validarInt(sc);
            pila.push(new objcomputador(serial, marca, precio, "", true, ram, disco));
            System.out.println("Computador ingresado correctamente.");
        }
        
        public void ingresarTablet(Scanner sc, Queue<objtablet> cola) {
            System.out.println("Ingrese los datos de la Tablet:");
            System.out.print("Serial: ");
            String serial = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Precio: ");
            double precio = validarDouble(sc);
            System.out.print("Tamaño Pantalla (pulgadas): ");
            double tamano = validarDouble(sc);
            cola.add(new objtablet(serial, marca, precio, "", true, tamano));
            System.out.println("Tablet ingresada correctamente.");
        }
        
        public void prestarComputador(Scanner sc, Stack<objcomputador> pila) {
            if (pila.isEmpty()) {
                System.out.println("No hay computadores disponibles.");
                return;
            }
            
            System.out.println("Lista de computadores disponibles:");
            for (objcomputador pc : pila) {
                if (pc.isDisponible()) {
                    System.out.println("Serial: " + pc.getSerial() + " - Marca: " + pc.getMarca());
                }
            }
            
            System.out.print("Ingrese el serial del computador a prestar: ");
            String serialBuscado = sc.nextLine();
            
            Stack<objcomputador> aux = new Stack<>();
            boolean encontrado = false;
            while (!pila.isEmpty()) {
                objcomputador pc = pila.pop();
                if (pc.getSerial().equalsIgnoreCase(serialBuscado) && pc.isDisponible()) {
                    System.out.print("Ingrese el nombre del usuario: ");
                    pc.setNombreUsuario(sc.nextLine());
                    pc.setDisponible(false);
                    System.out.println("Computador prestado a " + pc.getNombreUsuario());
                    encontrado = true;
                }
                aux.push(pc);
            }
            
            while (!aux.isEmpty()) {
                pila.push(aux.pop());
            }
            
            if (!encontrado) {
                System.out.println("No se encontró un computador disponible con ese serial.");
            }
        }
        
        public void prestarTablet(Scanner sc, Queue<objtablet> cola) {
            if (cola.isEmpty()) {
                System.out.println("No hay tablets disponibles.");
                return;
            }
            
            System.out.println("Lista de tablets disponibles:");
            for (objtablet tablet : cola) {
                if (tablet.isDisponible()) {
                    System.out.println("Serial: " + tablet.getSerial() + " - Marca: " + tablet.getMarca());
                }
            }
            
            System.out.print("Ingrese el serial de la tablet a prestar: ");
            String serialBuscado = sc.nextLine();
            
            Queue<objtablet> aux = new java.util.LinkedList<>();
            boolean encontrada = false;
            while (!cola.isEmpty()) {
                objtablet tablet = cola.poll();
                if (tablet.getSerial().equalsIgnoreCase(serialBuscado) && tablet.isDisponible()) {
                    System.out.print("Ingrese el nombre del usuario: ");
                    tablet.setNombreUsuario(sc.nextLine());
                    tablet.setDisponible(false);
                    System.out.println("Tablet prestada a " + tablet.getNombreUsuario());
                    encontrada = true;
                }
                aux.add(tablet);
            }
            
            while (!aux.isEmpty()) {
                cola.add(aux.poll());
            }
            
            if (!encontrada) {
                System.out.println("No se encontró una tablet disponible con ese serial.");
            }
        }
    
    
        
       public void devolverTablet(Scanner sc, Queue<objtablet> cola) {
    if (cola.isEmpty()) {
        System.out.println("No hay tablets prestadas.");
        return;
    }

    System.out.println("Lista de tablets prestadas:");
    for (objtablet tablet : cola) {
        if (!tablet.isDisponible()) {
            System.out.println("Serial: " + tablet.getSerial() + ", Prestada a: " + tablet.getNombreUsuario());
        }
    }

    System.out.print("Ingrese el serial de la tablet a devolver: ");
    String serialBuscado = sc.nextLine();

    Queue<objtablet> tempQueue = new LinkedList<>();
    objtablet tabletEncontrada = null;

    while (!cola.isEmpty()) {
        objtablet tablet = cola.poll();
        if (tablet.getSerial().equalsIgnoreCase(serialBuscado) && !tablet.isDisponible()) {
            tabletEncontrada = tablet;
            break;
        }
        tempQueue.add(tablet);
    }

    while (!tempQueue.isEmpty()) {
        cola.add(tempQueue.poll());
    }

    if (tabletEncontrada == null) {
        System.out.println("No se encontró una tablet prestada con ese serial.");
        return;
    }

    tabletEncontrada.setNombreUsuario("");
    tabletEncontrada.setDisponible(true);
    cola.add(tabletEncontrada);
    System.out.println("Tablet devuelta correctamente.");
}

public void devolverComputador(Scanner sc, Stack<objcomputador> pila) {
    if (pila.isEmpty()) {
        System.out.println("No hay computadores prestados.");
        return;
    }

    System.out.println("Lista de computadores prestados:");
    for (objcomputador pc : pila) {
        if (!pc.isDisponible()) {
            System.out.println("Serial: " + pc.getSerial() + ", Prestado a: " + pc.getNombreUsuario());
        }
    }

    System.out.print("Ingrese el serial del computador a devolver: ");
    String serialBuscado = sc.nextLine();

    Stack<objcomputador> tempStack = new Stack<>();
    objcomputador pcEncontrado = null;

    while (!pila.isEmpty()) {
        objcomputador pc = pila.pop();
        if (pc.getSerial().equalsIgnoreCase(serialBuscado) && !pc.isDisponible()) {
            pcEncontrado = pc;
            break;
        }
        tempStack.push(pc);
    }

    while (!tempStack.isEmpty()) {
        pila.push(tempStack.pop());
    }

    if (pcEncontrado == null) {
        System.out.println("No se encontró un computador prestado con ese serial.");
        return;
    }

    pcEncontrado.setNombreUsuario("");
    pcEncontrado.setDisponible(true);
    pila.push(pcEncontrado);
    System.out.println("Computador devuelto correctamente.");
}

        
        
        private double validarDouble(Scanner sc) {
            while (!sc.hasNextDouble()) {
                System.out.println("Error: Ingrese un valor válido.");
                sc.next();
            }
            return sc.nextDouble();
        }
        
        private int validarInt(Scanner sc) {
            while (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un número entero válido.");
                sc.next();
            }
            return sc.nextInt();
        }
        public void modificarComputador(Scanner sc, Stack<objcomputador> pilaComputadores) {
            if (pilaComputadores.isEmpty()) {
                System.out.println("No hay computadores registrados.");
                return;
            }
        
            System.out.print("Ingrese el serial del computador a modificar: ");
            String serialBuscado = sc.nextLine();
            
            boolean encontrado = false;
            for (objcomputador pc : pilaComputadores) {
                if (pc.getSerial().equalsIgnoreCase(serialBuscado)) {
                    encontrado = true;
                    System.out.println("Computador encontrado. Ingrese los nuevos datos:");
        
                    System.out.print("Nueva marca: ");
                    pc.setMarca(sc.nextLine());
        
                    System.out.print("Nuevo precio: ");
                    pc.setPrecio(validarDouble(sc));
        
                    System.out.print("Nueva memoria RAM (GB): ");
                    pc.setMemoriaRAM(validarInt(sc));
        
                    System.out.print("Nuevo tamaño de disco duro (GB): ");
                    pc.setDiscoDuro(validarInt(sc));
        
                    System.out.println("Computador modificado correctamente.");
                    break;
                }
            }
        
            if (!encontrado) {
                System.out.println("No se encontró un computador con ese serial.");
            }
        }
        public void modificarTablet(Scanner sc, Queue<objtablet> colaTablets) {
            if (colaTablets.isEmpty()) {
                System.out.println("No hay tablets registradas.");
                return;
            }
        
            System.out.print("Ingrese el serial de la tablet a modificar: ");
            String serialBuscado = sc.nextLine();
            
            boolean encontrada = false;
            for (objtablet tablet : colaTablets) {
                if (tablet.getSerial().equalsIgnoreCase(serialBuscado)) {
                    encontrada = true;
                    System.out.println("Tablet encontrada. Ingrese los nuevos datos:");
        
                    System.out.print("Nueva marca: ");
                    tablet.setMarca(sc.nextLine());
        
                    System.out.print("Nuevo precio: ");
                    tablet.setPrecio(validarDouble(sc));
        
                    System.out.print("Nuevo tamaño de pantalla: ");
                    tablet.setTamañoPantalla(validarDouble(sc));
        
                    System.out.println("Tablet modificada correctamente.");
                    break;
                }
            }
        
            if (!encontrada) {
                System.out.println("No se encontró una tablet con ese serial.");
            }
        }
        
       
    }
