package its_in_the_blood.entities.cells.microbes;

import its_in_the_blood.entities.cells.Cell;

public abstract class Microbe extends Cell{

    private int virulence;

    Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    int getVirulence() {
        return this.virulence;
    }

    @Override
    public Cell fight(Cell nextCell) {
        while (true) {
            nextCell.addHealth(-this.calculateEnergy());

            if (nextCell.getHealth() > 0) {
                this.addHealth(-nextCell.calculateEnergy());
            } else {
                this.setPositionRow(nextCell.getPositionRow());
                this.setPositionCol(nextCell.getPositionCol());
                return this;
            }

            if (this.getHealth() <= 0) {
                return nextCell;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format("--------Health: %d | Virulence: %d | Energy: %d",
                this.getHealth(), this.virulence, this.calculateEnergy()));
    }
}