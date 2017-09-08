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

	//xPos == tile location, x == pixel location
	private static int xPos;
	private static int yPos;
	private static final int STEP = 1;

	public Player(String image_src, float x, float y, int xPos, int yPos)
	throws SlickException {
		super(image_src,x,y);
		Player.xPos = xPos;
		Player.yPos = yPos;
		super.setPic(new Image(World.PLAYER_LOC));
	}

	public void update(Input input, int delta) {
		//fix ypos limit to is blocked, declare UDLR constants
		float x = super.getX();
		float y = super.getY();

		if (input.isKeyPressed(Input.KEY_UP)
				&& (!World.isBlocked(xPos,yPos-STEP))) {
			y -= App.TILE_SIZE;
			yPos -= STEP;
			super.setY(y);
		}
		if (input.isKeyPressed(Input.KEY_DOWN)
		&& (!World.isBlocked(xPos,yPos+STEP))) {
			y += App.TILE_SIZE;
			yPos += STEP;
			super.setY(y);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)
				&& (!World.isBlocked(xPos-STEP,yPos))) {
			x -= App.TILE_SIZE;
			xPos -= STEP;
			super.setX(x);
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)
				&& (!World.isBlocked(xPos+STEP,yPos))) {
			x += App.TILE_SIZE;
			xPos += STEP;
			super.setX(x);
		}

	}

	public void render(Graphics g) {
		super.render(g);
		System.out.println("player drawn");
	}
}
