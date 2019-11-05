class AreaOfTwoRectangles {    
    public static int getOverallArea(Rectangle r1, Rectangle r2) {
        int area1 = r1.area();
        int area2 = r2.area();

        int intersectionLeft = Math.max(r1.x1, r2.x1);
        int intersectionRight = Math.min(r1.x2, r2.x2);

        int intersectionBottom = Math.min(r1.y1, r2.y1);
        int intersectionTop = Math.max(r1.y2, r2.y2);

        int interSectionArea = 0;
        if (intersectionLeft < intersectionRight && intersectionBottom < intersectionTop) {
            interSectionArea = Math.abs(right - left) * Math.abs(top - bottom);
        }

        return area1 + area2 - interSectionArea;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(1, 1, 3, 4);
        Rectangle rect2 = new Rectangle(2, 2, 5, 6);
        System.out.println(getOverallArea(rect1, rect2));
    }
}

class Rectangle {
    int x1, y1;
    int x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        
        this.x2 = x2;
        this.y2 = y2;
    }

    public int area() {
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        return width * height;
    }
}
