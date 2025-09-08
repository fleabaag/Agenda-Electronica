public class Calendario{

    
    // Atributos
    private int anho;
    private int mes;
    private int dia;
    private String representacionMes;
    private final String[] meses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    private final String[] diasSemana = {
        "Lu", "Ma", "Mi", "Ju", "Vi", "Sa", "Do"
    };

    
    // Constructor con todos los parámetros
    public Calendario(int anho, int mes, int dia, String representacionMes){
        this.anho = anho;
        this.mes = mes;
        this.dia = dia;
        this.representacionMes = representacionMes;
    }

    

    // Constructor por defecto
    public Calendario(){
        this.anho = 0;
        this.mes = 0;
        this.dia = 0;
        this.representacionMes = "";
    }

    //Getters y Setters

    public int getAnho(){
        return this.anho;
    }

    public int getMes(){
        return this.mes;
    }

    public int getDia(){
        return this.dia;
    }

    public String getRepresentacionMes(){
        return this.representacionMes;
    }

    public void setAAnho(int anho){
        this.anho = anho;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    
    public void setDia(int dia){
        this.dia = dia;
    }
       
    public void setRepresentacionMes(String representacionMes){
        this.representacionMes = representacionMes;
    }

    /**
     * Genera el calendario para un mes y año específicos.
     * Los parámetros mes y año deben ser válidos.
     * @param mes  El mes para el cual se generará el calendario (1-12).
     * @param anho El año para el cual se generará el calendario.
     */
    public void generaCalendario(int mes, int anho){

        String representacion = "";

        if (mes < 1 || mes > 12) {
            System.out.println("Mes inválido. Debe estar entre 1 y 12.");
            return;
        }
        if (anho < 1) {
            System.out.println("Año inválido. Debe ser un número entero positivo.");
            return;
        }

        representacion += "Calendario de " + meses[mes - 1] + " " + anho + ":\n";
        representacion += String.join(" ", diasSemana) + "\n";
        
        int primerDia = obtenerPrimerDiaDelMes(mes, anho);
        int diasEnMes = obtenerDiasEnMes(mes, anho);

        // Imprimir el calendario
        for (int i = 0; i < primerDia; i++) {
            representacion += "   ";
        }
        for (int dia = 1; dia <= diasEnMes; dia++) {
            representacion += String.format("%2d ", dia);
            if ((dia + primerDia) % 7 == 0) {
                representacion += "\n";
            }
        }
        this.representacionMes = representacion;
    }


    /**
     * Calcula el primer día de la semana para un mes y año específicos.
     * @param mes  El mes (1-12)
     * @param anho El año
     * @return El primer día de la semana (0=Domingo, 1=Lunes, ..., 6=Sábado)
     */
    public int obtenerPrimerDiaDelMes(int mes, int anho){
        // Implementación del algoritmo de Zeller para calcular el día de la semana
        if (mes < 3) {
            mes += 12;
            anho -= 1;
        }
        int y = anho % 100;
        int c = anho / 100;
        int diaSemana = (1 + (13 * (mes + 1)) / 5 + y + (y / 4) + (c / 4) - (2 * c)) % 7;

        return (diaSemana + 5) % 7; // Ajuste para 0=Lunes, ..., 6=Domingo
    }

    /** 
     * Determina si un año es bisiesto.
     * @param anho El año a evaluar
     * @return 1 si es bisiesto, 0 si no lo es
     */
    public boolean esBisiesto(int anho){
        boolean esBisiesto = false;
        if ((anho % 4 == 0 && anho % 100 != 0) || (anho % 400 == 0)) 
            esBisiesto = true;         
        return esBisiesto;
    }

    /**
     * Obtiene el número de días en un mes específico de un año.
     * @param mes El mes (1-12)
     * @param anho El año
     * @return El número de días en el mes (28, 29, 30, o 31)
     */
    public int obtenerDiasEnMes(int mes, int anho){
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(anho) ? 29 : 28;
            default:
                return 0; // Mes inválido
        }
    }
}