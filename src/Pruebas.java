import java.util.Scanner;

import colaPaciente.ColaPrioridades;
import general.Doctor.Especializacion;
import general.Paciente.Paciente;
import general.Doctor.Doctor;
import general.Paciente.Urgencia;


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
        ColaPrioridades analisis = new ColaPrioridades();
        ColaPrioridades cardiologia = new ColaPrioridades();
        ColaPrioridades cirugia = new ColaPrioridades();
        ColaPrioridades tramuatologia = new ColaPrioridades();
        ColaPrioridades radiologia = new ColaPrioridades();
        ColaPrioridades rehabilitacion = new ColaPrioridades();
        ColaPrioridades neurologia = new ColaPrioridades();
        ColaPrioridades pediatria = new ColaPrioridades();
        ColaPrioridades[] cola = new ColaPrioridades[Especializacion.values().length];
        switch (opcion){
            case 1:
                Paciente paciente = introducirDatos(teclado);
                boolean continuarDiagnostico = false;
                do {
                    if (paciente.getSintomas().toLowerCase().contains("corazón") ||
                            paciente.getSintomas().toLowerCase().contains("pecho")) {
                        cardiologia.encolar(paciente);
                    } else if (paciente.getSintomas().toLowerCase().contains("cirugía") ||
                            paciente.getSintomas().toLowerCase().contains("operación")) {
                        cirugia.encolar(paciente);
                    } else if (paciente.getSintomas().toLowerCase().contains("rehabilitación") ||
                            paciente.getSintomas().toLowerCase().contains("masaje")) {
                        rehabilitacion.encolar(paciente);
                    } else if (paciente.getSintomas().toLowerCase().contains("rotura") ||
                            paciente.getSintomas().toLowerCase().contains("fisura") ||
                            paciente.getSintomas().toLowerCase().contains("esguince")) {
                        radiologia.encolar(paciente);
                    } else if (paciente.getSintomas().toLowerCase().contains("hictus") ||
                            paciente.getSintomas().toLowerCase().contains("cerebro")) {
                        neurologia.encolar(paciente);
                    } else if (paciente.getSintomas().toLowerCase().contains("niñ")) { //niñ detectará niño o niña
                        pediatria.encolar(paciente);
                    } else if (paciente.getSintomas().toLowerCase().contains("golpe")) {
                        tramuatologia.encolar(paciente);
                    } else {
                        analisis.encolar(paciente);
                        //Faltaría atender al paciente --> Hay que considerar el caso en el que haya un mal estudio
                        continuarDiagnostico = true;
                    }
                }while (continuarDiagnostico);
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
        int dolor = 0;
        do {
            System.out.println("Intensidad del dolor(1-5): " +
                    "\n 1) Urgencia" +
                    "\n 2) Dolor Alto" +
                    "\n 3) Dolor intermedio" +
                    "\n 4) Dolor Leve" +
                    "\n 5) Molestia");
            System.out.print("Seleccione opción: ");
            dolor = teclado.nextInt();
            if (dolor < 0 || dolor > 5){
                System.out.println("Seleccione un valor del 1 al 5");
            }
        }while (dolor < 0 || dolor > 5);

        return new Paciente(nombre,sintomas,dolor);
    }
    public void encolarPaciente(ColaPrioridades[] cola,Scanner teclado){
        Paciente paciente = introducirDatos(teclado);
        if (paciente.getSintomas().toLowerCase().contains("corazón") ||
                paciente.getSintomas().toLowerCase().contains("pecho")){
            cola[1].encolar(paciente);
        } else if (paciente.getSintomas().toLowerCase().contains("cirugía") ||
                paciente.getSintomas().toLowerCase().contains("operación")) {
            cirugia.encolar(paciente);
        } else if (paciente.getSintomas().toLowerCase().contains("rehabilitación") ||
                paciente.getSintomas().toLowerCase().contains("masaje")){
            rehabilitacion.encolar(paciente);
        } else if (paciente.getSintomas().toLowerCase().contains("rotura") ||
                paciente.getSintomas().toLowerCase().contains("fisura") ||
                paciente.getSintomas().toLowerCase().contains("esguince")){
            radiologia.encolar(paciente);
        } else if (paciente.getSintomas().toLowerCase().contains("hictus") ||
                paciente.getSintomas().toLowerCase().contains("cerebro")) {
            neurologia.encolar(paciente);
        } else if (paciente.getSintomas().toLowerCase().contains("niñ")){ //niñ detectará niño o niña
            pediatria.encolar(paciente);
        } else {
            analisis.encolar(paciente);
        }
    }
}
