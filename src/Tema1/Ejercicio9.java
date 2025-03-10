package Tema1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, introduce un comando del sistema operativo: ");
        String comando = scanner.nextLine(); //"ping -c 4 google.com"
        try {
            String [] comandoSeparado = comando.split(" "); //[0]"ping", [1]"-c", [2]"4", [3]"google.com"
            ProcessBuilder processBuilder = new ProcessBuilder(comandoSeparado);
            processBuilder.inheritIO();
            Process proceso = processBuilder.start();
            int exitCode = proceso.waitFor();
            System.out.println("\nEl comando finalizó con el código de salida: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

