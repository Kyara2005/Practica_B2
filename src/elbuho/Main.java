package elbuho;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Ingreso de datos del pasajero
        System.out.print("Nombre del pasajero: ");
        String nombre = sc.nextLine();

        System.out.print("Cédula del pasajero: ");
        String cedula = sc.nextLine();

        Pasajero pasajero = new Pasajero(nombre, cedula);

        List<Ruta> rutas = Arrays.asList(
                new Ruta("Quito", "Guayaquil", 20),
                new Ruta("Quito", "Tulcán", 17.5),
                new Ruta("Quito", "Puyo", 15),
                new Ruta("Quito", "Riobamba", 17.5),
                new Ruta("Guayaquil", "Quito", 20),
                new Ruta("Tulcán", "Quito", 17.5),
                new Ruta("Puyo", "Quito", 15),
                new Ruta("Riobamba", "Quito", 17.5)
        );

        System.out.println("Seleccione una ruta:");
        for (int i = 0; i < rutas.size(); i++) {
            System.out.println((i + 1) + ". " + rutas.get(i).getDescripcion() +
                    " ($" + rutas.get(i).getPrecioBase() + ")");
        }
        int opcionRuta = sc.nextInt();
        Ruta rutaSeleccionada = rutas.get(opcionRuta - 1);
        sc.nextLine(); // limpiar buffer

        // 3. Tipo de servicio
        System.out.print("Tipo de servicio (1. Normal, 2. VIP): ");
        int tipoServicio = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("Tipo de asiento (ventana/pasillo/adelante/final): ");
        String asiento = sc.nextLine();

        System.out.print("¿Cuántas maletas llevará?: ");
        int maletas = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        ServiciosBase servicio;

        if (tipoServicio == 1) {
            servicio = new Normal(asiento, maletas);
        } else {
            List<String> serviciosAdicionales = new ArrayList<>();
            for (int i = 1; i <= 2; i++) {
                System.out.print("Ingrese servicio VIP adicional (Televisión, internet y otros)#" + i + ": ");
                serviciosAdicionales.add(sc.nextLine());
            }
            servicio = new VIP(asiento, maletas, serviciosAdicionales);
        }

        Ticket ticket = new Ticket(pasajero, rutaSeleccionada, servicio);

        System.out.println();
        ticket.imprimirTicket();

        sc.close();
    }
}
