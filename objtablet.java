package segundoparcial;

public class objtablet {

    private String serial;
    private String marca;
    private double precio;
    private String nombreUsuario;
    private boolean disponible;
    private double tamañoPantalla;

    public objtablet(String serial, String marca, double precio, String nombreUsuario, boolean disponible, double tamañoPantalla) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.nombreUsuario = nombreUsuario;
        this.disponible = disponible;
        this.tamañoPantalla = tamañoPantalla;
    }
    public objtablet() {
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

    public double getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setTamañoPantalla(double tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }

    public void mostrarInfo() {
        System.out.println("Serial: " + serial);
        System.out.println("Marca: " + marca);
        System.out.println("Precio: " + precio);
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
        System.out.println("Tamaño Pantalla: " + tamañoPantalla + " pulgadas");
    }
}