import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;

//player is an extension of Sprite

public class Player extends Sprite {

	//note xPos == tile location while x == pixel location
	private static int xPos;
	private static int yPos;
	private static final int STEP = 1;

	public Player(String image_src, float x, float y, int xPos, int yPos)
	throws SlickException {
		super(image_src,x,y);
		Player.xPos = xPos;
		Player.yPos = yPos;
	}
	//player movement
	public void update(Input input, int delta) {
		float x = super.getX();
		float y = super.getY();

		//UDLR movment commands
		if (input.isKeyPressed(Input.KEY_UP)
		&& (!World.isBlocked(xPos,yPos-STEP))) {
			y -= App.TILE_SIZE;
			yPos -= STEP;
		}
		else if (input.isKeyPressed(Input.KEY_DOWN)
		&& (!World.isBlocked(xPos,yPos+STEP))) {
			y += App.TILE_SIZE;
			yPos += STEP;
		}
		else if (input.isKeyPressed(Input.KEY_LEFT)
		&& (!World.isBlocked(xPos-STEP,yPos))) {
			x -= App.TILE_SIZE;
			xPos -= STEP;
		}
		else if (input.isKeyPressed(Input.KEY_RIGHT)
		&& (!World.isBlocked(xPos+STEP,yPos))) {
			x += App.TILE_SIZE;
			xPos += STEP;
		}
		//movement reassigned to be redrawn
		super.setX(x);
		super.setY(y);
	}

	public void render(Graphics g) {
		super.render(g);
	}
}
