package Tema0;

public class Persona {
    private String dni, nombre, apellidos;
    private char genero;
    private int edad;
    private double peso;

    public Persona(){
        dni = nombre = apellidos = "";
        genero = ' ';
        edad = -1;
        peso = -1;
    }

    public Persona(String dni, String nombre, String apellidos, char genero, int edad, double peso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.edad = edad;
        this.peso = peso;
    }

    public Persona(Persona otra){
        this.dni = otra.dni;
        this.nombre = otra.nombre;
        this.apellidos = otra.apellidos;
        this.genero = otra.genero;
        this.edad = otra.edad;
        this.peso = otra.peso;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", peso=" + peso +
                '}';
    }
}