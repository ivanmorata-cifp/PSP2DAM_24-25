package RecTema1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {

    private static void crearDirectorio(String path){
        File posibleDirectorio = new File(path);
        if(!posibleDirectorio.exists())
           ejecutarComando("mkdir -p " + path);
        else System.err.println("Error. El path recibido ya existe o no es un directorio.");
    }

    private static void generarArchivo(String nombreFichero){
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione el directorio:");
        System.out.println("1. Directorio de ejecución");
        System.out.println("2. Ingresar una ruta");
        int dirOption = scan.nextInt();
        scan.nextLine();
        String destino;
        if (dirOption == 1) {
            destino = "./";
        } else {
            System.out.print("Ingrese la ruta del directorio: ");
            destino = scan.nextLine();
        }
        ejecutarComando("touch " + destino + nombreFichero);
    }

    private static void visualizarFichero(String nombreFichero){
        File posibleFichero = new File(nombreFichero);
        if(posibleFichero.isFile())
            ejecutarComando("cat " + nombreFichero);
        else System.err.println("Error. El path recibido no es un fichero.");
    }

    private static void ejecutarComando(String comando) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(comando.split(" "));
            builder.inheritIO();
            Process proceso = builder.start();
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scannerOpcion = new Scanner(System.in);
        Scanner scannerTexto = new Scanner(System.in);
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear un directorio");
            System.out.println("2. Crear un archivo");
            System.out.println("3. Visualizar contenido de un archivo");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scannerOpcion.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Por favor, introduce el path donde crearás el directorio.");
                    String path = scannerTexto.nextLine();
                    crearDirectorio(path);
                    break;
                case 2:
                    System.out.println("Por favor, introduce el nombre del fichero.");
                    String nombre = scannerTexto.nextLine();
                    generarArchivo(nombre);
                    break;
                case 3:
                    System.out.print("Por favor, introduce la ruta del archivo a visualizar: ");
                    String fichero = scannerTexto.nextLine();
                    visualizarFichero(fichero);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scannerOpcion.close();
                    scannerTexto.close();
                    return;
                default:
                    System.out.println("Error. No se ha elegido ninguna de las opciones ofrecidas.");
            }
        }
    }
}

