package p02_method_overriding;

class Rectangle {
    private double sideA;
    private double sideB;

    Rectangle(double sideA) {
        this.sideA = sideA;
    }

    Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    double getSideA() {
        return this.sideA;
    }

    private double getSideB() {
        return this.sideB;
    }

    public double area(){
        return getSideA() * getSideB();
    }
}