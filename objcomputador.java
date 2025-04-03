package segundoparcial;
public class objcomputador {
    private String serial;
    private String marca;
    private double precio;
    private String nombreUsuario;
    private boolean disponible;
    private int memoriaRAM;
    private int discoDuro;

    public objcomputador(String serial, String marca, double precio, String nombreUsuario, boolean disponible, int memoriaRAM, int discoDuro) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.nombreUsuario = nombreUsuario;
        this.disponible = disponible;
        this.memoriaRAM = memoriaRAM;
        this.discoDuro = discoDuro;
    }
    public objcomputador() {
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public void mostrarInfo() {
        System.out.println("Serial: " + serial);
        System.out.println("Marca: " + marca);
        System.out.println("Precio: " + precio);
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
        System.out.println("Memoria RAM: " + memoriaRAM + " GB");
        System.out.println("Disco Duro: " + discoDuro + " GB");
    }
}