package its_in_the_blood.entities.cells.microbes;

public class Virus extends Microbe{

    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int calculateEnergy() {
        return super.getHealth() + super.getVirulence();
    }
}