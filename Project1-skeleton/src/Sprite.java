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
	//x&y represent the pixel locations of floor tiles
	private float x;
	private float y;
	private Image pic;

	public Sprite(String image_src, float x, float y) throws SlickException {
		System.out.println("Sprite under construction");
		this.x = x;
		this.y = y;
		//this.tileID = image_src;
		if(image_src.equals("floor")){
			pic = new Image(World.FLOOR_LOC);
			System.out.println("recognised image");
		}
		else if(image_src.equals("stone")){
			pic = new Image(World.STONE_LOC);
			System.out.println("recognised image");
		}
		else if(image_src.equals("wall")){
			pic = new Image(World.WALL_LOC);
			System.out.println("recognised image");
		}
		else if(image_src.equals("target")){
			pic = new Image(World.TARGET_LOC);
			System.out.println("recognised image");
		} else{
			System.out.println("unrecognised image");
		}
	}

	public void update(Input input, int delta) {
	}

	public void render(Graphics g) {
		pic.draw(this.x,this.y);
		System.out.println("pic drawn");

	}
	///////////////////////////////////////////////////////////////////////////////
	//////////////////////////// Getters and Setters //////////////////////////////
	///////////////////////////////////////////////////////////////////////////////

	//pic
	public Image getPic() {
        return this.pic;
    }

    public void setPic(Image playerPic) {
        this.pic = playerPic;
    }


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
