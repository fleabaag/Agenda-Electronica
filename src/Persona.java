import java.util.List;

public class Persona{
    
    private String nombre;
    private String apellido_materno;
    private String apellido_Paterno;
    private String direcciones;
    private String telefono;
    private String movil;
    private String correo_Electronico;
    private String URL;
    private String Facebook;
    private String Instagram;
    private List<Cita> citas;


    //  Constructor con todos los parámetros
    public Persona(String nombre, String apellido_materno, String apellido_Paterno, String direcciones, String telefono, String movil, String correo_Electronico, String URL, String Facebook, String Instagram, List<Cita> citas){
        this.nombre = nombre;
        this.apellido_materno = apellido_materno;
        this.apellido_Paterno = apellido_Paterno;
        this.direcciones = direcciones;
        this.telefono = telefono;
        this.movil = movil;
        this.correo_Electronico = correo_Electronico;
        this.URL = URL;
        this.Facebook = Facebook;   
        this.Instagram = Instagram;
        this.citas = citas;
    }

    //  Constructor por defecto
    public Persona(){
        this.nombre = "";
        this.apellido_materno = "";
        this.apellido_Paterno = "";
        this.direcciones = "";
        this.telefono = "";
        this.movil = "";
        this.correo_Electronico = "";
        this.URL = "";
        this.Facebook = "";   
        this.Instagram = "";
        this.citas = null;
    }

    //Getters y setters

    public String getnombre(){
        return this.nombre;
    }

    public String getapellido_materno(){
        return this.apellido_materno;
    }

    public String getapellido_Paterno(){
        return this.apellido_Paterno;
    }

    public String getdirecciones(){
        return this.direcciones;
    }

    public String gettelefeno(){
        return this.telefono;
    }

    public String getmovil(){
        return this.movil;
    }

    public String getcorreo_Electronico(){
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
    public void setapellido_materno( String apellido_materno){
        this.apellido_materno= apellido_materno;
    }

    public void setapellido_Paterno(String apellido_Paterno){
        this.apellido_Paterno= apellido_Paterno;
    }

    public void setdirecciones(String direcciones){
       this.direcciones= direcciones;
    }

    public void settelefono(String telefono){
        this.telefono= telefono;
    }

    public void setmovil(String movil){
        this.movil = movil;
    }

    public void setcorreoElectronico(String correo_Electronico){
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

}