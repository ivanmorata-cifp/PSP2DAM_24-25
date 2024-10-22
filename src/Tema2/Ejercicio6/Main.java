package Tema2.Ejercicio6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contador miContador = new Contador();

        GestorContador tarea = new GestorContador(miContador);

        Thread hilo1 = new Thread(tarea);
        Thread hilo2 = new Thread(tarea);

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Valor final del contador: " + miContador.getValor());
    }
}
