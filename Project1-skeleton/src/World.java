

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class World {
	public static final int X_POS = 0;
	public static final int Y_POS = 1;
	public static int[] dim;
	public static Sprite player;
	public Sprite[][] floorArray;
	public static boolean[][] blockArray;

	public World() {
		World.dim = new int[2];s
		this.floorArray = Loader.loadSprites("res/levels/0.lvl");
		
	}

	public void update(Input input, int delta) {
		player.update(input, delta);
	}

	public void render(Graphics g) {
		//for loop
		//floorArray.render(g);
		player.render(g);
	}

	//getset player

}
