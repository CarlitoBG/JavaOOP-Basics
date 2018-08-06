package its_in_the_blood.entities.cells.microbes;

public class Fungi extends Microbe{

    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int calculateEnergy() {
        return (super.getHealth() + super.getVirulence()) / 4;
    }
}