package p03_shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(2, 5);
        Shape circle = new Circle(2.44);

        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println("-----------------");
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}