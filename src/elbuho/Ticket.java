package elbuho;

public class Ticket {
    private Pasajero pasajero;
    private Ruta ruta;
    private ServiciosBase servicio;

    public Ticket(Pasajero pasajero, Ruta ruta, ServiciosBase servicio) {
        this.pasajero = pasajero;
        this.ruta = ruta;
        this.servicio = servicio;
    }

    public double calcularCostoFinal() {
        return ruta.getPrecioBase() * servicio.calcularRecargo();
    }

    public void imprimirTicket() {
        System.out.println("----- TICKET -----");
        System.out.println("Pasajero: " + pasajero.getNombre());
        System.out.println("Cédula: " + pasajero.getCedula());
        System.out.println("Ruta: " + ruta.getDescripcion());
        System.out.println("Asiento: " + servicio.getAsiento());
        System.out.println("Maletas: " + servicio.getMaletas());
        System.out.println("Costo Total: $" + String.format("%.2f", calcularCostoFinal()));
        if (servicio instanceof VIP) {
            System.out.println("Servicios VIP: " + ((VIP) servicio).getServiciosAdicionales());
        }
        System.out.println("------------------");
    }
}

