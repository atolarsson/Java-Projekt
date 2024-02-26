import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
import java.util.List;
import java.util.ArrayList;

public class GameBoard extends JComponent {
    private final int FPS = 40;
    private Game game;
    private Keyboard keyboard;
    private List<Brick> bricks; // Add a list of bricks
    private Score score;

    public GameBoard() {
        keyboard = new Keyboard();
        game = new Game(this);
        
        this.score = new Score();
        // Initialize the list of bricks
        bricks = new ArrayList<>();
        // Add bricks to the list (for example, three rows with ten bricks each)
        initializeBricks();
            }
        
    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        
        if (game != null) {
        	graphics.setColor(Color.WHITE);
        	graphics.setFont(new Font("Arial", Font.PLAIN,20));
        	graphics.drawString("Score: " + game.getScore(),10, 200);
        }
        

        // Draw bricks
        for (Brick brick : bricks) {
            graphics.setColor(brick.getColor());
            graphics.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        }

        game.draw(graphics);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        if (e.getID() == KeyEvent.KEY_PRESSED)
            keyboard.processKeyEvent(e.getKeyCode(), true);
        else if (e.getID() == KeyEvent.KEY_RELEASED)
            keyboard.processKeyEvent(e.getKeyCode(), false);
    }

    public void start() {
        while (true) {
            game.update(keyboard);
            try {
                Thread.sleep(1000 / FPS); //Throttle thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
    private void initializeBricks() {
        int brickWidth = 75;
        int brickHeight = 20;
        int gap = 5; // Gap between bricks
        int rows = 4; // Increase the number of rows
        int cols = 10;
        int startX = 3;
        int startY = 50;

        // Regular rows of bricks
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols; col++) {
                int x = startX + col * (brickWidth + gap);
                int y = startY + row * (brickHeight + gap);
                Color color = Color.RED; // Regular brick color
                int durability = (row + 1) % 2 == 0 ? 3 : 1; // Alternate between durability 1 and 3
                bricks.add(new Brick(x, y, brickWidth, brickHeight, color, durability, 25));
            }
        }

        // Extra row at the back with higher durability and a different color
        int extraRowDurability = 3; // Set the durability for the extra row
        Color extraRowColor = Color.ORANGE; // Set the color for the extra row
        for (int col = 0; col < cols; col++) {
            int x = startX + col * (brickWidth + gap);
            int y = startY + (rows - 5) * (brickHeight + gap); // Place the extra row at the back
            bricks.add(new Brick(x, y, brickWidth, brickHeight, extraRowColor, extraRowDurability, 100));
            
                   
        
        }
        int ExtraRowDurability = 5; // Set the durability for the extra row
        Color ExtraRowColor = Color.YELLOW; // Set the color for the extra row
        for (int col = 0; col < cols; col++) {
            int x = startX + col * (brickWidth + gap);
            int y = startY + (rows - 6) * (brickHeight + gap); // Place the extra row at the back
            bricks.add(new Brick(x, y, brickWidth, brickHeight, ExtraRowColor, ExtraRowDurability, 200));
    }
    
}}

