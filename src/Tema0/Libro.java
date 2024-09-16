package Tema0;

public class Libro {
    private String titulo, autor, genero;
    private int nPaginas;

    public Libro(){
        titulo = autor = genero = "";
        nPaginas = -1;
    }

    public Libro(String titulo, String autor, String genero, int nPaginas) {
        setTitulo(titulo);
        setAutor(autor);
        setGenero(genero);
        setnPaginas(nPaginas);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo.length()<=20)
            this.titulo = titulo;
        else this.titulo = "";
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        boolean ok = true;
        for(int i=0; i<autor.length(); i++){
            if(autor.charAt(i)>=48 && autor.charAt(i)<=57){
                ok = false;
            }
        }
        if(ok)
            this.autor = autor;
        else this.autor = "";
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if(!genero.contains(" "))
            this.genero = genero.toLowerCase();
        else this.genero = "";
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        if(nPaginas < 10 || nPaginas > 2000)
            this.nPaginas = -1;
        else this.nPaginas = nPaginas;
    }

    public boolean comprobarAutor(String otroAutor){
        return autor.equals(otroAutor);
    }

    public boolean comprobarTitulo(String otroTitulo){
        return titulo.equals(otroTitulo);
    }

    public boolean compruebaPaginas(Libro otro){
        return (this.nPaginas > otro.nPaginas);
    }

    public void mensajeCustomizado(){
        switch(genero){
            case "Fantasía":
                System.out.println("Prepárate para vivir una aventura fantástica.");
                break;
            case "Ciencia Ficción":
                System.out.println("Disfrutarás de una aventura más allá de tus expectativas");
                break;
            case "Misterio":
                System.out.println("No serás capaz de soltarlo.");
                break;
            default:
                System.out.println("Disfruta de la gran variedad de nuestra biblioteca.");
        }
    }
}
