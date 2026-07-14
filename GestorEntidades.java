package data;

import model.Registrable;
import model.GuiaTuristico;
import model.Vehiculo;
import java.util.ArrayList;

public class GestorEntidades {
    private ArrayList<Registrable> listaEntidades;

    public GestorEntidades() {
        this.listaEntidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        listaEntidades.add(entidad);
    }

    public String obtenerReporteFiltrado() {
        if (listaEntidades.isEmpty()) {
            return "No hay registros en el sistema.";
        }

        StringBuilder reporte = new StringBuilder("=== REPORTE DE ENTIDADES ===\n\n");

        for (Registrable entidad : listaEntidades) {
            if (entidad instanceof GuiaTuristico) {
                reporte.append("[PERSONAL] ").append(entidad.mostrarResumen()).append("\n");
            } else if (entidad instanceof Vehiculo) {
                reporte.append("[LOGÍSTICA] ").append(entidad.mostrarResumen()).append("\n");
            } else {
                reporte.append("[OTROS] ").append(entidad.mostrarResumen()).append("\n");
            }
        }
        return reporte.toString();
    }
}
