import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroDirecciones implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    private List<Empleo> empleados;
    private List<Cita> citas;
    private List<Nota> notas;

    public LibroDirecciones(List<Empleo> empleados, List<Cita> citas,List<Nota> notas){
        this.empleados = empleados;
        this.citas = citas;
        this.notas = notas;
    }

    public LibroDirecciones(){
        this.empleados = new java.util.ArrayList<Empleo>();
        this.citas = new java.util.ArrayList<Cita>();
        this.notas = new java.util.ArrayList<Nota>();
    }

    //Getters y setters
    public List<Empleo> getEmpleados(){
        return this.empleados;
    }

    public List<Cita> getCitas(){
        return this.citas;
    }

    public List<Nota> getNotas(){
        return this.notas;
    }

    public void setEmpleados(List<Empleo> empleados){
        this.empleados = empleados;
    }

    public void setCitas(List<Cita> citas){
        this.citas = citas;
    }

    public void setNotas(List<Nota> notas){
        this.notas = notas;
    }

    /**
     * Añade un empleado al libro de direcciones.
     * @param empleo El empleado a añadir.
     */
    public void anhadirEmpleado(Empleo empleo){
        this.empleados.add(empleo);
    }

    /**
     * Crea un nuevo empleado y lo añade al libro de direcciones.
     */
    public Empleo anhadirEmpleado(Scanner scanner) {
        Empleo nuevoEmpleado = new Empleo();
        nuevoEmpleado.anhadirRegistro(this, scanner);
        this.empleados.add(nuevoEmpleado);
        return nuevoEmpleado;
    }

    /**
     * Añade una cita al libro de direcciones.
     * @param cita La cita a añadir.
     */
    public Cita anhadirCita(Cita cita){
        this.citas.add(cita);
        return cita;
    }

    /**
     * Añade una nota al libro de direcciones.
     * @param nota La nota a añadir.
     */
    public Nota anhadirNota(Nota nota){
        this.notas.add(nota);
        return nota;
    }

    /**
     * Busca empleados por su nombre completo (nombre y apellidos).
     * @param nombreCompleto El nombre completo a buscar.
     * @return Una lista de empleados que coinciden con el nombre completo.
     */
    public Empleo buscarEmpleadoPorNombre(String nombreCompleto){
        for(Empleo emp : this.getEmpleados()){

            String nombreCompletoEmpleado = emp.getNombre() + " " + emp.getApellido_Paterno() + " " + emp.getApellido_Materno();
            // System.out.println("Sí buscando: '" + nombreCompleto + "' contra '" + nombreCompletoEmpleado + "'");
            if(nombreCompletoEmpleado.equalsIgnoreCase(nombreCompleto)){
                return emp;
            }
        }
        return null;
    }


    /**
     * Elimina un empleado por su nombre completo (nombre y apellidos).
     * @param nombreCompleto El nombre completo del empleado a eliminar.
     * @return El empleado eliminado, o null si no se encontró.
     */
    public Empleo eliminarRegistroPorNombre(String nombreCompleto){
        Empleo empleadoAEliminar = null;
        for(Empleo emp : this.getEmpleados()){

            String nombreCompletoEmpleado = emp.getNombre() + " " + emp.getApellido_Paterno() + " " + emp.getApellido_Materno();
            // System.out.println("Sí buscando: '" + nombreCompleto + "' contra '" + nombreCompletoEmpleado + "'");
            if(nombreCompletoEmpleado.equalsIgnoreCase(nombreCompleto)){
                empleadoAEliminar = emp;
                break;
            }
        }

        if(empleadoAEliminar != null){
            empleados.remove(empleadoAEliminar);
        }

        return empleadoAEliminar;
    }

    /**
     * Modifica los datos personales de un empleado.
     * @param nombreCompleto El nombre completo del empleado a modificar.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @return El empleado modificado, o null si no se encontró.
     */
    public Empleo modificarDatosPersonales(String nombreCompleto, Scanner scanner){


        Empleo empleadoViejo = buscarEmpleadoPorNombre(nombreCompleto);
        
        if(empleadoViejo != null){
            List<Cita> citas = empleadoViejo.getCitas();
            List<Nota> notas = empleadoViejo.getNotas();

            Empleo empleadoNuevo = new Empleo();
            empleadoNuevo.anhadirRegistro(this, scanner);
            empleadoNuevo.setCitas(citas);
            empleadoNuevo.setNotas(notas);

            this.empleados.remove(empleadoViejo);
            this.empleados.add(empleadoNuevo);

            try {
                GestorDeDatos.guardarLibroDirecciones(this);
            } catch (Exception e) {
                System.out.println("No se pudo guardar el registro modificado.");
            }

            return empleadoNuevo;
        }
        return null;
    }
}