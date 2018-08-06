package p09_google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Children> children;
    private List<Parent> parents;
    private List<Pokemon> pokemons;

    Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void setCompany(Company company) {
        this.company = company;
    }

    void setCar(Car car) {
        this.car = car;
    }

    List<Children> getChildren() {
        return children;
    }

    List<Parent> getParents() {
        return parents;
    }

    List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(System.lineSeparator());

        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null){
            sb.append(this.company.toString()).append(System.lineSeparator());
        }

        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null){
            sb.append(this.car.toString()).append(System.lineSeparator());
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        if (this.pokemons.size() != 0){
            for (Pokemon pokemon : this.pokemons) {
                sb.append(pokemon.toString()).append(System.lineSeparator());
            }
        }

        sb.append("Parents:").append(System.lineSeparator());
        if (this.parents.size() != 0){
            for (Parent parent : this.parents) {
                sb.append(parent.toString()).append(System.lineSeparator());
            }
        }

        sb.append("Children:").append(System.lineSeparator());
        if (this.children.size() != 0){
            for (Children child : this.children) {
                sb.append(child.toString()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}