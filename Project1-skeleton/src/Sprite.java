import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


public class Sprite {



	private float x;
	private float y;
	private Image pic;
	//private String image_src;

	public Sprite(String image_src, float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		//this.image_src = image_src;
		if(image_src.equals("floor")){
			pic = new Image(World.FLOOR_LOC);
		}
		else if(image_src.equals("stone")){
			pic = new Image(World.STONE_LOC);
		}
		else if(image_src.equals("wall")){
			pic = new Image(World.WALL_LOC);
		}
		else if(image_src.equals("target")){
			pic = new Image(World.TARGET_LOC);
		}
	}

	public void update(Input input, int delta) {
	}

	public void render(Graphics g) {
		pic.draw(x,y);
	}
}
