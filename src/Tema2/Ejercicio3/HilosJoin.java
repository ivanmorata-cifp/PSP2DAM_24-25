package Tema2.Ejercicio3;

public class HilosJoin implements Runnable {

    private TiradaDados dados;

    public HilosJoin (TiradaDados m) {
        dados = m;
    }

    public void run ( ) {
        try {
            Thread.sleep (1000);
            int resultadoDado = (int) (Math.random() * 6 ) + 1;
            dados.setSumaTirada ( resultadoDado );
            System.out.println( "Tirada hilo " + Thread.currentThread().getName() + ": " + resultadoDado);
        }catch ( InterruptedException e ) {
            System.err.println(e.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TiradaDados dados = new TiradaDados(0);

        HilosJoin obj1 = new HilosJoin(dados);
        HilosJoin obj2 = new HilosJoin(dados);
        HilosJoin obj3 = new HilosJoin(dados);
        Thread hilo1 = new Thread(obj1);
        hilo1.setName("Dado 1");
        Thread hilo2 = new Thread(obj2);
        hilo2.setName("Dado 2");
        Thread hilo3 = new Thread(obj3);
        hilo3.setName("Dado 3");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("Total tirada: " + dados.getSumaTirada());
        System.out.println("Final Hilo Principal");

    }
}
