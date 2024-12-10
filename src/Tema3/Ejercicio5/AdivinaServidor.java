package Tema3.Ejercicio5;

import java.io.*;
import java.net.*;
import java.util.Random;

public class AdivinaServidor {
    public static void main(String[] args) {
        int puerto = 5555;
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;

        try{
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                try{
                    BufferedReader input = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                    PrintWriter output = new PrintWriter(cliente.getOutputStream(), true);
                    output.println("¡Bienvenido al juego de adivinar el número! Intenta adivinar un número entre 1 y 100.");

                    String mensaje = "";
                    boolean adivinado = false;
                    while (!adivinado && !mensaje.equals("-1")) {
                        mensaje = input.readLine();
                        if (mensaje == null)
                            cliente.close();
                        try {
                            int intento = Integer.parseInt(mensaje);
                            if(intento == -1)
                                output.println("Sentimos que te hayas rendido. ¡Suerte la próxima vez!");
                            if (intento < numeroSecreto) {
                                output.println("Mayor");
                            } else if (intento > numeroSecreto) {
                                output.println("Menor");
                            } else {
                                output.println("¡Correcto! Has adivinado el número.");
                                adivinado = true;
                            }
                        } catch (NumberFormatException e) {
                            output.println("Por favor, introduce un número válido.");
                        }
                    }
                    cliente.close();
                } catch (IOException e) {
                    System.err.println("Error al comunicar con el cliente: " + e.getMessage());
                } finally {
                    System.out.println("Cliente desconectado.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}


