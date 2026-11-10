package principal;

import dao.PacienteDAO;
import modelo.Paciente;

import java.sql.SQLException;

/** Ejecuta una demostracion de las cuatro operaciones CRUD de pacientes. */
public class Main {

    public static void main(String[] args) {
        PacienteDAO pacienteDAO = new PacienteDAO();

        try {
            // CREATE: insertar un registro de demostracion.
            Paciente nuevoPaciente = new Paciente(
                    "Paciente de prueba",
                    "prueba@example.com",
                    "3000000000"
            );
            int idPaciente = pacienteDAO.insertarPaciente(nuevoPaciente);
            System.out.println("Paciente insertado con ID: " + idPaciente);

            // READ: consultar y mostrar los registros.
            System.out.println("\nLISTA DE PACIENTES:");
            pacienteDAO.listarPacientes().forEach(paciente -> System.out.println(
                    paciente.getId() + " | " + paciente.getNombre() + " | "
                    + paciente.getCorreo() + " | " + paciente.getTelefono()
            ));

            // UPDATE: modificar el registro que se acaba de crear.
            Paciente pacienteActualizado = new Paciente(
                    idPaciente,
                    "Paciente de prueba actualizado",
                    "actualizado@example.com",
                    "3110000000"
            );
            System.out.println("\nActualizacion realizada: "
                    + pacienteDAO.actualizarPaciente(pacienteActualizado));

            // DELETE: eliminar el mismo registro de demostracion.
            System.out.println("Eliminacion realizada: " + pacienteDAO.eliminarPaciente(idPaciente));

            System.out.println("\nRegistros restantes: " + pacienteDAO.listarPacientes().size());
        } catch (SQLException e) {
            System.err.println("No fue posible completar la demostracion CRUD: " + e.getMessage());
            System.err.println("Verifique MySQL, la base de datos y config/db.properties.");
        }
    }
}
