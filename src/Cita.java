import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Cita implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private String titulo;
    private Date fecha;// dd/mm/AAAA
    private Timestamp hora; // HH:mm

    public Cita(){
        this.titulo = "";
        this.fecha = null;
        this.hora = null;
    }

    public Cita(String titulo, Date fecha, Timestamp hora){
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters y Setters
    public String getTitulo(){
        return this.titulo;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public Timestamp getHora(){
        return this.hora;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public void setHora(Timestamp hora){
        this.hora = hora;
    }

    /**
     * Verifica si dos citas se traslapan en fecha y hora
     * @param otraCita La otra cita a comparar
     * @return true si las citas se traslapan, false en caso contrario
     */
    public boolean seTraslapa(Cita otraCita){

        // Dos citas se traslapan si tienen la misma fecha y hora o si una empieza antes de que la otra termine
        // y termina después de que la otra empiece. Cada cita se asume que dura una hora.

        Timestamp finEstaCita = new Timestamp(this.hora.getTime() + 3600000); // 1 hora en milisegundos
        Timestamp inicioOtraCita = new Timestamp(otraCita.getHora().getTime());
        Timestamp finOtraCita = new Timestamp(otraCita.getHora().getTime() + 3600000);

        if (this.fecha.equals(otraCita.getFecha())) 
            return this.hora.equals(otraCita.getHora()) 
            || (inicioOtraCita.before(finEstaCita) && inicioOtraCita.after(this.hora))
            || (this.hora.before(finOtraCita) && this.hora.after(otraCita.getHora()));

        return false;
    }

    /**
     * Devuelve una representación en cadena de la cita.
     * @return Una cadena que representa la cita.
     */
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String output = "======== CITA ========\n";
        output += "Título: " + this.titulo + "\n";
        output += "Fecha: " + dateFormat.format(this.fecha) + "\n";
        output += "Hora: " + timeFormat.format(this.hora) + " hrs\n";
        return output;
    }

    public Cita anhadirCita(Scanner scanner){
        System.out.print("Ingrese el título de la cita: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese la fecha de la cita (dd/mm/AAAA): ");
        String fechaStr = scanner.nextLine();
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido. Use dd/mm/AAAA.");
            return null;
        }

        System.out.print("Ingrese la hora de la cita (HH:mm): ");
        String horaStr = scanner.nextLine();
        Timestamp hora = null;
        try {
            Date parsedTime = new SimpleDateFormat("HH:mm").parse(horaStr);
            hora = new Timestamp(parsedTime.getTime());
        } catch (Exception e) {
            System.out.println("Formato de hora inválido. Use HH:mm.");
            return null;
        }

        Cita nuevaCita = new Cita(titulo, fecha, hora);
        return nuevaCita;
    }

}