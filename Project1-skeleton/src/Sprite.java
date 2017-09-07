import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;




public class Sprite {
	
	public static final String PLAYER_LOC = "res/player_left.png";
	public static final String FLOOR_LOC = "res/floor.png";
	public static final String STONE_LOC = "res/stone.png";
	public static final String WALL_LOC = "res/wall.png";
	public static final String TARGET_LOC = "res/target.png";
	
	private float xPos;
	private float yPos;
	private Image pic;
	private String image_src;

	public Sprite(String image_src, float x, float y) throws SlickException {
		this.xPos = x;
		this.yPos = y;
		this.image_src = image_src;
		if(image_src.equals("player")) {
			pic = new Image(PLAYER_LOC);
		}
		else if(image_src.equals("floor")){
			pic = new Image(FLOOR_LOC);
		}
		else if(image_src.equals("stone")){
			pic = new Image(STONE_LOC);
		}
		else if(image_src.equals("wall")){
			pic = new Image(WALL_LOC);
		}
		else if(image_src.equals("target")){
			pic = new Image(TARGET_LOC);
		}
	}

	public void update(Input input, int delta) {
			//fix ypos limit to is blocked
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

	public void render(Graphics g) {
		pic.drawCentered(xPos,yPos);
	}
}
