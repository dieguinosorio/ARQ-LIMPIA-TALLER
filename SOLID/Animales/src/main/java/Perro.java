public class Perro implements Carnivoro {
    @Override
    public void respirar() {
        System.out.println("El perro está respirando.");
    }

    @Override
    public void comer() {
        System.out.println("El perro está comiendo carne.");
    }

    @Override
    public void dormir() {
        System.out.println("El perro está durmiendo.");
    }

    @Override
    public void cazar() {
        System.out.println("El perro está cazando.");
    }
}
