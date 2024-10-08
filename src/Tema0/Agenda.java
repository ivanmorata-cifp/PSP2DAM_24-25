package Tema0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Agenda {
    private HashMap<String, Integer> agenda;

    public Agenda(){
        agenda = new HashMap<>();
    }

    public Agenda(HashMap<String, Integer> agenda) {
        this.agenda = new HashMap<>(agenda);
    }

    public boolean agendaVacia(){
        return agenda.isEmpty();
    }

    public int numeroContactos(){
        return agenda.size();
    }

    public void nuevoContacto(String contacto, int nTelefono){
        agenda.put(contacto, nTelefono);
    }

    public boolean compruebaClave(String contacto){
        return agenda.containsKey(contacto);
    }

    public boolean compruebaValor(int telefono){
        return agenda.containsValue(telefono);
    }

    public boolean borrarTelefono(int telefono){
        if(!agenda.containsValue(telefono))
            return false;
        Set<String> claves = agenda.keySet();
        Iterator<String> iterador = claves.iterator();
        while(iterador.hasNext()){
            String clave = iterador.next();
            if(agenda.get(clave) == telefono)
                agenda.remove(clave);
        }
        return true;
    }

    public void modificarTelefono(String nuevoNombre, int telefono){
        Set<String> claves = agenda.keySet();
        Iterator<String> iterador = claves.iterator();
        while(iterador.hasNext()){
            String clave = iterador.next();
            if(agenda.get(clave) == telefono){
                agenda.remove(clave);
                agenda.put(nuevoNombre, telefono);
            }
        }
    }

    public void modificarContacto(String viejoNombre, String nuevoNombre, int telefono){
        agenda.remove(viejoNombre, telefono);
        agenda.put(nuevoNombre, telefono);
    }

    public void vaciarAgenda(){
        agenda.clear();
    }

}