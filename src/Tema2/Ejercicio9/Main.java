package Tema2.Ejercicio9;

public class Main {
    public static void main(String [ ] args) throws InterruptedException {
        Monitor mon = new Monitor();
        Productor p = new Productor(mon);
        Consumidor c = new Consumidor(mon);
        Thread productor = new Thread(p);
        Thread consumidor = new Thread(c);
        productor.start();
        consumidor.start();
    }
}
