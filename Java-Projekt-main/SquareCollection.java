import java.util.List;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class SquareCollection {
	private List<ColoredBox> squares = new ArrayList<>(); //lista för fyrkanterna lägg till coloredbox
	private boolean squareReachedBottom = false; //indikera för kollision med botten
	
	public SquareCollection() {
		for (int i = 0; i < 10; i++) {
			squares.add(new RedBox(i * 50, 50, 20, 20)); //lägger till 10 fyrkanter samt position och storlek
		}
	}
	
	public void update(Keyboard keyboard, int boardHeight) { //uppdaterar position och kollar kollision med botten
		for (Sprite square : squares) {
			square.setY(square.getY()+ 1);
			if (square.getY()+ square.getHeight() >= boardHeight) {
				squareReachedBottom = true;
				break;
			}
		}
	}
	public void draw(Graphics2D graphics) { //ritar alla fyrkanter
		for (Sprite square : squares) {
			square.draw(graphics);  //använder draw metoden för varje fyrkant
		}
	}
	public boolean squareReachedBottom() { //getter metod som kollar om en fyrkant har nåt botten
		return squareReachedBottom;
	}
	
}
