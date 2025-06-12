package elbuho;

public abstract class ServiciosBase {
    protected String asiento;
    protected int maletas;

    public ServiciosBase(String asiento, int maletas) {
        this.asiento = asiento;
        this.maletas = maletas;
    }

    public abstract double calcularRecargo();
    public abstract int maletasIncluidas();
    public abstract String getTipoServicio();

    public double MaletasExtra() {
        int extra = maletas - maletasIncluidas();
        return (extra > 0) ? extra * 5.0 : 0;
    }

    public String getAsiento() {
        return asiento;
    }

    public int getMaletas() {
        return maletas;
    }
}




