import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Sprite {
	private float xPos;
	private float yPos;
	private Image pic;
	private String image_src;

	public Sprite(String image_src, float x, float y) {
		this.xPos = x;
		this.yPos = y;
		this.image_src = image_src;
		try {
			this.pic = new Image(image_src);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Input input, int delta) {
		if(image_src.equals(App.PLAYER_LOC)){
			if (input.isKeyPressed(Input.KEY_UP) && (yPos > App.TILE_SIZE)) {
				yPos-=App.TILE_SIZE;
			}
			if (input.isKeyPressed(Input.KEY_DOWN) && (yPos < App.SCREEN_HEIGHT-App.TILE_SIZE)) {
				yPos+=App.TILE_SIZE;
			}
			if ((input.isKeyPressed(Input.KEY_LEFT)) && (xPos > App.TILE_SIZE)) {
				xPos-=App.TILE_SIZE;
			}
			if ((input.isKeyPressed(Input.KEY_RIGHT)) && (xPos < App.SCREEN_WIDTH-App.TILE_SIZE)) {
				xPos+=App.TILE_SIZE;
			}
		}
	}

	public void render(Graphics g) {
		pic.drawCentered(xPos,yPos);
	}
}
