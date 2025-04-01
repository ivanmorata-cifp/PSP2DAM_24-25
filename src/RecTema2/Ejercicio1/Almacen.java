package RecTema2.Ejercicio1;

public class Almacen {
    private String pieza; // Solo una pieza a la vez

    public synchronized void agregarPieza(String nuevaPieza) throws InterruptedException {
        while (pieza != null) {
            wait(); // Espera si el almacén ya tiene una pieza
        }
        pieza = nuevaPieza;
        System.out.println("Productor fabricó: " + pieza);
        notifyAll(); // Notifica a los ensambladores que hay una pieza disponible
    }

    public synchronized String retirarPieza() throws InterruptedException {
        while (pieza == null) {
            wait(); // Espera si el almacén está vacío
        }
        String piezaRetirada = pieza;
        pieza = null; // Se vacía el almacén
        System.out.println("Ensamblador usó: " + piezaRetirada);
        notifyAll(); // Notifica a los productores que pueden fabricar otra pieza
        return piezaRetirada;
    }
}
