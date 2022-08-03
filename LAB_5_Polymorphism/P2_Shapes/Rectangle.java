package OOP.LAB_5_Polymorphism.P2_Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    double calculatePerimeter() {
        super.setPerimeter((2 * height) + (2 * width));
        return super.getPerimeter();
    }

    @Override
    double calculateArea() {
        super.setArea(height * width);
        return super.getArea();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
