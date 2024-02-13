import java.awt.Color;
import java.awt.Graphics2D;

	
public class Ball extends Sprite{
	private int dx = 0, dy = 0; //hastighet
	public Ball(int x, int y, int diameter) {
		super(x, y, diameter, diameter);
	}
	@Override
	public void update(Keyboard keyboard) {
		if (keyboard.isKeyDown(Key.Up)) dy = -1;
		else if (keyboard.isKeyDown(Key.Down)) dy = 1;
		else dy = 0;
		
		if (keyboard.isKeyDown(Key.Left)) dx = -1;
		else if (keyboard.isKeyDown(Key.Right)) dx = 1;
		else dx = 0;
		
		setX(getX() + dx);
		setY(getY() + dy);
	}
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.blue);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
	}

}
