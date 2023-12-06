package bard;

class Proceso {
    private static int contador = 1;

    private int id;
    private int tiempoCPU;
    private int tiempoLlegada;
    private int prioridad;
    private int tiempoEnSistema;
    private int tiempoEspera;

    // Constructor de la clase Proceso
    public Proceso(int tiempoCPU, int tiempoLlegada, int prioridad) {
        this.id = contador++;
        this.tiempoCPU = tiempoCPU;
        this.tiempoLlegada = tiempoLlegada;
        this.prioridad = prioridad;
        this.tiempoEnSistema = 0;
        this.tiempoEspera = 0;
    }

    // Getter para obtener el ID del proceso
    public int getId() {
        return id;
    }

    // Getter para obtener el tiempo de CPU del proceso
    public int getTiempoCPU() {
        return tiempoCPU;
    }

    // Getter para obtener el tiempo de llegada del proceso
    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    // Getter para obtener la prioridad del proceso
    public int getPrioridad() {
        return prioridad;
    }

    // Getter para obtener el tiempo en sistema del proceso
    public int getTiempoEnSistema() {
        return tiempoEnSistema;
    }

    // Setter para establecer el tiempo en sistema del proceso
    public void setTiempoEnSistema(int tiempoEnSistema) {
        this.tiempoEnSistema = tiempoEnSistema;
    }

    // Getter para obtener el tiempo de espera del proceso
    public int getTiempoEspera() {
        return tiempoEspera;
    }

    // Setter para establecer el tiempo de espera del proceso
    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    // Método para incrementar el tiempo en sistema del proceso
    public void incrementarTiempoEnSistema(int tiempo) {
        this.tiempoEnSistema += tiempo;
    }

    // Método para incrementar el tiempo de espera del proceso
    public void incrementarTiempoEspera(int tiempo) {
        this.tiempoEspera += tiempo;
    }
}
