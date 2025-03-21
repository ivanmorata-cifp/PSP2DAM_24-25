package Tema2.Ejercicio3;

public class TiradaDados { //1. Representar el objeto compartido
    private int tirada;

    public TiradaDados(int e) {
        tirada = e;
    }

    public synchronized int getSumaTirada() { //1.1. Los métodos de acceso al recurso compartido deben ir synchronized
        return tirada;
    }

    public synchronized void setSumaTirada (int e) { //1.1 Igual que el anterior
        tirada += e;
    }
}

