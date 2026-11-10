package dao;

import conexion.ConexionDB;
import modelo.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Ejecuta las operaciones CRUD de la entidad Paciente mediante JDBC. */
public class PacienteDAO {

    private final ConexionDB conexionDB;

    public PacienteDAO() {
        this.conexionDB = new ConexionDB();
    }

    /** Inserta un paciente y devuelve el identificador generado por MySQL. */
    public int insertarPaciente(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO pacientes (nombre, correo, telefono) VALUES (?, ?, ?)";

        try (Connection conexion = conexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            sentencia.setString(1, paciente.getNombre());
            sentencia.setString(2, paciente.getCorreo());
            sentencia.setString(3, paciente.getTelefono());
            sentencia.executeUpdate();

            try (ResultSet claves = sentencia.getGeneratedKeys()) {
                if (claves.next()) {
                    int idGenerado = claves.getInt(1);
                    paciente.setId(idGenerado);
                    return idGenerado;
                }
            }
        }

        throw new SQLException("El registro fue enviado, pero no se recibio el identificador generado.");
    }

    /** Consulta todos los pacientes registrados. */
    public List<Paciente> listarPacientes() throws SQLException {
        String sql = "SELECT id, nombre, correo, telefono FROM pacientes ORDER BY id";
        List<Paciente> pacientes = new ArrayList<>();

        try (Connection conexion = conexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultados = sentencia.executeQuery()) {

            while (resultados.next()) {
                Paciente paciente = new Paciente(
                        resultados.getInt("id"),
                        resultados.getString("nombre"),
                        resultados.getString("correo"),
                        resultados.getString("telefono")
                );
                pacientes.add(paciente);
            }
        }

        return pacientes;
    }

    /** Actualiza los datos de un paciente existente. */
    public boolean actualizarPaciente(Paciente paciente) throws SQLException {
        String sql = "UPDATE pacientes SET nombre = ?, correo = ?, telefono = ? WHERE id = ?";

        try (Connection conexion = conexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, paciente.getNombre());
            sentencia.setString(2, paciente.getCorreo());
            sentencia.setString(3, paciente.getTelefono());
            sentencia.setInt(4, paciente.getId());

            return sentencia.executeUpdate() > 0;
        }
    }

    /** Elimina el paciente cuyo identificador se recibe. */
    public boolean eliminarPaciente(int id) throws SQLException {
        String sql = "DELETE FROM pacientes WHERE id = ?";

        try (Connection conexion = conexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        }
    }
}
