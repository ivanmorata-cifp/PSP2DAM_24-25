package Tema2;

public class Ejercicio2 implements Runnable{
    String strImprimir;

    public Ejercicio2(String strP) {
        strImprimir=strP;
    }

    public void run(){
        for(int x=0;x<5;x++){
            System.out.println(strImprimir+ " " + x);
        }
    }

    public static void main(String[] args) {
        Ejercicio2 objRunnable1 = new Ejercicio2("Hilo 1");
        Ejercicio2 objRunnable2 = new Ejercicio2("Hilo 2");
        Thread primero = new Thread(objRunnable1);
        Thread segundo = new Thread(objRunnable2);
        primero.start();
        segundo.start();
        System.out.println("Final Hilo Principal");
    }
}
