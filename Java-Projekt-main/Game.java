import java.awt.Color;
import java.awt.event.KeyEvent;

import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

public class Game {
	private SquareCollection squareCollection;
	private int tickCount = 0;
	private GameBoard board;
	private Ball ball;
	private List<Brick> bricks;
	private Bat bat;
	private int gameWidth;
    private int gameHeight;
    private boolean MovingRight;
	
	
	public Game(GameBoard board) {
		this.board = board;
		this.squareCollection = new SquareCollection();
		this.ball = new Ball(100, 100, 20);
		this.gameWidth = board.getWidth();
        this.gameHeight = board.getHeight();
		this.bricks = new ArrayList<>();
		
	

		 int batWidth = 100;
	     int batHeight = 20;
	     int batX = (board.getWidth() - batWidth) / 2;
	  // Calculate the initial position of the bat along the Y-axis
	  // Ensure the bat starts within the visible area of the game board
	     int batY = board.getHeight() - batHeight - 30; // Place the bat near the bottom of the board but within the visible area

	     bat = new Bat(batX, batY, batWidth, batHeight, gameWidth);
	  
	     
	     
		
		bricks.add(new Brick(50, 50, 30, 10, Color.RED, 1));
		
		
		
		

	}

	public void update(Keyboard keyboard) {
		tickCount++;
		if (tickCount % 40 == 0) {
			
		//}
		//for (Brick brick : bricks) {
            //if (ball.collidesWith(brick)) { // Assuming a method to check collision
              //  brick.hit();
            }
		if (keyboard.isKeyDown(Key.Left)) {
	        bat.moveLeft();
	    } else if (keyboard.isKeyDown(Key.Right)) {
	        bat.moveRight();
	    }

		squareCollection.update(keyboard, board.getHeight());
		ball.update(keyboard);
		if (squareCollection.squareReachedBottom()) {
			System.exit(0);
		}}

	//}

	public void draw(Graphics2D graphics) {
		squareCollection.draw(graphics);
		ball.draw(graphics);
		bat.draw(graphics);
		
	    

	}
}
