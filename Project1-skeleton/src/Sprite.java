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

	private static float x;
	private static float y;
	//private String tileID;
	private static Image pic;
	//private String image_src;

	public Sprite(String image_src, float x, float y) throws SlickException {
		Sprite.x = x;
		Sprite.y = y;
		//this.tileID = image_src;
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
	
//Getters 'n' Setters	
	//pic
	public Image getPic() {
        return pic;
    }

    public static void setPic(Image playerPic) {
        pic = playerPic;
    }
    
    
    //xPixel
    public float getX() {
        return x;
    }

    public static void setX(float xPixel) {
        x = xPixel;
    }
    
    
    //yPixel
    public float getY() {
        return x;
    }

    public static void setY(float yPixel) {
        y = yPixel;
    }
}
