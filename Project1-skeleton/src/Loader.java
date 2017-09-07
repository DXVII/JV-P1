import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import org.newdawn.slick.SlickException;


/*
Loader class has:
isBlocked: 		static 2D boolean  array to track if a position in a map is not traversible

loadSprite: 	- points to Player player and assigns its pixel location
				  and 2D array tile postion
 				- creates 1D array of Sprites passing in pixel location into them
				- returns above array(1D) to floorArray in World
*/

public class Loader {
	//Used for CSV: no magic numbers
	//sprite indexing
	public static final int TILE_TYPE = 0;
	public static final int X_COORD = 1;
	public static final int Y_COORD = 2;
	//dimension indexing
	public static final int X_POS = 0;
	public static final int Y_POS = 1;

	//blcok array is 2D list of where a player cannot move
	private static boolean[][] blockArray;
	// array lsit method used for unknown length of txt doc
	private static ArrayList<Sprite> list;
	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return
	 * @throws SlickException
	 * @throws FileNotFoundException
	 */

	public static Sprite[] loadSprites(String filename)
	throws SlickException, FileNotFoundException {
		try (Scanner scanner = new Scanner(new FileReader(filename))) {

			//obtaining World Dimensions
			String[] txtRow = (scanner.nextLine()).split(",");
			int xDim = Integer.parseInt(txtRow[X_POS]);
			int yDim = Integer.parseInt(txtRow[Y_POS]);
			blockArray = new boolean[xDim][yDim];

			//xyDim converted to xyPix to centre
			xDim = (App.SCREEN_WIDTH-(App.TILE_SIZE*xDim))/2;
			yDim = (App.SCREEN_HEIGHT-(App.TILE_SIZE*yDim))/2;
			list = new ArrayList<Sprite>();
			String tileType;
			int xCoord;
			int yCoord;
			float xPix;
			float yPix;

			//obtain floor plan
			while (scanner.hasNextLine()) {
    			txtRow = (scanner.nextLine()).split(",");
				// Separating extracted information
				tileType = txtRow[TILE_TYPE];
				xCoord = Integer.parseInt(txtRow[X_COORD]);
				yCoord = Integer.parseInt(txtRow[Y_COORD]);
				//finding the centred pixel location
				xPix = (float) (App.TILE_SIZE*xCoord + xDim);
				yPix = (float) (App.TILE_SIZE*yCoord + yDim);

				if(!tileType.equals("player")) {
					//generating floorplan
					list.add(new Sprite(tileType, xPix, yPix);
					//generating array of blocked walls
					if(tileType.equals("wall")){
						blockArray[xCoord][yCoord] = true;
					} else {
						blockArray[xCoord][yCoord] = false;
					}
					
				} else {
					// get&setPlayer
					World.setplayer(new Player(tileType, xPix, yPix, xCoord, yCoord));
				}

    		}
		}
		return list.toArray(new Sprite[list.size()]);
	}


	// Converts a world coordinate to a tile coordinate,
	// and returns if that location is a blocked tile
	public static boolean isBlocked(int xPos, int yPos) {
		if(blockArray[xPos][yPos]){
			return true;
		} else {
			return false;
		}
	}


	//getter and setter for xyPixShift
}
