package Agenda;

public class Cita {
    private String paciente;
    private String telefono;
    private Fecha fecha;

    public Cita(String paciente, String telefono, int dia,
                int hora, int minuto) {
        this.paciente = paciente;
        this.telefono = telefono;
        this.fecha = new Fecha(dia,hora,minuto);
    }

    public Cita(String paciente, String telefono, Fecha fecha){
        this.paciente = paciente;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public String getPaciente() {
        return paciente;
    }

    public int getDia() {
        return fecha.getDia();
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String toString() {

        return paciente + " (" + telefono + ") - " + fecha.getDia()
                + ", " + fecha.getHora() + ":" + fecha.getMinuto();
    }
}




