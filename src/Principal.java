
// Importamos necesarias
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

// Creamos la clase principal
public class Principal {
    // Creamos la lista de alimentos
    private static List<Alimento> alimentos = new ArrayList<>();
    // Creamos el lector de datos
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

// Creamos el método principal
    public static void main(String[] args) {
        int opcion = 0;
        // Creamos el menú
        do {
            // Mostramos el menú
            System.out.println("[1] Agregar un nuevo producto\n[2] Ver los productos disponibles\n[3] Verificar la fecha de caducidad de un producto\n[4] Salir");
            try {
                // Leemos la opción
                opcion = Integer.parseInt(reader.readLine());
                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        verProductos();
                        break;
                    case 3:
                        verificarCaducidad();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.err.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.err.println("Hemos tenido un error... " + e.getMessage());
            }
        } while (opcion != 4);
    }

    // Creamos el método para agregar un producto
    private static void agregarProducto() {
        // Creamos la variable para validar los datos
    boolean datosValidos;
    // Creamos el ciclo para agregar un producto
    do {
        datosValidos = true;
        try {
            // Leemos los datos
            System.out.println("Ingrese el nombre del producto:");
            String nombre = reader.readLine();

            // Leemos el precio unitario
            System.out.println("Ingrese el precio unitario del producto:");
            double precioUnitario = Double.parseDouble(reader.readLine());

            // Leemos la marca
            System.out.println("Ingrese la marca del producto:");
            String marca = reader.readLine();

            // Leemos la cantidad en inventario
            System.out.println("Ingrese la cantidad en inventario del producto:");
            int cantidadInventario = Integer.parseInt(reader.readLine());

            // Leemos la fecha de vencimiento
            System.out.println("Ingrese la fecha de vencimiento del producto (formato YYYY-MM-DD):");
            LocalDate fechaVencimiento = LocalDate.parse(reader.readLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Creamos el nuevo alimento
            Alimento nuevoAlimento = new Alimento(nombre, precioUnitario, marca, cantidadInventario, fechaVencimiento);
            alimentos.add(nuevoAlimento);

            System.out.println("Producto agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: El precio unitario y la cantidad en inventario deben ser números. Intente de nuevo.");
            datosValidos = false;
        } catch (DateTimeParseException e) {
            System.err.println("Error: La fecha de vencimiento debe estar en el formato YYYY-MM-DD. Intente de nuevo.");
            datosValidos = false;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            datosValidos = false;
        }
    } while (!datosValidos);
}

    // Creamos el método para ver los productos
    private static void verProductos() {
        // Mostramos los productos
    System.out.printf("%-10s %-20s %-15s %-10s %-20s %-15s%n", "ID", "Nombre", "Precio Unitario", "Marca", "Cantidad Inventario", "Fecha Vencimiento");
    // Recorremos los alimentos
    for (Alimento alimento : alimentos) {
        // Mostramos los datos del alimento
        System.out.printf("%-10s %-20s %-15s %-10s %-20s %-15s%n",
                          alimento.getId(),
                          alimento.getNombre(),
                          alimento.getPrecioUnitario(),
                          alimento.getMarca(),
                          alimento.getCantidadInventario(),
                          alimento.getFechaVencimiento());
    }
}

// Creamos el método para verificar la caducidad
private static void verificarCaducidad() {
        // Obtenemos la fecha actual
    LocalDate fechaActual = LocalDate.now();
    // Recorremos los alimentos
    for (Alimento alimento : alimentos) {
        // Verificamos si el alimento está vencido
        if (alimento.getFechaVencimiento().isBefore(fechaActual)) {
            // Mostramos el mensaje
            System.err.println("El producto " + alimento.getNombre() + " está vencido y debe ser retirado del inventario.");
        } else {
            // Calculamos los días hasta la fecha de vencimiento
            long diasHastaVencimiento = fechaActual.until(alimento.getFechaVencimiento()).getDays();
            System.out.println("El producto " + alimento.getNombre() + " vence en " + diasHastaVencimiento + " días.");
        }
    }
}
}