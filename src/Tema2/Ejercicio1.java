package Tema2;

public class Ejercicio1 extends Thread {
    String strImprimir;

    public Ejercicio1(String strImprimir) {
        this.strImprimir = strImprimir;
    }

    public void run(){
        for(int x=0;x<5;x++){
            System.out.println(strImprimir+ " " + x);
        }
    }

    public static void main(String[] args) {
        Thread primero = new Ejercicio1("Hilo 1");
        Thread segundo = new Ejercicio1("Hilo 2");
        primero.start();
        segundo.start();
        System.out.println("Final Hilo Principal");
    }
}
