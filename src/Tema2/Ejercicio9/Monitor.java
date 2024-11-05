package Tema2.Ejercicio9;

class Monitor {

    private int numero = 0 ;
    private boolean cerrojo = false;
    void Monitor(){
        numero = 0;
    }

    public synchronized int consumir(){
        while(!cerrojo){
            try{
                wait();
            }catch (InterruptedException e){
                System.err.println(e.toString());
            }
        }
        cerrojo = false;
        notifyAll();
        return numero;
    }

    public synchronized void producir(int num){
        while(cerrojo){
            try{
                wait();
            }catch (InterruptedException e){
                System.err.println(e.toString());
            }
        }
        cerrojo = true;
        notifyAll();
        numero = num;
    }
}
