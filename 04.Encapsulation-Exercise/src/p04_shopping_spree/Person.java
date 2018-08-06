package p04_shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> bagOfProducts;

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
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

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    boolean hasEnoughMoney(double money){
        return this.money >= money;
    }

    void buyProduct(Product product){
        this.money -= product.getCost();
        this.bagOfProducts.add(product);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.bagOfProducts.size() == 0 ? "Nothing bought"
                        : this.bagOfProducts.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}