package Tema3.EjerciciosPrueba;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {

    public static void enviaMensaje(String mensaje, int puerto) throws IOException{
        Socket clientSocket = new Socket();
        InetSocketAddress addr = new InetSocketAddress("localhost", puerto);
        clientSocket.connect(addr);
        OutputStream os = clientSocket.getOutputStream();
        os.write(mensaje.getBytes());
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        enviaMensaje("Hola, DAM", 5555);
    }
}
