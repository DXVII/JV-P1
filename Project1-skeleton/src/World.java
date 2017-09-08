
import java.io.FileNotFoundException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	// Where things  exist in this world
	public static final String LVL_TXT = "Project1-skeleton/src/res/lvl.csv";

	//the player and the floor layout
	private static Sprite[] floorArray;
	private static Player player;
	private static boolean[][] blockedArray;

	public World() throws FileNotFoundException, SlickException {
		/* loading sprite here:
			- passes array of Sprites
			- instantiates a blocked off walls array
			- instantiates a player
		*/
		floorArray = Loader.loadSprites(World.LVL_TXT);
	}

	//update only affects player sprite
	public void update(Input input, int delta) {
		player.update(input, delta);
	}

	// render floor then player to ensure player is always above map
	public void render(Graphics g) {
		for (Sprite spriteTile : floorArray) {
			spriteTile.render(g);
		}
		player.render(g);
	}

	// returns if that location is a blocked tile
	public static boolean isBlocked(int xPos, int yPos) {
		return blockedArray[xPos][yPos];
	}

///////////////////////////////////////////////////////////////////////////////
//////////////////////////// Getters and Setters //////////////////////////////
///////////////////////////////////////////////////////////////////////////////

	//player
	public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player newPlayer) {
        World.player = newPlayer;
    }

	//blockedArray
	public static boolean[][] getBlockedArray() {
        return blockedArray;

    }
    public static void setBlockedArray(boolean[][] newBlockedArray) {
        blockedArray = newBlockedArray;
    }

}
