import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

public class Game {
	private SquareCollection squareCollection;
	private int tickCount = 0;
	private GameBoard board;
	private Ball ball;
	
	
	
	public Game(GameBoard board) {
		this.board = board;
		this.squareCollection = new SquareCollection();
		this.ball = new Ball(100, 100, 20);
		
		
		
		

	}

	public void update(Keyboard keyboard) {
		tickCount++;
		if (tickCount % 40 == 0) {
			
		}
		squareCollection.update(keyboard, board.getHeight());
		ball.update(keyboard);
		if (squareCollection.squareReachedBottom()) {
			System.exit(0);
		}

	}

	public void draw(Graphics2D graphics) {
		squareCollection.draw(graphics);
		ball.draw(graphics);

	}
}
