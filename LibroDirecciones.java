import java.util.List;

public class LibroDirecciones{
    
    private Empleo empleado;
    private List<Cita> citas;
    private List<Nota> notas;

    private LibroDirecciones(Empleo empleado, List<Cita> citas,List<Nota> notas){
        this.empleado = empleado;
        this.citas = citas;
        this.notas = notas;
    }

}