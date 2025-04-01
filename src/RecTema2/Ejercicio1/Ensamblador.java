package RecTema2.Ejercicio1;

public class Ensamblador implements Runnable {
    private final Almacen almacen;

    public Ensamblador(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            while (true) {
                almacen.retirarPieza();
                Thread.sleep(1000); // Simula tiempo de ensamblaje
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}