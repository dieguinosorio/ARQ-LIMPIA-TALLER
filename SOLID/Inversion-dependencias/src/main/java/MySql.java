// MySQL.java
import java.sql.*;

public class MySql extends BaseDatos {
    @Override
    public void guardar(String datos) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_test", "admin", "admin1234");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO users (name, description) VALUES ('Diego', 'Esto es una descripción')");
            stmt.setString(1, datos);

            stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String leer() {
        String datosLeidos = "";
        try {
            // Establecer la conexión a MySQL
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_base_de_datos", "usuario", "contraseña");

            // Preparar la sentencia SQL para leer datos
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT datos FROM tabla_datos");

            // Leer los datos obtenidos
            while (rs.next()) {
                datosLeidos = rs.getString("datos");
            }

            // Cerrar la conexión
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datosLeidos;
    }
}
