package chatgpt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Proceso {
    String nombre;
    int tiempoCPU;
    int tiempoLlegada;
    int prioridadExterna;
    int prioridadInterna;

    // Constructor de la clase Proceso
    public Proceso(String nombre, int tiempoCPU, int tiempoLlegada, int prioridadExterna, int prioridadInterna) {
        this.nombre = nombre;
        this.tiempoCPU = tiempoCPU;
        this.tiempoLlegada = tiempoLlegada;
        this.prioridadExterna = prioridadExterna;
        this.prioridadInterna = prioridadInterna;
    }
}

public class PlanificacionPrioridad {

    public static void main(String[] args) {
        // Crear una lista de procesos
        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso("P1", 8, 0, 2, 1));
        procesos.add(new Proceso("P2", 6, 2, 1, 2));
        procesos.add(new Proceso("P3", 4, 4, 2, 1));
        procesos.add(new Proceso("P4", 2, 6, 0, 3));

        // Ordenar los procesos por prioridad externa, prioridad interna y tiempo de llegada
        Collections.sort(procesos, (p1, p2) -> {
            if (p1.prioridadExterna != p2.prioridadExterna) {
                return Integer.compare(p1.prioridadExterna, p2.prioridadExterna);
            } else if (p1.prioridadInterna != p2.prioridadInterna) {
                return Integer.compare(p1.prioridadInterna, p2.prioridadInterna);
            } else {
                return Integer.compare(p1.tiempoLlegada, p2.tiempoLlegada);
            }
        });

        int tiempoEnSistema = 0;
        int tiempoEsperaTotal = 0;

        // Imprimir encabezados de la tabla
        System.out.println("Proceso\tTiempo en Sistema\tTiempo de Espera");
        System.out.println("--------------------------------------------");

        // Iterar sobre los procesos ordenados
        for (Proceso proceso : procesos) {
            System.out.print(proceso.nombre + "\t\t");

            // Manejar el tiempo de llegada y ejecución de cada proceso
            if (tiempoEnSistema < proceso.tiempoLlegada) {
                tiempoEnSistema = proceso.tiempoLlegada;
            }

            System.out.print(tiempoEnSistema + "-" + (tiempoEnSistema + proceso.tiempoCPU) + "\t\t\t");
            tiempoEsperaTotal += tiempoEnSistema - proceso.tiempoLlegada;
            tiempoEnSistema += proceso.tiempoCPU;

            System.out.println(tiempoEnSistema - proceso.tiempoLlegada);
        }

        // Calcular el tiempo promedio de espera
        double tiempoEsperaPromedio = (double) tiempoEsperaTotal / procesos.size();
        System.out.println("\nTiempo de Espera Promedio: " + tiempoEsperaPromedio);

        // Imprimir gráfico de ejecución
        System.out.println("\nGráfico de Ejecución:");
        for (Proceso proceso : procesos) {
            System.out.print(proceso.nombre + " ");
        }
    }
}
