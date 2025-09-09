import java.util.Scanner;

public class AgendaElectronica{
    public static void main(String[] args){
        boolean salir = false;
        LibroDirecciones libroDirecciones;
        Scanner scanner = new Scanner(System.in);


        // Cargar datos existentes
        try {
            libroDirecciones = (LibroDirecciones) GestorDeDatos.leerLibroDirecciones();
            while (!salir) {
            System.out.println("AGENDA ELECTRÓNICA");
            System.out.println("1. Añadir registro");
            System.out.println("2. Buscar registro");
            System.out.println("3. Modificar registro");
            System.out.println("4. Eliminar registro");
            System.out.println("5. Mostrar calendario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción por favor: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":

                    Empleo nuevoRegistro = libroDirecciones.anhadirEmpleado(scanner);

                    // Guardar el nuevo registro usando GestorDeDatos
                    if (nuevoRegistro != null) {
                        try {
                            GestorDeDatos.guardarLibroDirecciones(libroDirecciones);
                        } catch (Exception e) {
                            System.out.println("Error al guardar el registro: " + e.getMessage());
                        }
                    }
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println();                   
                    break;
                case "2":

                    System.out.println("Ingrese el nombre completo del empleado a buscar (nombre y apellidos, utiliza mayúsculas y puntuación adecuada): ");
                    String nombreCompleto = scanner.nextLine();
                    Empleo resultados = libroDirecciones.buscarEmpleadoPorNombre(nombreCompleto);
                    if (resultados == null) {
                        System.out.println("No se encontraron empleados con el nombre: " + nombreCompleto);
                    } else {
                        System.out.println("Empleado encontrado con el nombre " + nombreCompleto + ":");
                        System.out.println(resultados.toString());
                        System.out.println("Presione Enter para continuar...");

                    }
                    System.out.println();
                    scanner.nextLine(); // Limpiar el buffer
                    break;
                case "3":
                    
                    System.out.println("Ingrese el nombre completo del empleado a modificar (nombre y apellidos, utiliza mayúsculas y puntuación adecuada): ");
                    String nombreCompletoModificar = scanner.nextLine();
                    Empleo empleadoAModificar = libroDirecciones.buscarEmpleadoPorNombre(nombreCompletoModificar);
                    if (empleadoAModificar == null) {
                        System.out.println("No se encontraron empleados con el nombre: " + nombreCompletoModificar);
                    } else {
                        System.out.println("Empleado encontrado con el nombre " + nombreCompletoModificar + ":");
                        System.out.println(empleadoAModificar.toString() + "\n");

                        System.out.println("¿Qué deseas modificar?: \n" + 
                                            "1. Datos Personales\n" +
                                            "2. Insertar/Borrar citas\n" +
                                            "3. Insertar/Borrar notas");

                        String opcionModificar = scanner.nextLine();
                        switch(opcionModificar){
                            case "1":
                                System.out.println("\nTendrás que ingresar todos los datos de nuevo.\nPero las citas y notas se conservarán.\n");
                                empleadoAModificar = libroDirecciones.modificarDatosPersonales(nombreCompletoModificar, scanner);
                                break;
                            case "2":
                                System.out.println("Estas son las citas actuales: \n" + empleadoAModificar.mostrarCitas() + "\n");
                                System.out.println("Qué deseas hacer?\n1. Añadir cita\n2. Eliminar cita");
                                String opcionCita = scanner.nextLine();
                                switch(opcionCita){
                                    case "1":
                                        empleadoAModificar.agregarCita(libroDirecciones, nombreCompletoModificar, scanner);
                                        break;
                                    case "2":
                                        System.out.println("Ingrese el título de la cita a eliminar: ");
                                        String tituloCitaEliminar = scanner.nextLine();
                                        Cita citaEliminada = empleadoAModificar.eliminarCita(tituloCitaEliminar);
                                        if (citaEliminada != null) {
                                            System.out.println("Cita eliminada exitosamente.");
                                            try {
                                                GestorDeDatos.guardarLibroDirecciones(libroDirecciones);
                                                System.out.println("... Los cambios se han guardado correctamente ...");
                                            } catch (Exception e) {
                                                System.out.println("Error al guardar los cambios: " + e.getMessage());
                                            }
                                        } else {
                                            System.out.println("No se encontró una cita con el título: " + tituloCitaEliminar);
                                        }
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Regresando al menú principal.");
                                }

                                break;
                            case "3":
                                System.out.println("Estas son las notas actuales: \n" + empleadoAModificar.mostrarNotas() + "\n");
                                System.out.println("Qué deseas hacer?\n1. Añadir nota\n2. Eliminar nota");
                                String opcionNota = scanner.nextLine();
                                switch(opcionNota) {
                                    case "1":
                                        empleadoAModificar.agregarNota(libroDirecciones, nombreCompletoModificar, scanner);
                                        break;
                                    case "2":
                                        System.out.println("Ingrese el título de la nota a eliminar: ");
                                        String tituloNotaEliminar = scanner.nextLine();
                                        Nota notaEliminada = empleadoAModificar.eliminarNota(tituloNotaEliminar);
                                        if (notaEliminada != null) {
                                            System.out.println("Nota eliminada exitosamente.");
                                            try {
                                                GestorDeDatos.guardarLibroDirecciones(libroDirecciones);
                                                System.out.println("... Los cambios se han guardado correctamente ...");
                                            } catch (Exception e) {
                                                System.out.println("Error al guardar los cambios: " + e.getMessage());
                                            }
                                        } else {
                                            System.out.println("No se encontró una nota con el título: " + tituloNotaEliminar);
                                        }
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Regresando al menú principal.");
                                }

                                break;
                            default:
                                System.out.println("Opción no válida. Regresando al menú principal.");
                            }
                                System.out.println();
                                scanner.nextLine(); // Limpiar el buffer
                                break;  
                         }
                case "4":
                    
                    System.out.println("Ingrese el nombre completo del empleado a eliminar (nombre y apellidos, utiliza mayúsculas y puntuación adecuada): ");
                    String nombreCompletoEliminar = scanner.nextLine();

                    Empleo empleadoEliminado = libroDirecciones.eliminarRegistroPorNombre(nombreCompletoEliminar);
                    if (empleadoEliminado != null) {
                        System.out.println("¿Está seguro de que desea eliminar el siguiente empleado?");
                        System.out.println(empleadoEliminado.toString());
                        System.out.println("Escriba 's' para confirmar o cualquier otra tecla para cancelar:");
                        String confirmacion = scanner.nextLine();
                        if (confirmacion.equalsIgnoreCase("s")) {
                            System.out.println("Empleado eliminado exitosamente.");
                        } else {
                            System.out.println("Eliminación cancelada.");
                            // Si se cancela, se vuelve a añadir el empleado al libro
                            libroDirecciones.getEmpleados().add(empleadoEliminado);
                        }
                        try {
                            GestorDeDatos.guardarLibroDirecciones(libroDirecciones);
                            System.out.println("... Los cambios se han guardado correctamente ...");
                            System.out.println("Presione Enter para continuar...");
                        } catch (Exception e) {
                            System.out.println("Error al guardar los cambios: " + e.getMessage());
                        }
                        scanner.nextLine(); // Limpiar el buffer
                    } else {
                        System.out.println("No se encontró un empleado con el nombre: " + nombreCompletoEliminar);
                        scanner.nextLine(); // Limpiar el buffer
                    }

                    break;
                case "5":

                    try {
                        System.out.println("Ingrese el año (e.g., 2025): ");
                        int anho = scanner.nextInt();
                        System.out.println("Ingrese el mes (1-12): ");
                        int mes = scanner.nextInt();
                        Calendario calendario = new Calendario();
                        calendario.generaCalendario(mes, anho);
                        System.out.println(calendario.getRepresentacionMes());
                        scanner.nextLine(); // Limpiar el buffer
                       
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Por favor, ingrese números válidos para el año y el mes.");
                        scanner.nextLine(); // Limpiar el buffer
                    }
                    
                    break;
                case "6":
                    salir = true;
                    System.out.println("\n...Saliendo de la agenda electrónica...");
                    break;

                case "7":
                    // Opción oculta para mostrar todos los registros (para pruebas)
                    System.out.println("Registros en la agenda:");
                    for (Empleo emp : libroDirecciones.getEmpleados()) {
                        System.out.println(emp.toString());
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.\n");
            }
        }


        try {
            GestorDeDatos.guardarLibroDirecciones(libroDirecciones);
        } catch (Exception e) {
            System.out.println("Error al guardar los datos al salir: " + e.getMessage());
        }


        } catch (Exception e) {
            System.out.println("... No se pudieron cargar los datos ...");
            System.out.println(e.getMessage());
        }
        
        scanner.close();
    }        
}
