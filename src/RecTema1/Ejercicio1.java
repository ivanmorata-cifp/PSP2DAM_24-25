package RecTema1;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

    private static void ejecutarComando(String comando) { //comando = "ls -l"
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(comando.split(" ")); //"ls", "-l"
            builder.inheritIO();
            Process proceso = builder.start();
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion;
        System.out.println("Escoge que deseas realizar: ");
        System.out.println("1) Ver directorio actual.");
        System.out.println("2) Ver listado de archivos en la ruta actual.");
        System.out.println("3) Ver versión del sistema operativo.");
        opcion = scan.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Mostrando ruta actual: ");
                ejecutarComando("pwd");
                break;
            case 2:
                System.out.println("Listado de archivos en la ruta actual:");
                ejecutarComando("ls -l");
                break;
            case 3:
                System.out.println("\nVersión del sistema operativo:");
                ejecutarComando("uname -a");
                break;
            default:
                System.err.println("Error. Opción introducida no válida.");
        }
    }
}
