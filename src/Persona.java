import java.util.List;
import java.util.Scanner;

public class Persona implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido_Materno;
    private String apellido_Paterno;
    private String direcciones;
    private String telefono;
    private String movil;
    private String correo_Electronico;
    private String URL;
    private String Facebook;
    private String Instagram;
    private List<Cita> citas;
    private List<Nota> notas;


    //  Constructor con todos los parámetros
    public Persona(String nombre, String apellido_Materno, String apellido_Paterno, String direcciones, String telefono, String movil, String correo_Electronico, String URL, String Facebook, String Instagram, List<Cita> citas, List<Nota> notas){
        this.nombre = nombre;
        this.apellido_Materno = apellido_Materno;
        this.apellido_Paterno = apellido_Paterno;
        this.direcciones = direcciones;
        this.telefono = telefono;
        this.movil = movil;
        this.correo_Electronico = correo_Electronico;
        this.URL = URL;
        this.Facebook = Facebook;   
        this.Instagram = Instagram;
        this.citas = citas;
        this.notas = notas;
    }

    //  Constructor por defecto
    public Persona(){
        this.nombre = "";
        this.apellido_Materno = "";
        this.apellido_Paterno = "";
        this.direcciones = "";
        this.telefono = "";
        this.movil = "";
        this.correo_Electronico = "";
        this.URL = "";
        this.Facebook = "";   
        this.Instagram = "";
        this.citas = new java.util.ArrayList<Cita>();
        this.notas = new java.util.ArrayList<Nota>();
    }

    //Getters y setters

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido_Materno(){
        return this.apellido_Materno;
    }

    public String getApellido_Paterno(){
        return this.apellido_Paterno;
    }

    public String getDirecciones(){
        return this.direcciones;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getMovil(){
        return this.movil;
    }

    public String getCorreo_Electronico(){
        return this.correo_Electronico;
    }

    public String getURL(){
        return this.URL;
    }
    public String getFacebook(){
        return this.Facebook;
    }

    public String getInstagram(){
        return this.Instagram;
    }

    public List<Cita> getCitas(){
        return this.citas;
    }

    public List<Nota> getNotas(){
        return this.notas;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    public void setApellido_Materno(String apellido_Materno){
        this.apellido_Materno= apellido_Materno;
    }

    public void setApellido_Paterno(String apellido_Paterno){
        this.apellido_Paterno= apellido_Paterno;
    }

    public void setDirecciones(String direcciones){
       this.direcciones= direcciones;
    }

    public void setTelefono(String telefono){
        this.telefono= telefono;
    }

    public void setMovil(String movil){
        this.movil = movil;
    }

    public void setCorreo_Electronico(String correo_Electronico){
        this.correo_Electronico= correo_Electronico;
    }

    public void setURL(String URL){
        this.URL= URL;
    }

    public void setFacebook(String Facebook){
        this.Facebook= Facebook;
    }

    public void setInstagram(String Instagram){
        this.Instagram= Instagram;
    }

    public void setCitas(List<Cita> citas){
        this.citas= citas;
    }

    public void setNotas(List<Nota> notas){
        this.notas= notas;
    }

    /**
     * Añade un nuevo registro de persona.
     */
    public void anhadirRegistro(LibroDirecciones libroDirecciones, Scanner scanner) {

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido paterno: ");
        String apellido_Paterno = scanner.nextLine();

        System.out.print("Ingrese el apellido materno: ");
        String apellido_Materno = scanner.nextLine();

        System.out.print("Ingrese la dirección: ");
        String direcciones = scanner.nextLine();

        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();
        // Se revisa formato del teléfono a 10 dígitos y todos números con regex
        while (!telefono.matches("\\d{10}")) {
            System.out.print("Teléfono inválido. Ingrese el teléfono (10 dígitos): ");
            telefono = scanner.nextLine();
        }

        System.out.print("Ingrese el móvil: ");
        String movil = scanner.nextLine();
        // Mismo formato para móvil
        while (!movil.matches("\\d{10}")) {
            System.out.print("Móvil inválido. Ingrese el móvil (10 dígitos): ");
            movil = scanner.nextLine();
        }

        System.out.print("Ingrese el correo electrónico: ");
        String correo_Electronico = scanner.nextLine();
        // Se revisa formato del correo con regex
        while (!correo_Electronico.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) { // Formato básico de email
            System.out.print("Correo electrónico inválido. Ingrese el correo electrónico: ");
            correo_Electronico = scanner.nextLine();
        }

        System.out.print("Ingrese la URL: ");
        String URL = scanner.nextLine();

        // Se revisa formato de la URL con regex
        while (!URL.matches("^(http|https)://.*$")) {
            System.out.print("URL inválida. Ingrese la URL (debe comenzar con http:// o https://): ");
            URL = scanner.nextLine();
        }

        System.out.print("Ingrese el Facebook: ");
        String Facebook = scanner.nextLine();

        System.out.print("Ingrese el Instagram: ");
        String Instagram = scanner.nextLine();

        // Se revisa formato de Instagram que empiece con @
        while (!Instagram.matches("^@.*$")) {
            System.out.print("Instagram inválido. Ingrese el Instagram (debe comenzar con @): ");
            Instagram = scanner.nextLine();
        }

        setNombre(nombre);
        setApellido_Paterno(apellido_Paterno);
        setApellido_Materno(apellido_Materno);
        setDirecciones(direcciones);
        setTelefono(telefono);
        setMovil(movil);
        setCorreo_Electronico(correo_Electronico);
        setURL(URL);
        setFacebook(Facebook);
        setInstagram(Instagram);

        //scanner.close(); // No cerrar el scanner aquí para evitar cerrar System.in
    }

    /**
     * Devuelve una representación en cadena de la persona.
     * @return Una cadena que representa la persona.
     */
    @Override
    public String toString(){
        String output = "======== DATOS DEL CONTACTO ========\n";
        output += "Nombre: " + this.nombre + "\n";
        output += "Apellido Paterno: " + this.apellido_Paterno + "\n";
        output += "Apellido Materno: " + this.apellido_Materno + "\n";
        output += "Dirección: " + this.direcciones + "\n";
        output += "Teléfono: " + this.telefono + "\n";
        output += "Móvil: " + this.movil + "\n";
        output += "Correo Electrónico: " + this.correo_Electronico + "\n";
        output += "URL: " + this.URL + "\n";
        output += "Facebook: " + this.Facebook + "\n";
        output += "Instagram: " + this.Instagram + "\n";
        return output;
    }
}