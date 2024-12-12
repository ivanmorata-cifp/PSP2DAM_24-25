package Tema3.Ejercicio6;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteFicheros {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5555;
        Scanner scan = new Scanner(System.in);

        try{
            Socket socket = new Socket(serverAddress, port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            System.out.print("Ingrese el nombre del archivo que desea descargar: ");
            String fileName = scan.nextLine();
            output.writeUTF(fileName);

            String respuestaServer = input.readUTF();
            if (respuestaServer.contains("Identificación correcta")) {
                long tamFichero = input.readLong();
                System.out.println("Descargando archivo de tamaño: " + tamFichero + " bytes...");

                try{
                    FileOutputStream fis = new FileOutputStream("d_" + fileName);
                    byte[] buffer = new byte[4096];
                    int bytesLeidos;
                    long totalLeido = 0;

                    while ((bytesLeidos = input.read(buffer)) != -1 || totalLeido >= tamFichero) {
                        fis.write(buffer, 0, bytesLeidos);
                        totalLeido += bytesLeidos;
                    }
                    System.out.println("Archivo descargado correctamente como: d_" + fileName);
                }catch (IOException e){
                    System.err.println("Error en la recuperación del fichero: " + e);
                }
            } else {
                System.err.println("Error del servidor: " + respuestaServer);
            }
        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor: " + e);
        }
    }
}


