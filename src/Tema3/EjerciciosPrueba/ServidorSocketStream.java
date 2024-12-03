package Tema3.EjerciciosPrueba;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;

public class ServidorSocketStream {

    public static void recibeMensaje(int puerto) throws IOException{
        ServerSocket serverSocket = new ServerSocket();
        InetSocketAddress addr = new InetSocketAddress("localhost", puerto);
        serverSocket.bind(addr);
        Socket newSocket = serverSocket.accept();
        InputStream is = newSocket.getInputStream();
        byte[] mensaje = new byte[25];
        is.read(mensaje);
        String s = new String(mensaje, StandardCharsets.UTF_8);
        System.out.println(s);
        newSocket.close();
    }

    public static void main(String[] args) {
        try {
            recibeMensaje(5555);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
