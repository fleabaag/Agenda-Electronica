import java.util.Scanner;
import java.util.List;

public class Empleo extends Persona {

    private static final long serialVersionUID = 1L;
    private String compania;
    private String puesto;

    public Empleo(String compania, String puesto){
        super();
        this.compania = compania;
        this.puesto = puesto;
    }

    public Empleo(){
        super();
        this.compania = "";
        this.puesto = "";
    }


    //Getters y setters
    public String getCompania(){
        return this.compania;
    }

    public String getPuesto(){
        return this.puesto;
    }

    public void setCompania(String compania){
        this.compania = compania;
    }

    public void setPuesto(String puesto){
        this.puesto = puesto;
    }

    /**
     * Añade un nuevo registro de empleo.
     */
    public void anhadirRegistro(LibroDirecciones libroDirecciones, Scanner scanner) {

        super.anhadirRegistro(libroDirecciones, scanner);
        System.out.print("Ingrese el nombre de la compañia: ");
        String compania = scanner.nextLine();

        System.out.print("Ingrese el puesto: ");
        String puesto = scanner.nextLine();
        
        String nombre = getNombre();
        String apellido_paterno = getApellido_Paterno();
        String apellido_Materno = getApellido_Materno();

        nombre = nombre.replaceAll(" ", "_") + "_" + apellido_paterno.replaceAll(" ", "_") + "_" + apellido_Materno.replaceAll(" ", "_");

        setCompania(compania);
        setPuesto(puesto);

        try {
            GestorDeDatos.guardarRegistro(nombre, this);

        } catch (Exception e) {
            System.out.println("No se pudo guardar el registro de empleo.");
        }
        agregarCita(libroDirecciones, nombre, scanner);
        agregarNota(libroDirecciones, nombre, scanner);
        System.out.println("... Registro de persona añadido exitosamente ...");


        // scanner.close();
    }


    public void agregarCita(LibroDirecciones libroDirecciones, String nombre, Scanner scanner) {
        System.out.println("Desea agregar una cita? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            Cita nuevaCita = new Cita().anhadirCita();
            if (nuevaCita != null) {

                List<Cita> calendario = libroDirecciones.getCitas();

                boolean traslapa = false;
                for (Cita citaExistente : calendario) {
                    if (nuevaCita.seTraslapa(citaExistente)) {
                        traslapa = true;
                        break;
                    }
                }

                if (!traslapa) {
                    getCitas().add(nuevaCita);
                    System.out.println("... Cita añadida exitosamente ...");
                    libroDirecciones.anhadirCita(nuevaCita);
                    
                    try {
                    GestorDeDatos.guardarCita(nombre, nuevaCita.getTitulo(), nuevaCita);
                    } catch (Exception e) {
                        System.out.println("No se pudo guardar la cita.");
                    }                    
                    
                } else {
                    System.out.println("La cita se traslapa con una cita existente y no se puede añadir.");
                }
            }
        }
        // scanner.close();
    }


    /**
     * Añade una nueva nota al registro de la persona.
     */
    public void agregarNota(LibroDirecciones libroDirecciones, String nombre, Scanner scanner) {
        System.out.println("Desea agregar una nota? (s/n): ");
        String respuestaNota = scanner.nextLine();

        if (respuestaNota.equalsIgnoreCase("s")) {
            Nota nuevaNota = new Nota();
            nuevaNota.anhadirNota();
            getNotas().add(nuevaNota);
            libroDirecciones.anhadirNota(nuevaNota);
            try {
                GestorDeDatos.guardarNota(nombre, nuevaNota.getTitulo(), nuevaNota);
            } catch (Exception e) {
                System.out.println("No se pudo guardar la nota.");
            }
        }
        // scanner.close();
    }

    /**
     * Devuelve una representación en cadena del registro de empleo.
     * @return Una cadena que representa el registro de empleo.
     */
    @Override
    public String toString(){
        String output = "";
        String citas = "";
        String notas = "";

        if(!getCitas().isEmpty()){
            for(Cita cita : getCitas()){
                citas += cita.toString() + "\n";
            }
        }else{
            citas = "No hay citas.";
        }

        if(!getNotas().isEmpty()){
            for(Nota nota : getNotas()){
                notas += nota.toString() + "\n";
            }
        }else{
            notas = "No hay notas.";
        }

        output += super.toString();
        output += "Compañia: " + this.compania + "\n";
        output += "Puesto: " + this.puesto + "\n";
        output += "Citas: " + getCitas().size() + "\n";
        output += citas;
        output += "\nNotas: " + getNotas().size() + "\n";
        output += notas + "\n";
        return output;
    }

    /**
     * Muestra las citas del empleado.
     * @return Una cadena que representa las citas del empleado.
     */
    public String mostrarCitas(){
        String output = "";
        String citas = "";
        if(!getCitas().isEmpty()){
            for(Cita cita : getCitas()){
                citas += cita.toString() + "\n";
            }
        }else{
            citas = "No hay citas.";
        }

        output += "Citas: " + getCitas().size() + "\n";
        output += citas;

        return output;
    }


    /**
     * Muestra las notas del empleado.
     * @return Una cadena que representa las notas del empleado.
     */
    public String mostrarNotas(){
        String output = "";
        String notas = "";
        if(!getNotas().isEmpty()){
            for(Nota nota : getNotas()){
                notas += nota.toString() + "\n";
            }
        }else{
            notas = "No hay notas.";
        }

        output += "Notas: " + getNotas().size() + "\n";
        output += notas;

        return output;
    }

    /**
     * Elimina una cita por su nombre.
     * @param nombreCita El nombre de la cita a eliminar.
     * @return La cita eliminada, o null si no se encontró.
     */
    public Cita eliminarCita(String nombreCita) {
        Cita citaAEliminar = getCitas().stream()
                .filter(cita -> cita.getTitulo().equalsIgnoreCase(nombreCita))
                .findFirst()
                .orElse(null);
        if (citaAEliminar != null) {
            getCitas().remove(citaAEliminar);
        }
        return citaAEliminar;
    }

    
    /**
     * Elimina una nota por su nombre.
     * @param nombreNota El nombre de la nota a eliminar.
     * @return La nota eliminada, o null si no se encontró.
     */
    public Nota eliminarNota(String nombreNota) {
        Nota notaAEliminar = getNotas().stream()
                .filter(nota -> nota.getTitulo().equalsIgnoreCase(nombreNota))
                .findFirst()
                .orElse(null);
        if (notaAEliminar != null) {
            getNotas().remove(notaAEliminar);
        }
        return notaAEliminar;
    }
}