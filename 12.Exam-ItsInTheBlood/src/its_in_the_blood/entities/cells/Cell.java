package its_in_the_blood.entities.cells;

public abstract class Cell {

    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public void addHealth(int health){
        this.health += health;
    }

    public abstract int calculateEnergy();

    public abstract Cell fight(Cell nextCell);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("------Cell %s [%d,%d]\n", this.id, this.positionRow, this.positionCol));
        return sb.toString();
    }
}