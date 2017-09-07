

import java.io.FileNotFoundException;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	// THings that exist in this world
	public static final String PLAYER_LOC = "res/player_left.png";
	public static final String FLOOR_LOC = "res/floor.png";
	public static final String STONE_LOC = "res/stone.png";
	public static final String WALL_LOC = "res/wall.png";
	public static final String TARGET_LOC = "res/target.png";

	private static Player player;
	private Sprite[] floorArray;

	public World() throws FileNotFoundException, SlickException {
		floorArray = Loader.loadSprites("res/levels/0.lvl");
	}

	public void update(Input input, int delta) {
		player.update(input, delta);
	}

	public void render(Graphics g) {
		for (Sprite spriteTile : floorArray) {
			spriteTile.render(g);
		}
		player.render(g);
	}

	//getset player
	public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
