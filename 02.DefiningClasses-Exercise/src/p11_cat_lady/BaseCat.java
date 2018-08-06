package p11_cat_lady;

public abstract class BaseCat {

    private String name;
    private String type;

    protected BaseCat(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.type + " " + this.name;
    }
}