package Tema2.Ejercicio8;

public class EscribeHolaAdios {

    boolean escritoHola = false;

    public synchronized void eAdios() {
        while (escritoHola == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        escritoHola = false;
        System.out.println("Adiós");
    }

    public synchronized void eHola() {
        System.out.println("Hola");
        escritoHola = true;
        notify();
    }

}

