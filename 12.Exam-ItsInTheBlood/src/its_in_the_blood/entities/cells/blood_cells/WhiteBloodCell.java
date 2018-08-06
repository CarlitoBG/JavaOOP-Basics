package its_in_the_blood.entities.cells.blood_cells;

public class WhiteBloodCell extends BloodCell{

    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int calculateEnergy() {
        return (super.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format("--------Health: %d | Size: %d | Energy: %d",
                this.getHealth(), this.size, this.calculateEnergy()));
    }
}