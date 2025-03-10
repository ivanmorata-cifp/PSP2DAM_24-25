package Tema1;


import java.io.IOException;

public class Ejercicio7 {
    public static void main(String[] args) {
        String comando = "gnome-calculator"; //Paso 1: Guardar el comando en un String
        ProcessBuilder pb = new ProcessBuilder(comando); //Paso 2: Crear objeto de ProcessBuilder.
        try {
            Process proceso = pb.start(); //Paso 3: Crear objeto Process y utilizar start()
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
