package dao;

import conexion.ConexionDB;
import modelo.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDAO {

    ConexionDB conexionDB = new ConexionDB();

    // INSERTAR
    public void insertarPaciente(Paciente paciente) {

        String sql = "INSERT INTO pacientes(nombre, correo, telefono) VALUES (?, ?, ?)";

        try (
            Connection conexion = conexionDB.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {

            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getCorreo());
            ps.setString(3, paciente.getTelefono());

            ps.executeUpdate();

            System.out.println("Paciente insertado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al insertar: " + e.getMessage());

        }
    }

    // CONSULTAR
    public void listarPacientes() {

        String sql = "SELECT * FROM pacientes";

        try (
            Connection conexion = conexionDB.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | "
                        + rs.getString("nombre") + " | "
                        + rs.getString("correo") + " | "
                        + rs.getString("telefono")
                );
            }

        } catch (SQLException e) {

            System.out.println("Error al consultar: " + e.getMessage());

        }
    }

    // ACTUALIZAR
    public void actualizarPaciente(Paciente paciente) {

        String sql = "UPDATE pacientes SET nombre=?, correo=?, telefono=? WHERE id=?";

        try (
            Connection conexion = conexionDB.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {

            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getCorreo());
            ps.setString(3, paciente.getTelefono());
            ps.setInt(4, paciente.getId());

            ps.executeUpdate();

            System.out.println("Paciente actualizado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al actualizar: " + e.getMessage());

        }
    }

    // ELIMINAR
    public void eliminarPaciente(int id) {

        String sql = "DELETE FROM pacientes WHERE id=?";

        try (
            Connection conexion = conexionDB.conectar();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Paciente eliminado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al eliminar: " + e.getMessage());

        }
    }
}