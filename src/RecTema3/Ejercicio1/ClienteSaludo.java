package RecTema3.Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
    LA COMUNICACIÓN CLIENTE-SERVIDOR SIEMPRE SE HACE SABIENDO EL ORDEN DE DICHA COMUNICACIÓN.
    1. Interpretar el orden de la comunicación
    2. Inicialización del cliente.
        2.1. Almacenar el nº del puerto y el nombre del host (localhost).
        2.2. Crear objeto Socket e inicializarlo con el nº de puerto y el nombre del host.
        2.3. Inicializamos los flujos de datos:
            2.3.1. El flujo de entrada con un BufferedReader (inicializado a partir de InputStreamReader e InputStream del Socket cliente). COPIA PEGA
            2.3.2. El flujo de salida con un PrintWriter (inicializado a partir del OutputStream del Socket cliente).
        2.4. Realizamos la implementación del cliente (ENUNCIADO).
 */

public class ClienteSaludo {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5555;

        try (
                Socket socket = new Socket(host, puerto);
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in);
        ) {
            System.out.print("Escribe un saludo (Hola, Hello, Hallo, Konnichiwa): ");
            String mensaje = scanner.nextLine();

            salida.println(mensaje);
            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
