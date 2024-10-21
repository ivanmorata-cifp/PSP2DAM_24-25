package Tema2.Ejercicio4;

public class AgenciaViajes implements Runnable {

    private AsientoAvion as;

    public AgenciaViajes(){
        as = new AsientoAvion();
    }

    public void run() {
        System.out.println("Asientos Libres: " + as.getAsientosLibres());
        synchronized (as){
            gestionAsientos(3);
            if(as.getAsientosLibres() <= 0)
                System.out.println("No hay asientos libres");
        }
    }

    public synchronized void gestionAsientos(int numAsientosReservas) {

        System.out.println(Thread.currentThread().getName() + " tiene la clave del candado." );

        //Comprobamos si hay asientos suficientes
        if(as.getAsientosLibres() >= numAsientosReservas){
            System.out.println(Thread.currentThread().getName() + " hará una reserva de " + numAsientosReservas + " plazas ");
            try{
                Thread.sleep(1000); //dormimos el hilo 1 segundo
            } catch(InterruptedException ex) {
                ex.printStackTrace();
            }
            //Realizamos la reserva de los asientos
            as.reservaAsientos(numAsientosReservas);
            System.out.println(Thread.currentThread().getName() + " Reserva realizada con éxito." + " Las plazas libres son " + as.getAsientosLibres());
        } else {
            System.out.println("No hay plazas suficientes para el cliente." + Thread.currentThread().getName() + " Las plazas libres son " + as.getAsientosLibres());
            try {
                Thread.sleep(1000);
            }catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " deja la clave del candado.");
    }


    public static void main(String [ ] args) {
        AgenciaViajes objAg = new AgenciaViajes();

        //creamos ambos hilos sobre la misma instancia
        Thread Hilo_1 = new Thread(objAg);
        Thread Hilo_2 = new Thread(objAg);
        Hilo_1.setName("Cliente 1");
        Hilo_2.setName("Cliente 2");

        Hilo_1.start();
        Hilo_2.start();
    }
}
