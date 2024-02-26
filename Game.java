import java.awt.Color;
import java.awt.event.KeyEvent;

import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

public class Game {
	private SquareCollection squareCollection;
	private int tickCount = 0;
	private GameBoard board;
	//private Ball ball;
	private List<Brick> bricks;
	private Bat bat;
	private int gameWidth;
    private int gameHeight;
    private boolean MovingRight;
    private int lives = 3;
    
    private int score = 0;
	
	
	public Game(GameBoard board) {
		this.board = board;
		
		this.squareCollection = new SquareCollection();
		//this.ball = new Ball(100, 100, 20);
		this.gameWidth = board.getWidth();
        this.gameHeight = board.getHeight();
		bricks = new ArrayList<>();
		initializeBricks();
		
	

		 int batWidth = 100;
	     int batHeight = 20;
	     int batX = (board.getWidth() - batWidth) / 2;
	  // Calculate the initial position of the bat along the Y-axis
	  // Ensure the bat starts within the visible area of the game board
	     int batY = board.getHeight() - batHeight - 30; // Place the bat near the bottom of the board but within the visible area

	     bat = new Bat(400, 500, batWidth, batHeight);

	}
	 private void initializeBricks() {
	        int brickWidth = 50;
	        int brickHeight = 20;
	        int gap = 5; // Gap between bricks
	        int rows = 3;
	        int cols = 10;
	        int startX = 50;
	        int startY = 50;

	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	                int x = startX + col * (brickWidth + gap);
	                int y = startY + row * (brickHeight + gap);
	                Color color = Color.RED; // You can change the color based on the row or column if needed
	                int durability = (row + 1) % 2 == 0 ? 3 : 1;
	                bricks.add(new Brick(x, y, brickWidth, brickHeight, color, 1, 10));
	            }
	        }
	        int extraRowDurability = 3; // Set the durability for the extra row
	        Color extraRowColor = Color.BLUE; // Set the color for the extra row
	        for (int col = 0; col < cols; col++) {
	            int x = startX + col * (brickWidth + gap);
	            int y = 40 + (rows - 1) * (brickHeight + gap); // Place the extra row at the back
	            bricks.add(new Brick(x, y, brickWidth, brickHeight, extraRowColor, extraRowDurability, 50)); }
	    }
	 
	 public void increaseScore(int amount) {
	     score += amount;
	 }

	 public void brickHit(Brick brick) {
		    int scoreValue = brick.getScoreValue();
		    increaseScore(scoreValue);
		}

	    

	public void update(Keyboard keyboard) {
		tickCount++;
		if (tickCount % 40 == 0) {
			
		//}
		//for (Brick brick : bricks) {
            //if (ball.collidesWith(brick)) { // Assuming a method to check collision
              //  brick.hit();
            }
		if (lives <= 0) {
            // Game over
            showGameOverScreen();
        } else if (bricks.isEmpty()) {
            // Win
            showWinScreen();
        }
		if (keyboard.isKeyDown(Key.Left)) {
	        bat.moveLeft();
	    } else if (keyboard.isKeyDown(Key.Right)) {
	        bat.moveRight();
	    }

		squareCollection.update(keyboard, board.getHeight());
		//ball.update(keyboard);
		if (squareCollection.squareReachedBottom()) {
			System.exit(0);
		}}

	//}

	public void draw(Graphics2D graphics) {
		squareCollection.draw(graphics);
		//ball.draw(graphics);
		bat.draw(graphics);
		
	    

	}
	private void showGameOverScreen() {
		
	}
	private void showWinScreen() {
		
	}
	public int getScore() {
		return score;
	}
	public void updateScore(int points) {
		score += points;
	}
}
