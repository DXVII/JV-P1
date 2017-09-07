

import java.io.FileNotFoundException;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	// Where things  exist in this world
	public static final String PLAYER_LOC = "res/player_left.png";
	public static final String FLOOR_LOC = "res/floor.png";
	public static final String STONE_LOC = "res/stone.png";
	public static final String WALL_LOC = "res/wall.png";
	public static final String TARGET_LOC = "res/target.png";

	//the player and the floor layout
	private static Player player;
	private Sprite[] floorArray;

	public World() throws FileNotFoundException, SlickException {
		floorArray = Loader.loadSprites(App.LVL_TXT);
	}

	//update only affect player sprite
	public void update(Input input, int delta) {
		player.update(input, delta);
	}

	// render floor then player to enure player is always after
	public void render(Graphics g) {
		for (Sprite spriteTile : floorArray) {
			spriteTile.render(g);
		}
		player.render(g);
	}
// Actually not sure if this belongs here or somewhere else
	//getset player
	public Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        World.player = player;
    }

}
