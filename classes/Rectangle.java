package classes;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return 2 * (width + height);
    }

    public void drawFilled() {
        for(int i = 0; i < height; i++) {
            drawFullLine();
        }
    }

    public void draw() {
        drawFullLine();
        for(int i = 0; i < height - 2; i++) {
            drawHollowLine();
        }
        drawFullLine();
    }

    private void drawFullLine() {
        for(int i = 0; i < width; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private void drawHollowLine() {
        System.out.print("* ");
        for(int i = 0; i < width - 2; i++) {
            System.out.print("  ");
        }
        System.out.println("* ");
    }

    // Just for testing
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(20, 12);
        System.out.println("Area: " + rectangle.area());
        System.out.println("Perimeter: " + rectangle.perimeter());

        rectangle.drawFilled();
    }
}
