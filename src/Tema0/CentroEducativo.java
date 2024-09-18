package Tema0;

public class CentroEducativo {
    private String nombre;
    private int nEstudiantes;
    private int nProfesores;
    private int codigoPostal;

    public CentroEducativo(){
        nombre = "";
        nEstudiantes = nProfesores = codigoPostal = -1;
    }

    public CentroEducativo(String nombre, int nEstudiantes, int nProfesores, int codigoPostal) {
        this.setNombre(nombre);
        this.setnEstudiantes(nEstudiantes);
        this.setnProfesores(nProfesores);
        this.setCodigoPostal(codigoPostal);
    }

    public CentroEducativo(CentroEducativo otro){
        this.nombre = otro.nombre;
        this.nEstudiantes = otro.nEstudiantes;
        this.nProfesores = otro.nProfesores;
        this.codigoPostal = otro.codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.length() < 10 || nombre.length() > 30){
            this.nombre = "";
        }else this.nombre = nombre;
    }

    public int getnEstudiantes() {
        return nEstudiantes;
    }

    public void setnEstudiantes(int nEstudiantes) {
        if(nEstudiantes < 50 || nEstudiantes > 1200)
            this.nEstudiantes = -1;
        else this.nEstudiantes = nEstudiantes;
    }

    public int getnProfesores() {
        return nProfesores;
    }

    public void setnProfesores(int nProfesores) {
        if(nProfesores >= 5 && nProfesores <= 200)
            this.nProfesores = nProfesores;
        else this.nProfesores = -1;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        if(codigoPostal >= 0 && codigoPostal <= 52999)
            this.codigoPostal = codigoPostal;
        else this.codigoPostal = -1;
    }

    public CentroEducativo clone(){
        CentroEducativo clon = new CentroEducativo(this);
        return clon;
    }

    public String toString(){
        String resultado = "Este Centro Educativo se llama " + nombre +
                ", tiene " + nEstudiantes + " estudiantes, " +
                "y " + nProfesores + " profesores. " +
                "Su código postal es " + codigoPostal + ".";
        return resultado;
    }

    public boolean equals(CentroEducativo otro){
        if(!this.nombre.equals(otro.nombre))
            return false;
        if(this.nEstudiantes != otro.nEstudiantes)
            return false;
        if(this.nProfesores != otro.nProfesores)
            return false;
        if(this.codigoPostal != otro.codigoPostal)
            return false;
        return true;
    }
}
