package Tema3.Ejercicio5;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AdivinaCliente {
    public static void main(String[] args) {
        String servidor = "localhost";
        int puerto = 5555;
        Scanner scan = new Scanner(System.in);
        boolean juegoTerminado = false;

        try{
            Socket socket = new Socket(servidor, puerto);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Conectado al servidor en " + servidor + ":" + puerto);

            String mensajeDelServidor;
            while (!juegoTerminado && (mensajeDelServidor = input.readLine()) != null) {
                System.out.println("Servidor: " + mensajeDelServidor);
                if(mensajeDelServidor.contains("rendido"))
                    juegoTerminado = true;
                else if (mensajeDelServidor.startsWith("¡Correcto!")) {
                    System.out.println("¡Juego terminado!");
                    juegoTerminado = true;
                } else {
                    System.out.print("Tu intento: ");
                    String intento = scan.nextLine();
                    output.println(intento);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor: " + e);
        }
    }
}

