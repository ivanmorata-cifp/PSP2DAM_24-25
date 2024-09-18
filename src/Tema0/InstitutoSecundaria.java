package Tema0;

public class InstitutoSecundaria extends CentroEducativo {
    private char categoria;

    private String competicion;

    public InstitutoSecundaria(){
        super();
        categoria = ' ';
        competicion = "";
    }

    public InstitutoSecundaria(String nombre, int nEstudiantes, int nProfesores, int codigoPostal, char categoria, String competicion) {
        super(nombre, nEstudiantes, nProfesores, codigoPostal);
        this.categoria = categoria;
        this.competicion = competicion;
    }

    public InstitutoSecundaria(InstitutoSecundaria copia){
        super(copia);
        this.competicion = copia.competicion;
        this.categoria = copia.categoria;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        if(this.getnEstudiantes() < 400)
            this.categoria = 'A';
        if(this.getnEstudiantes() >= 400 && this.getnEstudiantes() < 700)
            this.categoria = 'B';
        if(this.getnEstudiantes() >= 700 && this.getnEstudiantes() < 1000)
            this.categoria = 'C';
        if(this.getnEstudiantes() >= 1000)
            this.categoria = 'D';
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        if(competicion.isBlank() || competicion.isEmpty()){
            this.competicion = "";
        }else this.competicion = competicion;
    }

    public String toString(){
        String resultado = super.toString() + " Este Instituto es de categoría " + categoria
                + ". En este centro se realiza la siguiente competicion: " + competicion;
        return resultado;
    }

    public InstitutoSecundaria clone(){
        InstitutoSecundaria clon = new InstitutoSecundaria(this);
        return clon;
    }

    public boolean equals(InstitutoSecundaria otro){
        if(!super.equals(otro))
            return false;
        if(this.categoria != otro.categoria)
            return false;
        if(!this.competicion.equals(otro.competicion))
            return false;
        return true;
    }
}
