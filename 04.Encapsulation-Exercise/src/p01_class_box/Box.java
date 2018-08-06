package p01_class_box;

public class Box {

    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calcSurfaceArea() {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calcLateralSurfaceArea() {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double volume() {
        return this.length * this.width * this.height;
    }
}