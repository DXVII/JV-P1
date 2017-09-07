import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

//player is an extension of Sprite

/*
player variant has extra:
tile location (to check against "Loader.isBlocked")

Still unsure about the rendering and how it works with super classes
*/

public class Player extends Sprite {

	public static final String PLAYER_LOC = "res/player_left.png";
	//xPos == tiles, x == pixels
	private static int xPos;
	private static int yPos;
	private static final int STEP = 1;
	//private String image_src;

	public Player(String image_src, float x, float y, int xPos, int yPos)
	throws SlickException {
		super(image_src,x,y);
		Player.xPos = xPos;
		Player.yPos = yPos;
		//this.image_src = image_src;
		super.setPic(new Image(PLAYER_LOC));
	}

	public void update(Input input, int delta) {
		//fix ypos limit to is blocked, declare UDLR constants
		float x = super.getX();
		float y = super.getY();
		
		if (input.isKeyPressed(Input.KEY_UP) 
				&& (!Loader.isBlocked(xPos,yPos-STEP))) {
			y -= App.TILE_SIZE;
			yPos -= STEP;
		}
		else if (input.isKeyPressed(Input.KEY_DOWN)
				&& (!Loader.isBlocked(xPos,yPos+STEP))) {
			y += App.TILE_SIZE;
			yPos += STEP;
		}
		else if (input.isKeyPressed(Input.KEY_LEFT)
				&& (!Loader.isBlocked(xPos+STEP,yPos))) {
			x -= App.TILE_SIZE;
			xPos += STEP;
		}
		else if (input.isKeyPressed(Input.KEY_RIGHT)
				&& (!Loader.isBlocked(xPos-STEP,yPos))) {
			x += App.TILE_SIZE;
			xPos += STEP;
		}
		super.setX(x);
		super.setY(y);
	}

	public void render(Graphics g) {
		super.render(g);
	}
}
