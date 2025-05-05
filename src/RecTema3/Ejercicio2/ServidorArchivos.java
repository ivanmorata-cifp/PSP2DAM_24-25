package RecTema3.Ejercicio2;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorArchivos {
    public static void main(String[] args) throws IOException {
        int puerto = 5555;
        File[] archivosDisponibles = {
                new File("/home/ivanmorata/Descargas/Ficheros/" + "archivo1.txt"),
                new File("/home/ivanmorata/Descargas/Ficheros/" + "archivo2.txt"),
                new File("/home/ivanmorata/Descargas/Ficheros/" + "archivo3.txt")
        };

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexión...");

            try (
                    Socket cliente = servidor.accept();
                    BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                    PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            ) {
                System.out.println("Cliente conectado.");
                ArrayList<File> archivosSolicitados = new ArrayList<>();
                while (true) {
                    String nombreArchivo = entrada.readLine();
                    if (nombreArchivo != null) {
                        boolean encontrado = false;
                        for (File f : archivosDisponibles) {
                            if (f.getName().equals(nombreArchivo)) {
                                salida.println("Existe");
                                archivosSolicitados.add(f);
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            salida.println("No existe");
                        }else {
                            salida.println("ARCHIVOS_ENVIADOS:");
                            for (File f : archivosSolicitados) {
                                salida.println("==> " + f.getName() + " <==");
                                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                                    String linea;
                                    while ((linea = br.readLine()) != null) {
                                        salida.println(linea);
                                    }
                                } catch (IOException e) {
                                    salida.println("[Error leyendo archivo " + f.getName() + "]");
                                }
                                salida.println();
                            }
                            salida.println("FIN");
                            System.out.println("Transferencia completada. Conexión cerrada.");
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error en el servidor: " + e.getMessage());
            }
        }
    }
}