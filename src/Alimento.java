//importamos la libreria LocalDate
import java.time.LocalDate;

// Creamos la clase Alimento
public class Alimento extends Producto {
    private LocalDate fechaVencimiento;

    // Creamos el constructor
    public Alimento(String nombre, double precioUnitario, String marca, int cantidadInventario, LocalDate fechaVencimiento) {

        super(nombre, precioUnitario, marca, cantidadInventario);
        this.fechaVencimiento = fechaVencimiento;
    }


    // metodos gets y sets
    public LocalDate getFechaVencimiento() {
            return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
            this.fechaVencimiento = fechaVencimiento;
    }

}