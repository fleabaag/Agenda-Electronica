import java.util.Scanner;

public class AgendaElectronica{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

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
            scanner.nextLine();  

            switch (opcion) {
                case "1":
                    





                    break;
                case "2":
                    





                    break;
                case "3":
                    






                    break;
                case "4":
                    





                    break;
                case "5":
                    



                
                    break;
                case "6":
                    salir = true;
                    System.out.println("\n...Saliendo de la agenda electrónica...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.\n");
            }
        }

        scanner.close();
    }
}



        