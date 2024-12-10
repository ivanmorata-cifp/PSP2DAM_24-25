package Tema3.Ejercicios2_3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class EmisorDatagram {
    
    public static void envioDatagram(String mensaje, InetAddress direccion) throws IOException{
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress addr = direccion;
        DatagramPacket datagrama =
                new DatagramPacket(mensaje.getBytes(),
                        mensaje.getBytes().length,
                        addr, 5555);
        datagramSocket.send(datagrama);
        datagramSocket.close();
    }
    
    public static void main(String[] args){
        try {
            envioDatagram("Hola, DAM", InetAddress.getByName("localhost"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
