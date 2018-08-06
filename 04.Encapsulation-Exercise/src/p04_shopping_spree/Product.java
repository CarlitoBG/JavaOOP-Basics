package p04_shopping_spree;

class Product {

    private String name;
    private double cost;

    Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        if (cost < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }
}