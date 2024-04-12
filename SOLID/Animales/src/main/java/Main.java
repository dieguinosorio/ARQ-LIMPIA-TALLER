// Main.java
public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        System.out.println("Perro:");
        perro.respirar();
        perro.comer();
        perro.dormir();
        perro.cazar();

        Vaca vaca = new Vaca();
        System.out.println("\nVaca:");
        vaca.respirar();
        vaca.comer();
        vaca.dormir();
        vaca.pastar();
    }
}
