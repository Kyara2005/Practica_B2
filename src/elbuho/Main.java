package elbuho;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Datos del pasajero
        System.out.print("Nombre del pasajero: ");
        String nombre = sc.nextLine();
        System.out.print("Cédula: ");
        String cedula = sc.nextLine();
        Pasajero pasajero = new Pasajero(nombre, cedula);

        // Lista de rutas
        Ruta[] rutas = {
                new Ruta("Quito", "Guayaquil", 20),
                new Ruta("Quito", "Tulcán", 17.5),
                new Ruta("Quito", "Puyo", 15),
                new Ruta("Quito", "Riobamba", 17.5),
                new Ruta("Guayaquil", "Quito", 20),
                new Ruta("Tulcán", "Quito", 17.5),
                new Ruta("Puyo", "Quito", 15),
                new Ruta("Riobamba", "Quito", 17.5)
        };

        System.out.println("Rutas disponibles:");
        for (int i = 0; i < rutas.length; i++) {
            System.out.printf("%d. %s ($%.2f)%n", i + 1, rutas[i].getDescripcion(), rutas[i].getPrecioBase());
        }

        System.out.print("Seleccione una ruta (1-" + rutas.length + "): ");
        Ruta ruta = rutas[sc.nextInt() - 1];
        sc.nextLine(); // limpiar

        //Servicio
        System.out.print("Tipo de servicio (1. Normal | 2. VIP): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Tipo de asiento (ventana, pasillo, adelante, final): ");
        String asiento = sc.nextLine();

        System.out.print("Cantidad de maletas (Más de 2 tiene un costo adicional): ");
        int maletas = sc.nextInt();
        sc.nextLine();

        ServiciosBase servicio;

        if (tipo == 1) {
            servicio = new Normal(asiento, maletas);
        } else {
            List<String> extras = new ArrayList<>();
            System.out.print("Servicio VIP adicional 1: ");
            extras.add(sc.nextLine());
            System.out.print("Servicio VIP adicional 2: ");
            extras.add(sc.nextLine());
            servicio = new VIP(asiento, maletas, extras);
        }

        Ticket ticket = new Ticket(pasajero, ruta, servicio);
        ticket.imprimirTicket();
    }
}

