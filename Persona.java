import java.util.List;

public class Persona{
    
    private String nombre;
    private String apellido_materno;
    private String apellido_Paterno;
    private String direcciones;
    private String telefono;
    private String movil;
    private String correo_Electronico;


    //URL, IG, Fck

    public Persona(String apellido_materno, String apellido_Paterno, String direcciones, String telefono, String movil, String correo_Electronico){
        this.apellido_materno= apellido_materno;
        this.apellido_materno= apellido_Paterno;
        this.direcciones = direcciones;
        this.telefono= telefono;
        this.movil= movil;
        this.correo_Electronico=correo_Electronico;
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
        this.telefono= telefono;
    }

    public void setcorreoElectronico(String correo_Electronico){
        this.correo_Electronico= correo_Electronico;
    }







}