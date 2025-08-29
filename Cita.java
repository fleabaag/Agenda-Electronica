import java.sql.Timestamp;
import java.util.Date;

public class Cita{
    private String titulo;
    private Date fecha;// dd/mm/AAAA
    private Timestamp hora; // HH:mm

    public Cita(String Titulo, Date fecha, Timestamp hora){
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
    }
}