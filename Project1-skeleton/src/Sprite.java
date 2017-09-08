import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

// generic class that repesent all worldly objects
/*
All Sprites have:
- pixel locations (x & y)
- unique identity (and a visual location,
						note player omitted due to separate player class)
*/
public class Sprite {
	public static final String PLAYER_LOC = "Project1-skeleton/src/res/player_left.png";
	public static final String FLOOR_LOC = "Project1-skeleton/src/res/floor.png";
	public static final String STONE_LOC = "Project1-skeleton/src/res/stone.png";
	public static final String WALL_LOC = "Project1-skeleton/src/res/wall.png";
	public static final String TARGET_LOC = "Project1-skeleton/src/res/target.png";

	//x & y represent the pixel locations of floor tiles
	private float x;
	private float y;
	private Image pic;

	public Sprite(String image_src, float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		//generating pic from image_src
		if(image_src.equals("floor")){
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
		else if(image_src.equals("player")){
			pic = new Image(PLAYER_LOC);
		}
	}

	public void update(Input input, int delta) {
	}

	public void render(Graphics g) {
		pic.draw(this.x,this.y);

	}
	////////////////////////////////////////////////////////////////////////////
	///////////////////////// Getters and Setters //////////////////////////////
	////////////////////////////////////////////////////////////////////////////

    //xPixel
    public float getX() {
        return this.x;
    }

    public void setX(float xPixel) {
        this.x = xPixel;
    }

    //yPixel
    public float getY() {
        return this.y;
    }

    public void setY(float yPixel) {
        this.y = yPixel;
    }
}
