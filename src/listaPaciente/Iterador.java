/**
 * Nombre: Alejandro
 * Apellido: Fernández
 * Num. Matrícula: bu0024
 */

package listaPaciente;

import general.Paciente.Paciente;

class Iterador {
    private Nodo actual;

    public Iterador(Nodo comienzo) {
        actual = comienzo;
    }

    public boolean hasNext() {
        return actual != null;
    }

    public Paciente next() {
        Paciente resultado = actual.getPaciente();
        actual = actual.getSiguiente();
        return resultado;
    }
}
