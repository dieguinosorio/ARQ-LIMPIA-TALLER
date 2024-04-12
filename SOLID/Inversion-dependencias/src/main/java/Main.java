// Main.java
public class Main {
    public static void main(String[] args) {
        ManejadorDatos manejador = new ManejadorDatos();
        System.out.println("Procesando MySQL:");
        manejador.procesar(new MySql());
    }
}
