package RecTema2.Ejercicio2;

import java.util.ArrayList;
import java.util.Random;

public class Barista implements Runnable {
    private final Cafeteria cafeteria;
    private ArrayList<String> menu;
    private int contador = 1;

    public Barista(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    private void rellenarMenu(){
        menu = new ArrayList<>();
        menu.add("Latte Machiatto");
        menu.add("Capuccino");
        menu.add("Americano");
        menu.add("Cortado");
        menu.add("Nube");
        menu.add("Café helado");
    }

    @Override
    public void run() {
        rellenarMenu();
        Random r = new Random();
        try {
            while (true) {
                String pedido = "Pedido " + ": " + menu.get(r.nextInt(0, menu.size()));
                cafeteria.agregarPedido(pedido);
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

