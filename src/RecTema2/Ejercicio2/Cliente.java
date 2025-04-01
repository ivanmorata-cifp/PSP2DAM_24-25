package RecTema2.Ejercicio2;

import java.util.concurrent.TimeUnit;

public class Cliente implements Runnable {
    private final Cafeteria cafeteria;

    public Cliente(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    @Override
    public void run() {
        try {
            while (true) {
                cafeteria.recogerPedido();
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
