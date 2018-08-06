package p03_shapes;

public class Circle extends Shape{

    private double radius;

    Circle(double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(Math.PI * 2 * this.getRadius());
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * this.getRadius() * this.getRadius());
    }
}