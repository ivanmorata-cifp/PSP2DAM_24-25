package Tema0;

public class Otros {
    public static void ejercicio3(){
        for(int i=1; i<11; i+=2){
            i--;
            System.out.println(i);
        }

        for(int i=1; i!=10; i++){
            i++;
            System.out.println(i);
        }

        for(int i=0; i<=100; i*=2){
            System.out.println(i);
        }
        for(int i=1; i<=100; i*=2){
            System.out.println(i);
        }
        for(int i=0; i%2==0; i+=2){
            if(i==50)
                i++;
            System.out.println(i);
        }
    }

    public static int ejercicio4(int n){
        int resultado = 1;
        for(int i=n; i>0; i--){
            resultado*=i;
        }
        return  resultado;
    }

    public static int ejercicio5(int n){
        String numero = Integer.toString(n);
        return numero.length();
    }
}
