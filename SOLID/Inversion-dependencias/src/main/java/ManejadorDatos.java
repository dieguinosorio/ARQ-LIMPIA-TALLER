public class ManejadorDatos {
    public void procesar(BaseDatos bd) {
        String datos = "Datos a guardar en BD";
        bd.guardar(datos);
        String datosLeidos = bd.leer();
        System.out.println("Datos de la BD: " + datosLeidos);
    }
}