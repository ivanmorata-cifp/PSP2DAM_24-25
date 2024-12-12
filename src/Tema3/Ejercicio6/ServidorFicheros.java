package Tema3.Ejercicio6;

import java.io.*;
import java.net.*;

public class ServidorFicheros {
    public static void main(String[] args) {
        int puerto = 5555;
        String dirFicheros = "./Ficheros/";
        try{
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor de archivos iniciado en el puerto " + puerto);
            while (true) {
                System.out.println("Esperando conexión de cliente...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                try{
                    DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

                    String fileName = input.readUTF();
                    System.out.println("El cliente solicita el archivo: " + fileName);

                    File file = new File(dirFicheros + fileName);

                    if (file.exists() && !file.isDirectory()) {
                        output.writeUTF("Identificación correcta. Comienza el proceso de envío...");

                        long tamFichero = file.length();
                        output.writeLong(tamFichero);

                        try{
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] buffer = new byte[4096];
                            int bytesActuales;
                            while ((bytesActuales = fileInputStream.read(buffer)) != -1) {
                                output.write(buffer, 0, bytesActuales);
                            }
                            System.out.println("Archivo enviado correctamente.");
                        }catch (IOException e){
                            System.err.println("Error en la lectura del archivo: " + e);
                        }
                    } else {
                        output.writeUTF("ERROR: Archivo no encontrado");
                        System.err.println("El archivo solicitado no existe.");
                    }
                } catch (IOException e) {
                    System.err.println("Error en la comunicación con el cliente: " + e);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e);
        }
    }
}


