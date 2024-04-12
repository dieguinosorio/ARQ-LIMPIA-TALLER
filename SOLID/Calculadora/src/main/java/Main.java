public class Main {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        int resSuma = calc.sumar(5, 3);
        System.out.println("Suma: " + resSuma);

        int resResta = calc.restar(8, 2);
        System.out.println("Resta: " + resResta);

        int resMultiplicacion = calc.multiplicar(4, 6);
        System.out.println("Multiplicación: " + resMultiplicacion);

        try {
            double resDivision = calc.dividir(10, 2);
            System.out.println("División: " + resDivision);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
