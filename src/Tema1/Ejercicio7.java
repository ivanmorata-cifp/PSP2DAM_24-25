package Tema1;


import java.io.IOException;

public class Ejercicio7 {
    public static void main(String[] args) {
        String comando = "gnome-calculator";
        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            Process proceso = pb.start();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
