package bard;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso(8, 0, 2));
        procesos.add(new Proceso(6, 2, 1));
        procesos.add(new Proceso(4, 4, 2));
        procesos.add(new Proceso(2, 6, 0));
        PlanificadorPrioridad.planificar(procesos);

        // Imprimir tabla de tiempos
        System.out.println("Tabla de tiempos");
        for (Proceso proceso : procesos) {
            System.out.printf("Proceso %d: Tiempo en sistema: %d, Tiempo de espera: %d\n", proceso.getId(), proceso.getTiempoCPU(), proceso.getTiempoLlegada());
        }

        // Imprimir gráfico de ejecución
        System.out.println("Gráfico de ejecución");
        List<Integer> tiempos = new ArrayList<>();
        for (Proceso proceso : procesos) {
            tiempos.add(proceso.getTiempoLlegada());
            tiempos.add(proceso.getTiempoLlegada() + proceso.getTiempoCPU());
        }

        for (Integer tiempo : tiempos) {
            System.out.print(tiempo + " ");
        }
    }
}