package Tema2.Ejercicio3;

/*
    Guía para resolver ejercicios de multi-hilo (NO-ProdCon)
    1.Crear clase para representar el recurso compartido
    2.Poner el acceso al recurso compartido (normalmente set/get) como synchronized
    3.Crear clase con Runnable (simulador de hilos)
        3.1. Como atributo, esta clase siempre tiene un objeto de la clase del recurso compartido
        3.2. El constructor de la clase debe hacer copia superficial del atributo
        3.3. Se plantea la ejecución del método run
    4.(opcional) Generar en el main objetos de la clase Runnable con un objeto de la clase del recurso compartido
 */

public class HilosJoin implements Runnable {

    private TiradaDados dados;

    public HilosJoin (TiradaDados m) {
        dados = m; //2. Cuando trabajamos con objetos compartidos, usamos copia superficial
    }

    public void run ( ) { //3. El método run es obligatorio. (Implements) Runnable / (Extends) Thread
        try { //4. Dentro del método run está la ejecución principal del programa
            Thread.sleep (1000);
            int resultadoDado = (int) (Math.random() * 6 ) + 1;
            dados.setSumaTirada ( resultadoDado );
            System.out.println( "Tirada hilo " + Thread.currentThread().getName() + ": " + resultadoDado);
        }catch ( InterruptedException e ) {
            System.err.println(e.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException { //5. Para probar el programa concurrente:
        TiradaDados dados = new TiradaDados(0); //5.1. Generar objeto de recurso compartido

        HilosJoin obj1 = new HilosJoin(dados);
        HilosJoin obj2 = new HilosJoin(dados);
        HilosJoin obj3 = new HilosJoin(dados);
        //5.2. Generar objetos de la clase que implementa Runnable / hereda de Thread para cada hilo

        Thread hilo1 = new Thread(obj1);
        hilo1.setName("Dado 1");
        Thread hilo2 = new Thread(obj2);
        hilo2.setName("Dado 2");
        Thread hilo3 = new Thread(obj3);
        hilo3.setName("Dado 3");
        //5.3. Inicializar los hilos con los objetos de la clase anterior

        hilo1.start();
        hilo2.start();
        hilo3.start();
        //5.4. Usar el método start en todos los hilos
        hilo1.join();
        hilo2.join();
        hilo3.join();
        //5.5. Llamar a join en todos los hilos para que el main espere la finalización de todos los hilos

        System.out.println("Total tirada: " + dados.getSumaTirada());
        System.out.println("Final Hilo Principal");

    }
}
