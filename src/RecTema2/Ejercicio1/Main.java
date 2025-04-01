package RecTema2.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Thread productor1 = new Thread(new Productor(almacen));
        Thread ensamblador1 = new Thread(new Ensamblador(almacen));

        productor1.start();
        ensamblador1.start();
    }
}
