class Rectangle {
    int length;
    int height;

    void setWidth(int len) { this.length = len; }
    void setHeight(int h) { this.height = h; }
}

class Square extends Rectangle {

    @Override
    void setWidth(int len) {
        super.setWidth(len);
        super.setHeight(h);
    }

    @Override
    void setHeight(int hei) {
        super.setWidth(hei);
        super.setHeight(hei);
    }
}

class Client {
    public void calculate(Rectangle rectangle) {

        // this calls the setwidth for rectangle  
        // even if square is passed.
        rectangle.setWidth(12);
    }
}

class Client {
    public void calculate(Rectangle rectangle) {

        rectangle.setHeight(5);
        rectangle.setWidth(4);
        
        // This throws an error, when square is passed
        assertThat(rectange.getArea() == 20);
    }
}

class Shape {
    // OCP Violation
    public void drawShape(Shape shape) {
        if (shape instance of Square) {
            ((Square) shape).draw();
        } else if (shape instance of Circle) {
            ((Circle) shape).draw();
        }
    }

}

class Circle extends Shape {
    public void draw() {
        // make a circle
    }
}

class Square extends Shape {
    public void draw() {
        // make a square
    }
}
