package p03_shapes;

public class Rectangle extends Shape{

    private double height;
    private double width;

    Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    private double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.getHeight() * 2 + this.getWidth() * 2);
    }

    @Override
    protected void calculateArea() {
        setArea(this.getHeight() * this.getWidth());
    }
}