import java.util.Scanner;

public class Nota implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private String titulo;
    private String nota;

    //Constructor con todos los parámetros
    public Nota(String titulo, String nota){
        this.titulo = titulo;
        this.nota = nota;
    }

    //Constructor por defecto
    public Nota(){
        this.titulo = "";
        this.nota = "";
    }

    // Getter
    public String getTitulo(){
        return this.titulo;
    }

    // Getter para la nota
    public String getNota(){
        return this.nota;
    }

    // Setter
    public void setNota(String nota){
        this.nota = nota;
    }

    // Setter para el título
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void anhadirNota(Scanner scanner){
        System.out.print("Ingrese el título de la nota: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese la nota: ");
        String nota = scanner.nextLine();
        setTitulo(titulo);
        setNota(nota);
        System.out.println("... Nota añadida exitosamente ...");
        // scanner.close();
    }

    @Override
    public String toString(){
        return  "======== NOTA ========\n" +
                "Título: " + this.titulo +
                "\nDescripción: " + this.nota;
    }
}