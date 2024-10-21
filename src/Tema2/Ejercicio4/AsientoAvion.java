package Tema2.Ejercicio4;

public class AsientoAvion {
    private int asientosLibres = 5;

    public int getAsientosLibres() {
        return asientosLibres;
    }

    public boolean getAsientosLibres(int numPlaces) {
        if(numPlaces <= asientosLibres)
            return true;
        else return false;
    }

    public void reservaAsientos(int numAsientosReservas) {
        asientosLibres = asientosLibres - numAsientosReservas;
    }
}

