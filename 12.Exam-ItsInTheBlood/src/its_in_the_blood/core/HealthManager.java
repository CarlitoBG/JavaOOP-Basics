package its_in_the_blood.core;

import its_in_the_blood.entities.Cluster;
import its_in_the_blood.entities.Organism;
import its_in_the_blood.entities.cells.Cell;
import its_in_the_blood.factories.CellFactory;
import its_in_the_blood.factories.ClusterFactory;
import its_in_the_blood.factories.OrganismFactory;

import java.util.HashMap;
import java.util.Map;

import static its_in_the_blood.utilities.Constants.*;

public class HealthManager {

    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new HashMap<>();
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)){
            return this.organisms.get(organismName).toString();
        }
        return null;
    }

    public String createOrganism(String name) {
        if (!this.organisms.containsKey(name)){
            this.organisms.put(name, OrganismFactory.createOrganism(name));
            return String.format(CREATED_ORGANISM, name);
        }else {
            return String.format(ORGANISM_ALREADY_EXISTS, name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.organisms.containsKey(organismName)){
            if (this.organisms.get(organismName).tryAddCluster(ClusterFactory.createCluster(id, rows, cols))){
                return String.format(ORGANISM_CREATED_CLUSTER, organismName, id);
            }
        }
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health,
                          int positionRow, int positionCol, int additionalProperty) {
        if (this.organisms.containsKey(organismName)){
            Cluster cluster = this.organisms.get(organismName).getClustersById(clusterId);
            Cell cell = CellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);

            if (cluster != null && cell != null && cluster.addCell(cell)) {
                return String.format(CREATED_CELL_IN_CLUSTER, organismName, cellId, clusterId);
            }
        }
        return null;
    }

    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName)){
            return this.organisms.get(organismName).activateNextClusterInOrder();
        }
        return null;
    }
}