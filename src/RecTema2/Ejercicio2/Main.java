package RecTema2.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Cafeteria cafeteria = new Cafeteria(5);

        Thread barista1 = new Thread(new Barista(cafeteria));
        Thread barista2 = new Thread(new Barista(cafeteria));
        Thread cliente1 = new Thread(new Cliente(cafeteria));

        barista1.start();
        barista2.start();
        cliente1.start();
    }
}

