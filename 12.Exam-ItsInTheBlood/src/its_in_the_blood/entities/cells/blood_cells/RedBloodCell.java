package its_in_the_blood.entities.cells.blood_cells;

public class RedBloodCell extends BloodCell{

    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public int calculateEnergy() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format("--------Health: %d | Velocity: %d | Energy: %d",
                this.getHealth(), this.velocity, this.calculateEnergy()));
    }
}