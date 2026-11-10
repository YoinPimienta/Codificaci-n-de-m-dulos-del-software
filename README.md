**SICAPS CRUD de pacientes — GA7-220501096-AA2-EV01**  
**Descripcion**  
Proyecto Java de consola que demuestra la conexion a MySQL mediante JDBC y las cuatro operaciones CRUD sobre la tabla `pacientes`: insertar, consultar, actualizar y eliminar. El proyecto utiliza Java 17 y Maven para administrar la dependencia MySQL Connector/J.  
**Estructura y modulos**  
```  
YOINPIMIENTA_AA2_EV01/  
 ├── config/  
 │   └── db.properties.example  
 ├── database/  
 │   └── sicaps_schema.sql  
 ├── src/main/java/  
 │   ├── conexion/  
 │   │   └── ConexionDB.java  
 │   ├── dao/  
 │   │   └── PacienteDAO.java  
 │   ├── modelo/  
 │   │   └── Paciente.java  
 │   └── principal/  
 │       └── Main.java  
 ├── .gitignore  
 ├── pom.xml  
 ├── README.md  
 └── Repositorio_GitHub.txt  
   
```  
- **conexion:** abre la conexion JDBC leyendo la configuracion local de `config/db.properties`.  
- **dao:** contiene las consultas SQL parametrizadas para insertar, consultar, actualizar y eliminar pacientes.  
- **modelo:** representa la entidad Paciente y sus atributos.  
- **principal:** ejecuta una demostracion de las operaciones CRUD y muestra los resultados en consola.  
- **database:** contiene el script SQL para crear la base de datos y la tabla necesaria.  
- **config:** contiene una plantilla de configuracion; las credenciales reales se guardan localmente y no se versionan.  
**Requisitos**  
- JDK 17.  
- MySQL Server y MySQL Workbench.  
- Apache Maven (NetBeans puede abrir proyectos Maven).  
- Conexion a internet la primera vez que Maven descargue MySQL Connector/J.  
**Preparacion de la base de datos**  
1. Abra MySQL Workbench y conectese a su servidor local.  
2. Abra y ejecute `database/sicaps_schema.sql`.  
3. En el proyecto, copie `config/db.properties.example` y cree una copia llamada `config/db.properties`.  
4. Edite `config/db.properties` y escriba la contrasena local correcta del usuario MySQL. No comparta ese archivo ni lo suba a GitHub.  
**Abrir y ejecutar**  
1. Extraiga la carpeta del ZIP.  
2. En NetBeans seleccione **File > Open Project** y elija la carpeta que contiene `pom.xml`.  
3. Espere a que Maven resuelva la dependencia `com.mysql:mysql-connector-j`.  
4. Compruebe la configuracion local `config/db.properties`.  
5. Ejecute `principal.Main`.  
6. Revise la salida de consola: se inserta un registro de prueba, se consulta, se actualiza y finalmente se elimina.  
El registro usado por `Main` es ficticio y solo sirve para probar las operaciones. No utilice datos reales de pacientes en esta demostracion.  
**Pruebas manuales sugeridas**  
- CREATE: confirmar que se informa el identificador del paciente insertado.  
- READ: comprobar que el listado muestra el identificador y los datos del registro.  
- UPDATE: comprobar que la operacion devuelve `true` y que el registro se actualiza.  
- DELETE: comprobar que la operacion devuelve `true` y que el registro de prueba deja de aparecer.  
**Estandares aplicados**  
- Paquetes en minuscula y nombres descriptivos.  
- Clases en PascalCase (`PacienteDAO`, `ConexionDB`, `Paciente`).  
- Metodos y variables en camelCase.  
- Consultas parametrizadas con `PreparedStatement`.  
- Cierre de conexiones, sentencias y resultados con `try-with-resources`.  
- Separacion de responsabilidades entre conexion, acceso a datos, modelo y ejecucion.  
- Credenciales fuera del codigo fuente y excluidas del control de versiones.  
**Repositorio remoto**  
El enlace del repositorio utilizado para esta evidencia se encuentra en [https://github.com/YoinPimienta/Codificaci-n-de-m-dulos-del-software.git](https://github.com/YoinPimienta/Codificaci-n-de-m-dulos-del-software.git "https://github.com/YoinPimienta/Codificaci-n-de-m-dulos-del-software.git")   
