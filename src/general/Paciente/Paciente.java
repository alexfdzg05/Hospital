/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package general.Paciente;

public class Paciente {
    private String nombre;
    private EstadoPaciente estado;
    private Urgencia urgencia;
    private String sintomas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.estado = EstadoPaciente.hospitalizado;
    }

    public Paciente(String nombre, String sintomas, int prioridad) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.estado = EstadoPaciente.hospitalizado;
        switch (prioridad){
            case 1:
                this.urgencia = Urgencia.URGENCIA;
                break;
            case 2:
                this.urgencia = Urgencia.DOLOR_ALTO;
                break;
            case 3:
                this.urgencia = Urgencia.DOLOR_INTERMEDIO;
                break;
            case 4:
                this.urgencia = Urgencia.DOLOR_LEVE;
                break;
            case 5:
                this.urgencia = Urgencia.MOLESTIA;
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }


    public String getSintomas() {
        return sintomas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void darAlta() {
        estado = EstadoPaciente.alta;
    }

    public boolean estaAlta() {
        return estado == EstadoPaciente.alta;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + ".  Síntomas: " + sintomas + ".  Estado: " + estado.name());
    }
}
