package Tema0;

import java.util.ArrayList;

public class GestionaPersonas {
    private static ArrayList<Persona> lista;

    public static void inicializaLista(ArrayList<Persona> lista){
        GestionaPersonas.lista = new ArrayList<>(lista);
    }

    public static Persona buscaPersonas(String dni){
        for(Persona p : lista){
            if(p.getDni().equals(dni))
                return p;
        }
        return null;
    }

    public static boolean eliminarPersona(String nombre, String apellido){
        for(Persona p : lista){
            if(p.getNombre().equals(nombre) && p.getApellidos().equals(apellido)) {
                lista.remove(p);
                return true;
            }
        }
        return false;
    }

    public static void ordenaLista(){
        ArrayList<Persona> ordenados = new ArrayList<>();
        Persona aux = new Persona();
        for(int i=0; i<lista.size(); i++){
            aux = lista.get(i);
            for(int j=i; j<lista.size(); j++){
                if(lista.get(j).getEdad() < aux.getEdad())
                    aux = lista.get(j);
            }
            ordenados.add(aux);
            lista.remove(aux);
        }
        lista = new ArrayList<>(ordenados);
    }

    public static void mostrarLista(){
        for(Persona p : lista)
            System.out.println(p.toString());
    }
}
