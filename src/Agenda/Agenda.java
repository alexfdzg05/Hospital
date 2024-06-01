package Agenda;

public class Agenda {
    private static final int MAXIMO_DEFECTO = 50;

    private String mes;
    private Cita[] citas;
    private int numeroCitas;

    public Agenda(String mes, int maximoCitas) {
        this.mes = mes;
        citas = new Cita[maximoCitas];
        numeroCitas = 0;
    }

    public Agenda(String mes) {
        this(mes, MAXIMO_DEFECTO);
    }

    public void mostrarAgenda() {
        System.out.println(mes + "(" + numeroCitas + "):");
        for (int i = 0; i < numeroCitas; i++) {
            System.out.println("    " + (i + 1) + ". "
                    + citas[i].toString());
        }
    }

    public void mostrarCitasDia(int dia) {
        System.out.println(dia + " de " + mes + ":");
        int posicion = 0;
        for (int i = 0; i < numeroCitas; i++) {
            if (dia == citas[i].getDia()) {
                posicion++;
                System.out.println("    " + posicion + ". "
                        + citas[i].toString());
            }
        }
    }
    public boolean insertarCita(Cita cita) {
        boolean resultado = false;
        if (numeroCitas < citas.length) {
            citas[numeroCitas] = cita;
            numeroCitas++;
            resultado = true;
        }
        return resultado;
    }

    public boolean eliminarCita(int posicion) {
        boolean resultado = false;
        posicion = posicion - 1; // Por ser 1 la primera cita
        if (posicion >= 0 && posicion < numeroCitas) {
            for (int i = posicion + 1; i < numeroCitas; i++) {
                citas[i - 1] = citas[i];
            }
            numeroCitas--;
            resultado = true;
        }
        return resultado;
    }

    public int getNumeroCitasPaciente(String paciente) {
        int resultado = 0;
        for (int i = 0; i < numeroCitas; i++) {
            if (paciente.equals(citas[i].getPaciente())) {
                resultado++;
            }
        }
        return resultado;
    }
}


