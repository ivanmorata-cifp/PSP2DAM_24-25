package Tema2.Ejercicio3;

public class TiradaDados {
    private int tirada;

    public TiradaDados(int e) {
        tirada = e;
    }

    public synchronized int getSumaTirada() {
        return tirada;
    }

    public synchronized void setSumaTirada (int e) {
        tirada += e;
    }
}

