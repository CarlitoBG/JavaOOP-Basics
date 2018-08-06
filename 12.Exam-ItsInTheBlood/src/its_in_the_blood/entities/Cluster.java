package its_in_the_blood.entities;

import its_in_the_blood.entities.cells.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    public boolean addCell(Cell cell) {
        if (cell.getPositionCol() > this.cols || cell.getPositionRow() > this.rows) {
            return false;
        }

        this.cells.add(cell);
        return true;
    }

    private List<Cell> getOrderedCells() {
        this.cells.sort(Comparator.comparing(Cell::getPositionRow).thenComparing(Cell::getPositionCol));
        return this.cells;
    }

    void activateCluster() {
        if (this.cells.size() > 1){

            Cell fighterCell = getOrderedCells().get(0);

            for (int i = 1; i < getOrderedCells().size(); i++) {
                fighterCell = fighterCell.fight(getOrderedCells().get(i));
            }

            this.cells.clear();
            this.cells.add(fighterCell);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("----Cluster %s\n", this.id));

        for (Cell cell : getOrderedCells()) {
            sb.append(cell).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}