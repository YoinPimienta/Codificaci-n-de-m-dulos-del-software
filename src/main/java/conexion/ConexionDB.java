package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** Gestiona la conexion JDBC con la base de datos SICAPS. */
public class ConexionDB {

    private static final Path ARCHIVO_CONFIGURACION = Path.of("config", "db.properties");

    public Connection conectar() throws SQLException {
        Properties propiedades = new Properties();

        if (!Files.exists(ARCHIVO_CONFIGURACION)) {
            throw new SQLException(
                    "No se encontro config/db.properties. Copie db.properties.example, "
                    + "complete los datos locales y vuelva a ejecutar el programa."
            );
        }

        try (InputStream entrada = Files.newInputStream(ARCHIVO_CONFIGURACION)) {
            propiedades.load(entrada);
        } catch (IOException e) {
            throw new SQLException("No fue posible leer la configuracion de la base de datos.", e);
        }

        String url = propiedades.getProperty("db.url", "").trim();
        String usuario = propiedades.getProperty("db.user", "").trim();
        String contrasena = propiedades.getProperty("db.password", "");

        if (url.isBlank() || usuario.isBlank()) {
            throw new SQLException("La URL y el usuario de la base de datos deben estar configurados.");
        }

        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
