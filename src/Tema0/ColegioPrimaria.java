package Tema0;

public class ColegioPrimaria extends CentroEducativo {
    private String eventoMensual;
    private String eventoComplementario;

    public ColegioPrimaria(){
        super();
        eventoMensual = "";
        eventoComplementario = "";
    }

    public ColegioPrimaria(String nombre, int nEstudiantes, int nProfesores, int codigoPostal, String eventoMensual, String eventoComplementario) {
        super(nombre, nEstudiantes, nProfesores, codigoPostal);
        this.eventoMensual = eventoMensual;
        this.eventoComplementario = eventoComplementario;
    }

    public ColegioPrimaria(ColegioPrimaria otro) {
        super(otro);
        this.eventoMensual = otro.eventoMensual;
        this.eventoComplementario = otro.eventoComplementario;
    }

    public void setnEstudiantes(int nEstudiantes) {
        if(nEstudiantes < 50 || nEstudiantes > 600)
            super.setnEstudiantes(-1);
        else super.setnEstudiantes(nEstudiantes);
    }

    public void setnProfesores(int nProfesores) {
        if(nProfesores >= 5 && nProfesores <= 100)
            super.setnProfesores(nProfesores);
        else super.setnProfesores(-1);
    }

    public String getEventoMensual() {
        return eventoMensual;
    }

    public void setEventoMensual(String eventoMensual) {
        if(eventoMensual.isBlank() || eventoMensual.isEmpty())
            this.eventoMensual = "";
        else this.eventoMensual = eventoMensual;
    }

    public String getEventoComplementario() {
        return eventoComplementario;
    }

    public void setEventoComplementario(String eventoComplementario) {
        this.eventoComplementario = eventoComplementario;
    }

    public void anunciarEventos(){
        System.out.println("Este mes, el evento es: " + eventoMensual);
        if(eventoComplementario.isBlank() || eventoComplementario.isEmpty()){
            System.out.println("Este mes, no hay eventos complementarios.");
        }else System.out.println("Además, se realizará el evento complementario: " + eventoComplementario);
    }

    public String toString() {
        String resultado;
        resultado = super.toString() + " Este mes, su evento es: " + eventoMensual + ".";
        if(eventoComplementario.isBlank() || eventoComplementario.isEmpty()){
            resultado += "Este mes, no hay eventos complementarios.";
        }else resultado += "Además, se realizará el evento complementario: " + eventoComplementario;
        return resultado;
    }

    public ColegioPrimaria clone(){
        ColegioPrimaria clon = new ColegioPrimaria(this);
        return clon;
    }

    public boolean equals(ColegioPrimaria otro){
        if(!super.equals(otro))
            return false;
        if(!this.eventoMensual.equals(otro.eventoMensual))
            return false;
        if(!this.eventoComplementario.equals(otro.eventoComplementario))
            return false;
        return true;
    }
}