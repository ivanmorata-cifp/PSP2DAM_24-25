package Tema2.Ejercicio9;

/*
    1. Tendremos una clase para representar el recurso compartido
        1.1. La clase tendrá un atributo que representa el dato compartido
        1.2. Además, tendrá un método producir y otro consumir
        1.3. Ambos métodos tienes que estar synchronized
        1.4. Debe haber una variable que controle cuando un hilo espera, y mecanismos que activen esos hilos en espera (wait/notifyAll)
    2. A continuación, dos clases: productor y consumidor.
    3. Productor. Tiene Runnable y un objeto de la clase compartida (1)
        3.1. El constructor inicializa el atributo con copia superficial
        3.2. Se realiza la producción en el método run llamando al método producir de la clase (1)
    4. Consumidor. También tiene Runnable y un objeto de la clase compartida (1)
        4.1. El constructor inicializa el atributo con copia superficial
        4.2. Se realiza la consumición en el método run llamando al método consumir de la clase (1)
    5. (Opcional) En el main creamos un objeto de cada una de las clases
        5.1. Inicializamos Prod y Cons con el objeto compartido (1)
        5.2. Creamos dos objetos Thread para el productor y el consumidor, y lanzamos el método start
 */

public class Main {
    public static void main(String [ ] args) throws InterruptedException {
        NumeroCompartido mon = new NumeroCompartido();
        Productor p = new Productor(mon);
        Consumidor c = new Consumidor(mon);
        Thread productor = new Thread(p);
        Thread consumidor = new Thread(c);
        productor.start();
        consumidor.start();
    }
}
