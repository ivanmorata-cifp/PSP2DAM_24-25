package Tema0;

public class CentroFP extends CentroEducativo{
    private String empresaAsociada;
    private static String empresaExterna;

    public CentroFP(){
        super();
        empresaAsociada = "";
    }

    public CentroFP(String nombre, int nEstudiantes, int nProfesores, int codigoPostal, String empresaAsociada){
        super(nombre, nEstudiantes, nProfesores, codigoPostal);
        this.setEmpresaAsociada(empresaAsociada);
    }

    public CentroFP(CentroFP otro){
        super(otro);
        this.empresaAsociada = otro.empresaAsociada;
    }

    public String getEmpresaAsociada() {
        return empresaAsociada;
    }

    public void setEmpresaAsociada(String empresaAsociada) {
        this.empresaAsociada = empresaAsociada;
    }

    public static String getEmpresaExterna() {
        return empresaExterna;
    }

    public static void modificarEmpresaExterna(String otraEmpresa){
        empresaExterna = empresaExterna;
    }

    public CentroFP clone(){
        CentroFP clon = new CentroFP(this);
        return clon;
    }

    public String toString(){
        return super.toString() + " La empresa asociada a este centro es: " + empresaAsociada + ".";
    }

    public boolean equals(CentroFP otro){
        if(!super.equals(otro))
            return false;
        if(!this.empresaAsociada.equals(otro.empresaAsociada))
            return false;
        return true;
    }

}
