package Tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio8 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "4", "google.com");
//        pb.inheritIO();
        pb.redirectErrorStream(true);
        try {
            Process process = pb.start();

            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String linea;
            while((linea = reader.readLine())!=null){
                System.out.println(linea);
            }
            reader.close();
            is.close();
            
            process.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}