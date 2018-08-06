package its_in_the_blood.entities;

import java.util.ArrayList;
import java.util.List;

import static its_in_the_blood.utilities.Constants.ORGANISM_ACTIVATED_CLUSTER;

public class Organism {

    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public boolean tryAddCluster(Cluster cluster) {
        if (this.getClustersById(cluster.getId()) == null){
            this.clusters.add(cluster);
            return true;
        }
        return false;
    }

    public Cluster getClustersById(String id) {
        for (Cluster cluster : this.clusters) {
            if (cluster.getId().equals(id)){
                return cluster;
            }
        }
        return null;
    }

    public String activateNextClusterInOrder() {
        if (!this.clusters.isEmpty()){
            Cluster firstCluster = this.clusters.remove(0);
            firstCluster.activateCluster();

            this.clusters.add(firstCluster);
            return String.format(ORGANISM_ACTIVATED_CLUSTER, this.name, firstCluster.getId(), firstCluster.getCells().size());
        }
        return null;
    }

    private int getCellsCount() {
        int count = 0;
        for (Cluster cluster : this.clusters) {
            count += cluster.getCells().size();
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Organism - %s\n", this.name))
                .append(String.format("--Clusters: %d\n", this.clusters.size()))
                .append(String.format("--Cells: %d\n", this.getCellsCount()));

        for (Cluster cluster : clusters) {
            sb.append(cluster).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}