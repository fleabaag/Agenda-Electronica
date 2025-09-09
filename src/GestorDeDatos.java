import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GestorDeDatos {

    private static final String BASE_PATH = "data";

    
    // MÉTODOS DE UTILIDAD
    

    /**
     * Asegura que el directorio exista, creándolo si es necesario.
     * @param path el path del directorio a asegurar
     * @throws IOException si ocurre un error al crear el directorio
     */
    private static void asegurarDirectorio(String path) throws IOException {
        Files.createDirectories(Paths.get(path));
    }


    /**
     * Escribe un objeto en un archivo.
     * @param filePath el path del archivo donde se escribirá el objeto
     * @param obj el objeto a escribir
     * @throws IOException si ocurre un error al escribir el objeto
     */
    private static void writeObject(String filePath, Object obj) throws IOException {
        asegurarDirectorio(Paths.get(filePath).getParent().toString());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
        }
    }

    private static Object readObject(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        }
    }

    
    // REGISTROS
    

    /**
     * Guarda un registro de persona.
     * @param persona el nombre de la persona
     * @param registro el objeto de registro a guardar
     * @throws IOException si ocurre un error al guardar el registro
     */
    public static void guardarRegistro(String persona, Object registro) throws IOException {
        String path = BASE_PATH + "/historico/registros/" + persona + ".data";
        writeObject(path, registro);
    }


    /**
     * Lee un registro de persona.
     * @param persona el nombre de la persona
     * @return el objeto de registro leído
     * @throws IOException si ocurre un error al leer el registro
     * @throws ClassNotFoundException si la clase del objeto no se encuentra
     */
    public static Object leerRegistro(String persona) throws IOException, ClassNotFoundException {
        String path = BASE_PATH + "/historico/registros/" + persona + ".data";
        return readObject(path);
    }


    // LIBRO DE DIRECCIONES

    /**
     * Guarda el libro de direcciones.
     * @param libroDirecciones el objeto de libro de direcciones a guardar
     * @throws IOException si ocurre un error al guardar el libro de direcciones
     */
    public static void guardarLibroDirecciones(Object libroDirecciones) throws IOException {
        String path = BASE_PATH + "/activo/libro_direcciones.data";
        writeObject(path, libroDirecciones);
    }

    /**
     * Lee un contacto del libro de direcciones.
     * @param persona el nombre de la persona
     * @return el objeto de contacto leído
     * @throws IOException si ocurre un error al leer el contacto
     * @throws ClassNotFoundException si la clase del objeto no se encuentra
     */
    public static Object leerLibroDirecciones() throws IOException, ClassNotFoundException {
    String path = BASE_PATH + "/activo/libro_direcciones.data";
    File f = new File(path);
    if (!f.exists()) {
        System.out.println("No existe libro de direcciones, creando uno nuevo...");
        LibroDirecciones nuevo = new LibroDirecciones();
        guardarLibroDirecciones(nuevo);
        return nuevo;
    }
    return (LibroDirecciones) readObject(path);
}



    // CITAS
    

    /**
     * Guarda una cita.
     * @param persona el nombre de la persona
     * @param nombreCita el nombre de la cita
     * @param cita el objeto de cita a guardar
     * @throws IOException si ocurre un error al guardar la cita
     */
    public static void guardarCita(String persona, String nombreCita, Object cita) throws IOException {
        String path = BASE_PATH + "/historico/citas/" + persona + "/" + nombreCita + ".data";
        writeObject(path, cita);
    }


    /**
     * Lee una cita.
     * @param persona el nombre de la persona
     * @param nombreCita el nombre de la cita
     * @return el objeto de cita leído
     * @throws IOException si ocurre un error al leer la cita
     * @throws ClassNotFoundException si la clase del objeto no se encuentra
     */
    public static Object leerCita(String persona, String nombreCita) throws IOException, ClassNotFoundException {
        String path = BASE_PATH + "/historico/citas/" + persona + "/" + nombreCita + ".data";
        return readObject(path);
    }


    /**
     * Lista las citas de una persona.
     * @param persona el nombre de la persona
     * @return una lista con los nombres de las citas
     * @throws IOException si ocurre un error al listar las citas
     */
    public static List<String> listarCitas(String persona) throws IOException {
        String dirPath = BASE_PATH + "/historico/citas/" + persona;
        asegurarDirectorio(dirPath);
        File dir = new File(dirPath);
        List<String> citas = new ArrayList<>();
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.isFile() && f.getName().endsWith(".data")) {
                citas.add(f.getName().replace(".data", ""));
            }
        }
        return citas;
    }

    
    // NOTAS
    
    /**
     * Guarda una nota.
     * @param persona el nombre de la persona
     * @param nombreNota el nombre de la nota
     * @param nota el objeto de nota a guardar
     * @throws IOException si ocurre un error al guardar la nota
     */
    public static void guardarNota(String persona, String nombreNota, Object nota) throws IOException {
        String path = BASE_PATH + "/historico/notas/" + persona + "/" + nombreNota + ".data";
        writeObject(path, nota);
    }

    /**
     * Lee una nota.
     * @param persona el nombre de la persona
     * @param nombreNota el nombre de la nota
     * @return el objeto de nota leído
     * @throws IOException si ocurre un error al leer la nota
     * @throws ClassNotFoundException si la clase del objeto no se encuentra
     */
    public static Object leerNota(String persona, String nombreNota) throws IOException, ClassNotFoundException {
        String path = BASE_PATH + "/historico/notas/" + persona + "/" + nombreNota + ".data";
        return readObject(path);
    }


    /**
     * Lista las notas de una persona.
     * @param persona el nombre de la persona
     * @return una lista con los nombres de las notas
     * @throws IOException si ocurre un error al listar las notas
     */
    public static List<String> listarNotas(String persona) throws IOException {
        String dirPath = BASE_PATH + "/historico/notas/" + persona;
        asegurarDirectorio(dirPath);
        File dir = new File(dirPath);
        List<String> notas = new ArrayList<>();
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.isFile() && f.getName().endsWith(".data")) {
                notas.add(f.getName().replace(".data", ""));
            }
        }
        return notas;
    }
}
