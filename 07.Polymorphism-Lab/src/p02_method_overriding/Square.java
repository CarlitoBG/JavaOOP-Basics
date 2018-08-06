package p02_method_overriding;

class Square extends Rectangle{
    Square(double sideA) {
        super(sideA);
    }

    @Override
    public double area() {
        return super.getSideA() * super.getSideA();
    }
}