package bard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PlanificadorPrioridad {

    // Método principal para la planificación de procesos por prioridad
    public static void planificar(List<Proceso> procesos) {
        List<Proceso> procesosEjecutados = new ArrayList<>(); // Lista para almacenar los procesos ejecutados
        PriorityQueue<Proceso> colaPrioridad = new PriorityQueue<>(Comparator.comparing(Proceso::getPrioridad));

        // Agregar los procesos a la cola de prioridad si no han sido ejecutados
        for (Proceso proceso : procesos) {
            if (!procesosEjecutados.contains(proceso)) {
                colaPrioridad.add(proceso);
            }
        }

        // Proceso de planificación basado en prioridad
        while (!colaPrioridad.isEmpty()) {
            Proceso procesoActual = colaPrioridad.poll();
            procesoActual.setTiempoEnSistema(procesoActual.getTiempoEnSistema() + procesoActual.getTiempoCPU());
            procesoActual.setTiempoEspera(procesoActual.getTiempoEnSistema() - procesoActual.getTiempoLlegada() - procesoActual.getTiempoCPU());
            procesosEjecutados.add(procesoActual);
        }

        // Calcular tiempo promedio de espera
        double tiempoPromedio = 0;
        for (Proceso proceso : procesos) {
            tiempoPromedio += proceso.getTiempoEspera();
        }
        tiempoPromedio /= procesos.size();

        // Generar gráfico de ejecución
        List<Integer> tiempos = new ArrayList<>();
        for (Proceso proceso : procesos) {
            tiempos.add(proceso.getTiempoLlegada());
        }
        for (Proceso proceso : procesosEjecutados) {
            tiempos.add(proceso.getTiempoLlegada() + proceso.getTiempoEnSistema());
        }
        System.out.println(tiempos);
    }
}
