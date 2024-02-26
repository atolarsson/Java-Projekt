import java.awt.*;




public class Brick extends Sprite {
    private int hitPoints; // Number of hits required to break the brick
    private boolean isDestroyed; // Indicates if the brick is destroyed
    private Color color; // The color of the brick, which could indicate its strength or special property

    public Brick(int x, int y, int width, int height, Color color, int hitPoints) {
        super(x, y, width, height);
        this.color = color;
        this.hitPoints = hitPoints;
        this.isDestroyed = false;
    }

    public void hit() {
        hitPoints--;
        if (hitPoints <= 0) {
            isDestroyed = true;
            // Handle the brick destruction here (e.g., update score, generate power-up)
        }
        // Optional: Change color or appearance to indicate damage
    }
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    
    public void draw(Graphics2D graphics) {
        if (!isDestroyed) {
            graphics.setColor(this.color); // Set the brick color
            graphics.fillRect(getX(), getY(), getWidth(), getHeight()); // Draw the brick as a filled rectangle
            // Optionally, add more graphics details like borders
        }
    }

           
        
    

   
    }


