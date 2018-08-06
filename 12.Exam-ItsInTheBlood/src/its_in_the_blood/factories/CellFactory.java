package its_in_the_blood.factories;

import its_in_the_blood.entities.cells.Cell;
import its_in_the_blood.entities.cells.blood_cells.RedBloodCell;
import its_in_the_blood.entities.cells.blood_cells.WhiteBloodCell;
import its_in_the_blood.entities.cells.microbes.Bacteria;
import its_in_the_blood.entities.cells.microbes.Fungi;
import its_in_the_blood.entities.cells.microbes.Virus;

public final class CellFactory {

    public static Cell createCell(String type, String id, int health, int positionRow, int positionCol, int additionalProperty){
        switch (type){
            case "WhiteBloodCell":
                return new WhiteBloodCell(id, health, positionRow, positionCol, additionalProperty);
            case "RedBloodCell":
                return new RedBloodCell(id, health, positionRow, positionCol, additionalProperty);
            case "Virus":
                return new Virus(id, health, positionRow, positionCol, additionalProperty);
            case "Fungi":
                return new Fungi(id, health, positionRow, positionCol, additionalProperty);
            case "Bacteria":
                return new Bacteria(id, health, positionRow, positionCol, additionalProperty);
        }
        return null;
    }
}