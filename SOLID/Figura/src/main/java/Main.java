// Main.java
public class Main {
    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado(5);
        System.out.println("Cuadrado:");
        System.out.println("Area: " + cuadrado.area());
        System.out.println("Perímetro: " + cuadrado.perimetro());

        Rectangulo rectangulo = new Rectangulo(4, 6);
        System.out.println("\nRectángulo:");
        System.out.println("Area: " + rectangulo.area());
        System.out.println("Perímetro: " + rectangulo.perimetro());
    }
}
