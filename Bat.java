
import java.awt.Color;
import java.awt.Graphics2D;

public class Bat extends Sprite {
    private int speed = 5; // Speed at which the bat moves
    private int boundary;

    public Bat(int x, int y, int width, int height, int gameWidth) {
        super(x, y, width, height);
        this.boundary = gameWidth;
    }

    public void moveLeft() {
        setX(Math.max(0, getX() - speed)); // Prevent moving beyond the left edge
    }

    public void moveRight() {
        setX(Math.min(boundary - getWidth(), getX() + speed)); // Prevent moving beyond the right edge
        System.out.println("Before moving right: X = " + getX());
        int newX = getX() + speed;
        System.out.println("New X position: " + newX);
        int maxX = boundary - getWidth();
        System.out.println("Maximum allowed X position: " + maxX);
        newX = Math.min(maxX, newX); // Ensure newX does not exceed maxX
        this.setX(newX);
        System.out.println("After moving right: X = " + getX());
    }

    @Override
    public void update(Keyboard keyboard) {
        if (keyboard.isKeyDown(Key.Left)) {
            moveLeft();
        } else if (keyboard.isKeyDown(Key.Right)) {
            moveRight();
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), getWidth(), getHeight()); // Draw the bat as a rectangle
    }
}
