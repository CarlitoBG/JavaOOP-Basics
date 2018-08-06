package its_in_the_blood.factories;

import its_in_the_blood.entities.Organism;

public final class OrganismFactory {

    public static Organism createOrganism(String name){
        return new Organism(name);
    }
}