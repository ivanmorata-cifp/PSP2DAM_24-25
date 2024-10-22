package Tema2.Ejercicio6;

public class Contador {
    private int valor = 0;

    public synchronized int getValor(){
        return valor;
    }

    public synchronized void incrementar(int incremento){
        for(int i=0; i<incremento; i++){
            valor++;
        }
    }
}
