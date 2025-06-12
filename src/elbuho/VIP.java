package elbuho;

import java.util.List;

public class VIP extends Normal {
    private List<String> serviciosAdicionales;

    public VIP(String asiento, int maletas, List<String> serviciosAdicionales) {
        super(asiento, maletas);
        this.serviciosAdicionales = serviciosAdicionales;
    }

    @Override
    public double calcularRecargo() {
        return 1.3; // 30% más caro
    }

    public List<String> getServiciosAdicionales() {
        return serviciosAdicionales;
    }
}

