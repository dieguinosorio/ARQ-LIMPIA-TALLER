public class Vaca implements Herbivoro {
    @Override
    public void respirar() {
        System.out.println("La vaca está respirando.");
    }

    @Override
    public void comer() {
        System.out.println("La vaca está comiendo hierba.");
    }

    @Override
    public void dormir() {
        System.out.println("La vaca está durmiendo.");
    }

    @Override
    public void pastar() {
        System.out.println("La vaca está pastando.");
    }
}
