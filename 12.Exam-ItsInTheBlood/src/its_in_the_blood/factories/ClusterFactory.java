package its_in_the_blood.factories;

import its_in_the_blood.entities.Cluster;

public final class ClusterFactory {

    public static Cluster createCluster(String id, int rows, int cols){
        return new Cluster(id, rows, cols);
    }
}