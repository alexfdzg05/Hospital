import java.util.Scanner;
import general.Paciente.Paciente;
import general.Doctor.Doctor;


public class Pruebas {
    public void mensajeBienvenida(){
        System.out.println("----Bienvenido al Hospital de Madrid----");
    }
    public static int menu(Scanner teclado){
        int opcion;
        do {
            System.out.print("Seleccione la operación que desea realizar: " +
                    "\n" + "1) Análisis Clínico " +
                    "\n" + "2) Reservar una cita " +
                    "\n" + "3) Buscar un paciente en Planta" +
                    "\n" + "4) Consultar información sobre el Hospital\n");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // No borrar, es para que se consuma el salto de línea;
        }while (opcion < 0 || opcion > 4);
        return opcion;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = menu(teclado);
        switch (opcion){
            case 1:
                Paciente paciente = introducirDatos(teclado);

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }
    public static Paciente introducirDatos(Scanner teclado){
        System.out.println("Ingrese su información como Paciente:");
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Defina sus sintomas: ");
        String sintomas = teclado.nextLine();
        return new Paciente(nombre,sintomas);
    }
}
