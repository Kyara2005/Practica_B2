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
        double base = ruta.getPrecioBase() * servicio.calcularRecargo();
        double extraMaletas = servicio.MaletasExtra();
        return base + extraMaletas;
    }

    public void imprimirTicket() {
        System.out.println("----- TICKET -----");
        System.out.println("Pasajero: " + pasajero.getNombre());
        System.out.println("Cédula: " + pasajero.getCedula());
        System.out.println("Ruta: " + ruta.getDescripcion());
        System.out.println("Servicio: " + servicio.getTipoServicio());
        System.out.println("Asiento: " + servicio.getAsiento());
        System.out.println("Maletas: " + servicio.getMaletas());
        System.out.printf("Costo del pasaje: $%.2f%n", ruta.getPrecioBase());
        System.out.printf("Recargo por tipo de servicio: %.0f%%%n", (servicio.calcularRecargo() - 1) * 100);
        System.out.printf("Costo adicional por maletas extra: $%.2f%n", servicio.MaletasExtra());
        System.out.printf("Total a pagar: $%.2f%n", calcularCostoFinal());

        if (servicio.getTipoServicio().equals("VIP")) {
            VIP vip = (VIP) servicio;
            System.out.println("Servicios VIP incluidos: " + vip.getServiciosAdicionales());
        }

        System.out.println("------------------");
    }
}