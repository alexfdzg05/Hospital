package general.Doctor;

import Agenda.Agenda;

public class Doctor {
    private String nombre;
    private Agenda agenda; //Podríamos usar una estructura de Datos aquí
    //Análisis clínico es lo más genérico --> De ahí normalmente se lo pasaremos a otro doctor.
    private Especializacion especializacion;
    private Jerarquia jerarquia;
    public Doctor(String nombre, int especializacion, int jerarquia){
        this.nombre = nombre;
        switch (especializacion){
            case 0:
                this.especializacion = Especializacion.ANALISIS_CLINICO;
                break;
            case 1:
                this.especializacion = Especializacion.CARDIOLOGIA;
                break;
            case 2:
                this.especializacion = Especializacion.CIRUGIA;
                break;
            case 3:
                this.especializacion = Especializacion.TRAUMATOLOGIA;
                break;
            case 4:
                this.especializacion = Especializacion.RADIOLOGIA;
                break;
            case 5:
                this.especializacion = Especializacion.REHABILITACION;
                break;
            case 6:
                this.especializacion = Especializacion.NEUROLOGIA;
                break;
            case 7:
                this.especializacion = Especializacion.PEDIATRIA;
                break;
        }
        switch (jerarquia){
            case 0:
                this.jerarquia = general.Doctor.Jerarquia.DIRECTOR_DE_DEPARAMENTO;
                break;
            case 1:
                this.jerarquia = general.Doctor.Jerarquia.JEFE_DE_SECCION;
                break;
            case 2:
                this.jerarquia = general.Doctor.Jerarquia.MEDICO;
                break;
            case 3:
                this.jerarquia = general.Doctor.Jerarquia.ENFERMERO;
                break;
            case 4:
                this.jerarquia = general.Doctor.Jerarquia.RESIDENTE;
                break;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public String getEspecializacion() {
        return especializacion.toString();
    }

    public String getJerarquia() {
        return jerarquia.toString();
    }
}
