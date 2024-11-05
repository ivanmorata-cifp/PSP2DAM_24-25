package Tema2.Ejercicio10;

public class Monitor {
    private int colaNumeros[] = new int[5];
    private int indiceActual = 0;

    private boolean colaLlena = false;
    private boolean colaVacia = true;

    public synchronized void producir(int num) {
        while (colaLlena)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
        colaNumeros[indiceActual] = num;
        indiceActual++;
        if (indiceActual == 5)
            colaLlena = true;
        colaVacia = false;
        notify();
    }


    public synchronized int consumir() {
        while (colaVacia)
        {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        indiceActual--;
        if (indiceActual == 0) {
            colaVacia = true;
        }
        colaLlena = false;
        notify();
        return (colaNumeros[indiceActual]);
    }

}

