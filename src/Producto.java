// clase Producto
public class Producto {
    // Creamos el contador de id
    private static int contadorId = 0;

    // Creamos los atributos
    private int id;
    private String nombre;
    private double precioUnitario;
    private String marca;
    private int cantidadInventario;

    // Creamos el constructor
    public Producto(String nombre, double precioUnitario, String marca, int cantidadInventario) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.marca = marca;
        this.cantidadInventario = cantidadInventario;
    }

    // metodos gets y sets
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }
    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }
}