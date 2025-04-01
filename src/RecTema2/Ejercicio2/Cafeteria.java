package RecTema2.Ejercicio2;

import java.util.ArrayList;

public class Cafeteria {
    private final ArrayList<String> pedidos = new ArrayList<>();
    private final int capacidad;

    public Cafeteria(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void agregarPedido(String pedido) throws InterruptedException {
        while (pedidos.size() == capacidad) {
            System.out.println("Limite de producción alcanzado.");
            wait();
        }
        pedidos.add(pedido);
        System.out.println("Producido - " + pedido);
        notifyAll();
    }

    public synchronized String recogerPedido() throws InterruptedException {
        while (pedidos.isEmpty()) {
            System.out.println("Consumidos todos los pedidos.");
            wait();
        }
        String pedido = pedidos.get(0);
        pedidos.remove(0);
        System.out.println("Consumido - " + pedido);
        notifyAll();
        return pedido;
    }
}

