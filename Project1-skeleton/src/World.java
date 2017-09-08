
import java.io.FileNotFoundException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	// Where things  exist in this world
	public static final String PLAYER_LOC = "Project1-skeleton/src/res/player_left.png";
	public static final String FLOOR_LOC = "Project1-skeleton/src/res/floor.png";
	public static final String STONE_LOC = "Project1-skeleton/src/res/stone.png";
	public static final String WALL_LOC = "Project1-skeleton/src/res/wall.png";
	public static final String TARGET_LOC = "Project1-skeleton/src/res/target.png";
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

	// Converts a world coordinate to a tile coordinate,
	// and returns if that location is a blocked tile
	public static boolean isBlocked(int xPos, int yPos) {
		if(blockedArray[xPos][yPos]){
			return true;
		} else {
			return false;
		}
	}

///////////////////////////////////////////////////////////////////////////////
//////////////////////////// Getters and Setters //////////////////////////////
///////////////////////////////////////////////////////////////////////////////

	//player
	public Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player newPlayer) {
        World.player = newPlayer;
		System.out.println("player set");
    }

	//blockedArray
	public boolean[][] getBlockedArray() {
        return blockedArray;

    }
    public static void setBlockedArray(boolean[][] newBlockedArray) {
        blockedArray = newBlockedArray;
		System.out.println("block array set");
    }

}
