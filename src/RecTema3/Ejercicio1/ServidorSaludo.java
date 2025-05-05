package RecTema3.Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
    LA COMUNICACIÓN CLIENTE-SERVIDOR SIEMPRE SE HACE SABIENDO EL ORDEN DE DICHA COMUNICACIÓN.
    1. Interpretar el orden de la comunicación
    2. Inicialización del servidor.
        2.1. Almacenar el nº del puerto.
        2.2. Crear objeto ServerSocket e inicializarlo con el nº de puerto.
        2.3. ¿El servidor admite una sola conexión o múltiples?
            2.3.1. Para una sola conexión, se crea el objeto Socket a partir de .accept() sin bucle.
            2.3.2. Para múltiples conexiones, se crea el objeto Socket a partir de .accept() en un bucle while(true).
        2.4. Inicializamos los flujos de datos:
            2.4.1. El flujo de entrada con un BufferedReader (inicializado a partir de InputStreamReader e InputStream del Socket cliente). COPIA PEGA
            2.4.2. El flujo de salida con un PrintWriter (inicializado a partir del OutputStream del Socket cliente).
        2.5. Realizamos la implementación del servidor (ENUNCIADO).
 */

public class ServidorSaludo {
    public static void main(String[] args) {
        int puerto = 5555;

        try{
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor esperando conexión en el puerto " + puerto + "...");
            while (true) {
                try (
                        Socket cliente = servidor.accept();
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                ) {
                    System.out.println("Cliente conectado.");

                    String mensaje = entrada.readLine();
                    System.out.println("Mensaje recibido: " + mensaje);
                    String respuesta;

                    switch (mensaje) {
                        case "Hola":
                            respuesta = "¡Bienvenido!";
                            break;
                        case "Hello":
                            respuesta = "Welcome!";
                            break;
                        case "Hallo":
                            respuesta = "Willkommen!";
                            break;
                        case "Konnichiwa":
                            respuesta = "Irasshaimasse!";
                            break;
                        default:
                            respuesta = "No entiendo el mensaje.";
                            break;
                    }
                    salida.println(respuesta);
                    System.out.println("Respuesta enviada: " + respuesta);
                } catch (IOException e) {
                    System.out.println("Error al atender cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
