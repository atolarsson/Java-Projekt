import java.awt.Color;
import java.awt.Graphics2D;

public class Brick {
    private int x;
    private int y;
    private int width;
    private int height;
    private int durability; // Number of hits needed to destroy the brick
    private int score; // Score awarded when the brick is destroyed
    private Color color;
    private int scoreValue;

    public Brick(int x, int y, int width, int height, Color color, int durability, int scoreValue) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.durability = durability;
        this.scoreValue = scoreValue;
        this.color = color;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getDurability() {
        return durability;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }

    // Getter and setter methods omitted for brevity

    // Method to check if the brick has been destroyed
    public boolean isDestroyed() {
        return durability <= 0;
    }

    // Method to handle the ball hitting the brick
    public void hit() {
        durability--; // Reduce durability
    }

    // Method to get the score awarded when the brick is destroyed
    public int getScoreValue() {
        return scoreValue;
    }
}

