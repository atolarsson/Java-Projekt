import java.awt.Color;
import java.awt.Graphics2D;

public class Bat extends Sprite {
    private int speed = 5; // Speed at which the bat moves

    public Bat(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void moveLeft() {
        setX(Math.max(0, getX() - speed)); // Prevent moving beyond the left edge
    }

    public void moveRight() {
        setX(Math.min(getX() + speed, 800 - getWidth())); // Prevent moving beyond the right edge
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

