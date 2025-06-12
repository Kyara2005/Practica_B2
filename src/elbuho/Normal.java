package elbuho;

public class Normal extends ServiciosBase {

    public Normal(String asiento, int maletas) {
        super(asiento, maletas);
    }

    @Override
    public double calcularRecargo() {
        return 1.0;
    }

    @Override
    public int maletasIncluidas() {
        return 1;
    }

    @Override
    public String getTipoServicio() {
        return "Normal";
    }
}



