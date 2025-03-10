package Tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio8 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "4", "google.com"); //Paso 2.1: Para más de un comando, separar por comas.
        pb.inheritIO(); //Paso 2.2: Redirigir los flujos automáticamente
        try {
            Process process = pb.start();
            process.waitFor(); //Paso 4*: cuando el proceso tiene una duración de más de un instante, hay que esperar a que termine.
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}