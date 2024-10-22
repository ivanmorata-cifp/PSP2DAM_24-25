package Tema2.Ejercicio6;

public class GestorContador implements Runnable{

    private Contador miContador;

    public GestorContador(Contador contador){
        this.miContador = contador;
    }

    @Override
    public void run() {
        int aleatorio = (int)(Math.random()*9) + 1;
        if(miContador.getValor() % 2 == 0 || miContador.getValor() == 0){
            aleatorio*=100;
        }
        if(miContador.getValor() % 2 != 0){
            aleatorio*=500;
        }
        if(esPrimo(miContador.getValor())){
            aleatorio /= 2;
        }
        miContador.incrementar(aleatorio);
    }

    private boolean esPrimo(int n){
        for(int i=2; i<n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
