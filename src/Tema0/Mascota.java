package Tema0;

public class Mascota {
    private String nombreMascota;
    private String nombreDueno;
    private String tipoAnimal;
    private String historialClinico;

    private static int nMascotas = 0;

    public Mascota(){
        nombreDueno = nombreMascota = tipoAnimal = historialClinico = "";
    }

    public Mascota(String nombreMascota, String nombreDueno, String tipoAnimal, String historialClinico) {
        setNombreMascota(nombreMascota);
        setNombreDueno(nombreDueno);
        setTipoAnimal(tipoAnimal);
        setHistorialClinico(historialClinico);
        nMascotas++;
    }

    public Mascota(Mascota otro){
        this.nombreMascota = otro.nombreMascota;
        this.nombreDueno = otro.nombreDueno;
        this.tipoAnimal = otro.tipoAnimal;
        this.historialClinico = otro.historialClinico;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota.toUpperCase();
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno.replace(" ", "");
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        switch(tipoAnimal){
            case "Perro", "Gato", "Exotico":
                this.tipoAnimal = tipoAnimal;
                break;
            default:
                this.tipoAnimal = "";
        }
    }

    public String getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(String historialClinico) {
        this.historialClinico = historialClinico;
    }

    public static int getnMascotas() {
        return nMascotas;
    }

    public Mascota clone(){
        Mascota clon = new Mascota(this);
        return clon;
    }

    public boolean equals(Mascota otra){
        if(!this.nombreMascota.equals(otra.nombreMascota))
            return false;
        if(!this.nombreDueno.equals(otra.nombreDueno))
            return false;
        if(!this.tipoAnimal.equals(otra.tipoAnimal))
            return false;
        if(!this.historialClinico.equals(otra.historialClinico))
            return false;
        return true;
    }

    public String toString(){
        return "Este" + tipoAnimal +" se llama " + nombreMascota +
                " y pertenece a " + nombreDueno + ". A continuación, su historial clínico:\n" +
                historialClinico + ".";
    }
}
