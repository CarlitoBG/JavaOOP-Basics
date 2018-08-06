package p03_wild_farm;

public abstract class Food {

    private int quantity;

    Food(int quantity) {
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}