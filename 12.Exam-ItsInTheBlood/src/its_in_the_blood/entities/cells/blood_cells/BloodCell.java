package its_in_the_blood.entities.cells.blood_cells;

import its_in_the_blood.entities.cells.Cell;

public abstract class BloodCell extends Cell{

    BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public Cell fight(Cell nextCell) {
        this.addHealth(nextCell.getHealth());
        this.setPositionRow(nextCell.getPositionRow());
        this.setPositionCol(nextCell.getPositionCol());
        return this;
    }
}