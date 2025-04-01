package RecTema2.Ejercicio1;

public class Productor implements Runnable {
    private final Almacen almacen;
    private int contador = 1;

    public Productor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String pieza = "Pieza #" + contador;
                contador++;
                almacen.agregarPieza(pieza);
                Thread.sleep(800); // Simula tiempo de fabricación
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}