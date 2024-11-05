package Tema2.Ejercicio10;

class Consumidor implements Runnable {

    private Monitor bandeja ;

    public Consumidor(Monitor s){
        bandeja = s ;
    }


    public void run(){
        int num ;

        for (int i = 0 ; i < 5 ; i ++) {
            num = bandeja.consumir() ;
            System.out.println ("Consumido el número: " + num) ;
            try {
                Thread.sleep((int) (Math.random () * 2000)) ;
            } catch (InterruptedException e) { ; }
        }
    }
}