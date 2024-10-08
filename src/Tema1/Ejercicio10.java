package Tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, introduce un comando del sistema operativo: ");
        String comando = scanner.nextLine();
        System.out.print("Ahora, especifica el directorio de ejecución: ");
        String directorio = scanner.nextLine();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            File dir = new File(directorio);
            if (!dir.exists() || !dir.isDirectory()) {
                System.err.println("El directorio especificado no existe o no es válido.");
                return;
            }
            processBuilder.directory(dir);
            processBuilder.command(comando.split(" "));
            Process proceso = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            System.out.println("Salida del comando:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
            while ((linea = errorReader.readLine()) != null) {
                System.err.println(linea);
            }
            int exitCode = proceso.waitFor();
            System.out.println("\nEl comando finalizó con el código de salida: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}