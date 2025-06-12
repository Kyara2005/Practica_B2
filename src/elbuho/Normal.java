package elbuho;

public class Normal extends ServiciosBase {

    public Normal(String asiento, int maletas) {
        super(asiento, maletas);
    }

    @Override
    public double calcularRecargo() {
        return 1.0; // sin recargo
    }
}

