package RecTema2;

import java.util.Random;

public class EjercicioHilos {

    static class SumaParcial extends Thread {
        private int[] array;
        private int inicio, fin;
        private int suma = 0;

        public SumaParcial(int[] array, int inicio, int fin) {
            this.array = array;
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public void run() {
            for (int i = inicio; i < fin; i++) {
                suma += array[i];
            }
        }

        public int getSuma() {
            return suma;
        }
    }

    public static void main(String[] args) {
        int[] numeros = new int[10000];
        Random r = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(1,10);
        }

        int numHilos = 10;
        int tamañoParte = numeros.length / numHilos;

        SumaParcial[] tareas = new SumaParcial[numHilos];
        Thread[] hilos = new Thread[numHilos];

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * tamañoParte;
            int fin;
            if (i == numHilos - 1)
                fin = numeros.length;
            else fin = inicio + tamañoParte;
            tareas[i] = new SumaParcial(numeros, inicio, fin);
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();
        }

        int sumaTotal = 0;
        for (int i = 0; i < numHilos; i++) {
            try {
                hilos[i].join();
                sumaTotal += tareas[i].getSuma();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La suma total del array es: " + sumaTotal);
    }
}


