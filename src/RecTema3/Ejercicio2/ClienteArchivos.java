package RecTema3.Ejercicio2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteArchivos {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5555;

        try (
                Socket socket = new Socket(host, puerto);
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in);
        ) {
            while (true) {
                System.out.print("Ingrese el nombre del archivo (o escriba 'OK' para finalizar): ");
                String input = scanner.nextLine();
                salida.println(input);

                if (input.equalsIgnoreCase("OK")) {
                    break;
                }

                String respuesta = entrada.readLine();
                if ("No existe".equals(respuesta)) {
                    System.out.println("El archivo no existe en el servidor. Conexión terminada.");
                    return;
                } else if ("Existe".equals(respuesta)) {
                    System.out.println("Archivo agregado a la lista de descarga.");
                }
            }
            String linea;
            while (!(linea = entrada.readLine()).equals("FIN")) {
                System.out.println(linea);
            }
            System.out.println("Todos los archivos fueron recibidos correctamente.");
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}

