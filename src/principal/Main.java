package principal;

import dao.PacienteDAO;
import modelo.Paciente;

public class Main {

    public static void main(String[] args) {

        PacienteDAO pacienteDAO = new PacienteDAO();

        // ==========================
        // INSERTAR
        // ==========================

        Paciente nuevoPaciente = new Paciente();

        nuevoPaciente.setNombre("Carlos Perez");
        nuevoPaciente.setCorreo("carlos@gmail.com");
        nuevoPaciente.setTelefono("3001112233");

        pacienteDAO.insertarPaciente(nuevoPaciente);

        // ==========================
        // CONSULTAR
        // ==========================

        System.out.println("\nLISTA DE PACIENTES:");
        pacienteDAO.listarPacientes();

        // ==========================
        // ACTUALIZAR
        // ==========================

        Paciente pacienteActualizar = new Paciente();

        pacienteActualizar.setId(1);
        pacienteActualizar.setNombre("Carlos Perez Actualizado");
        pacienteActualizar.setCorreo("actualizado@gmail.com");
        pacienteActualizar.setTelefono("3119998888");

        pacienteDAO.actualizarPaciente(pacienteActualizar);

        System.out.println("\nDESPUES DE ACTUALIZAR:");
        pacienteDAO.listarPacientes();

        // ==========================
        // ELIMINAR
        // ==========================

        pacienteDAO.eliminarPaciente(1);

        System.out.println("\nDESPUES DE ELIMINAR:");
        pacienteDAO.listarPacientes();
    }
}