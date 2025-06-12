package elbuho;

public abstract class ServiciosBase {
    protected String asiento;
    protected int maletas;

    public ServiciosBase(String asiento, int maletas) {
        this.asiento = asiento;
        this.maletas = maletas;
    }

    public abstract double calcularRecargo(); // 1.0 si es normal, 1.3 si es VIP

    public String getAsiento() {
        return asiento;
    }

    public int getMaletas() {
        return maletas;
    }
}

